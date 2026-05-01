package com.example.revenue.Services;

import com.example.revenue.Models.Revenue;
import com.example.revenue.Repositories.RevenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private RevenueRepo revenueRepo;

    // ✅ CREATE
    public Revenue addRevenue(Revenue revenue) {
        return revenueRepo.save(revenue);
    }

    // ✅ READ BY ID
    public Revenue getRevenueById(Long id) {
        return revenueRepo.findById(id).orElse(null);
    }

    // ✅ READ ALL
    public List<Revenue> getAllRevenues() {
        return revenueRepo.findAll();
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
            existingRevenue.setUserId(newRevenue.getUserId());

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