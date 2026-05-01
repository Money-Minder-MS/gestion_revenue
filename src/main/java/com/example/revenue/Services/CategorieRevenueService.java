package com.example.revenue.Services;

import com.example.revenue.Models.Categorie_Revenue;
import com.example.revenue.Repositories.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieRevenueService {

    @Autowired
    private CategorieRepo categorieRevenueRepo;

    // ✅ CREATE
    public Categorie_Revenue addCategory(Categorie_Revenue category) {
        return categorieRevenueRepo.save(category);
    }

    // ✅ READ BY ID
    public Categorie_Revenue getCategoryById(Long id) {
        return categorieRevenueRepo.findById(id).orElse(null);
    }

    // ✅ READ ALL
    public List<Categorie_Revenue> getAllCategories() {
        return categorieRevenueRepo.findAll();
    }

    // ✅ UPDATE
    public Categorie_Revenue updateCategory(Long id, Categorie_Revenue newCategory) {
        if (categorieRevenueRepo.findById(id).isPresent()) {

            Categorie_Revenue existing = categorieRevenueRepo.findById(id).get();

            existing.setName(newCategory.getName());
            existing.setDescription(newCategory.getDescription());

            return categorieRevenueRepo.save(existing);
        } else {
            return null;
        }
    }

    // ✅ DELETE
    public String deleteCategory(Long id) {
        if (categorieRevenueRepo.findById(id).isPresent()) {
            categorieRevenueRepo.deleteById(id);
            return "Category supprimée";
        } else {
            return "Category non trouvée";
        }
    }
}