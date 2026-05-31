package com.example.revenue.Services;
import com.example.revenue.NotificationPublisher;
import com.example.revenue.Models.Revenue;
import com.example.revenue.RabbitMQConfig;
import com.example.revenue.Repositories.RevenueRepo;
import com.example.revenue.UserClient;
import com.example.revenue.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RevenueService {
    @Autowired
    private NotificationPublisher notificationPublisher;

    @Autowired
    private RevenueRepo revenueRepo;

    @Autowired
    private UserClient userClient;

    // ✅ CREATE — userId injecté automatiquement depuis le header
    public ResponseEntity<?> addRevenue(Revenue revenue, Long userId) {

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Aucun utilisateur connecté. Ajout impossible.");
        }

        try {
            UserDTO user = userClient.getUserById(userId);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Utilisateur introuvable.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Service utilisateur indisponible.");
        }

        revenue.setUserId(userId);

        // ✅ Save first, then publish notification
        Revenue saved = revenueRepo.save(revenue);

        Map<String, Object> data = new HashMap<>();
        data.put("montant", saved.getAmount());
        data.put("source",  saved.getSource());

        notificationPublisher.publier(
                RabbitMQConfig.KEY_REVENUE,
                userId,
                "Nouveau revenu ajouté : " + saved.getSource() + " (" + saved.getAmount() + " DT)",
                data
        );

        // ✅ Return AFTER the notification is published
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ✅ READ BY ID
    public Revenue getRevenueById(Long id) {
        return revenueRepo.findById(id).orElse(null);
    }

    // ✅ READ ALL
    public List<Revenue> getAllRevenues() {
        return revenueRepo.findAll();
    }

    // ✅ READ BY USER
    public List<Revenue> getRevenuesByUserId(Long userId) {
        return revenueRepo.findByUserId(userId);
    }

    // ✅ UPDATE
    public Revenue updateRevenue(Long id, Revenue newRevenue) {
        if (revenueRepo.findById(id).isPresent()) {

            Revenue existingRevenue = revenueRepo.findById(id).get();

            existingRevenue.setAmount(newRevenue.getAmount());
            existingRevenue.setSource(newRevenue.getSource());
            existingRevenue.setDate(newRevenue.getDate());
            existingRevenue.setDescription(newRevenue.getDescription());
            existingRevenue.setCategoryId(newRevenue.getCategoryId());
            // ⚠️ userId NON modifiable lors d'un update

            return revenueRepo.save(existingRevenue);
        } else {
            return null;
        }
    }

    // ✅ DELETE
    public String deleteRevenue(Long id) {
        if (revenueRepo.findById(id).isPresent()) {
            revenueRepo.deleteById(id);
            return "Revenue supprimé";
        } else {
            return "Revenue non trouvé";
        }
    }
}