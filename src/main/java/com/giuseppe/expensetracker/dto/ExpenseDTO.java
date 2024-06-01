package com.giuseppe.expensetracker.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Date;

public class ExpenseDTO {
    private Long id;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private Date purchaseDate;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long userId;

    @Size(max = 255)
    private String store;

    @Size(max = 255)
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
