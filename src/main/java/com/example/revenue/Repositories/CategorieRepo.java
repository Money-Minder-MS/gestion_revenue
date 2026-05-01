package com.example.revenue.Repositories;

import com.example.revenue.Models.Categorie_Revenue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie_Revenue, Long> {
}
