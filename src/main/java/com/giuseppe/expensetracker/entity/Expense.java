package com.giuseppe.expensetracker.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "purchase_date")
    private Date purchase_date;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "store")
    private String store;

    @Column(name = "notes")
    private String notes;

    @Column(name = "input_date")
    private Timestamp input_date;

    public Expense(BigDecimal amount, Date purchase_date, Category category, User user, String store, String notes, Timestamp input_date) {
        this.amount = amount;
        this.purchase_date = purchase_date;
        this.category = category;
        this.user = user;
        this.store = store;
        this.notes = notes;
        this.input_date = input_date;
    }

    public Expense(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Timestamp getInput_date() {
        return input_date;
    }

    public void setInput_date(Timestamp input_date) {
        this.input_date = input_date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", purchase_date=" + purchase_date +
                ", category=" + category +
                ", user=" + user +
                ", store='" + store + '\'' +
                ", notes='" + notes + '\'' +
                ", input_date=" + input_date +
                '}';
    }
}
