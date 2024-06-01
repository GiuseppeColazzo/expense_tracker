package com.giuseppe.expensetracker.controller;

import com.giuseppe.expensetracker.dto.ExpenseDTO;
import com.giuseppe.expensetracker.entity.Expense;
import com.giuseppe.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getAllExpenses(@PathVariable Long userId){
        return expenseService.getAllExpensesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@Valid @RequestBody ExpenseDTO expenseDTO){
        Expense expense = expenseService.saveExpense(expenseDTO);
        return ResponseEntity.ok(expense);

    }
}
