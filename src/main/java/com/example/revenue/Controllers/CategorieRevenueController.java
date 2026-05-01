package com.example.revenue.Controllers;
import com.example.revenue.Models.Categorie_Revenue;
import com.example.revenue.Services.CategorieRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieRevenueController {

    @Autowired
    private CategorieRevenueService categorieRevenueService;

    // ✅ GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie_Revenue> getCategoryById(@PathVariable Long id) {

        Categorie_Revenue category = categorieRevenueService.getCategoryById(id);

        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<Categorie_Revenue>> getAllCategories() {
        return new ResponseEntity<>(categorieRevenueService.getAllCategories(), HttpStatus.OK);
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<Categorie_Revenue> addCategory(@RequestBody Categorie_Revenue category) {
        Categorie_Revenue created = categorieRevenueService.addCategory(category);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Categorie_Revenue> updateCategory(@PathVariable Long id,
                                                            @RequestBody Categorie_Revenue newCategory) {

        Categorie_Revenue updated = categorieRevenueService.updateCategory(id, newCategory);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

        String response = categorieRevenueService.deleteCategory(id);

        if (response.equals("Category supprimée")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}