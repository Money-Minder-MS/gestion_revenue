package com.example.revenue.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Revenue {
    @GeneratedValue
    @Id
    private Long id;
    private Double amount;
    private String source;
    private LocalDate date;
    private String description;
    private Long categoryId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSource() {
        return source;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Revenue(Long id, Double amount, String source, LocalDate date, String description, Long categoryId, Long userId) {
        this.id = id;
        this.amount = amount;
        this.source = source;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Revenue(Double amount, String source, LocalDate date, String description, Long categoryId, Long userId) {
        this.amount = amount;
        this.source = source;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Revenue() {
    }
}
