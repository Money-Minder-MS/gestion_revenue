package com.example.revenue.Repositories;

import com.example.revenue.Models.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevenueRepo extends JpaRepository<Revenue, Long> {
    List<Revenue> findByUserId(Long userId);

}
