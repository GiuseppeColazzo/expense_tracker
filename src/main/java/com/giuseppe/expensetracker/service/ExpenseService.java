package com.giuseppe.expensetracker.service;

import com.giuseppe.expensetracker.dto.ExpenseDTO;
import com.giuseppe.expensetracker.entity.Category;
import com.giuseppe.expensetracker.entity.Expense;
import com.giuseppe.expensetracker.entity.User;
import com.giuseppe.expensetracker.mapper.Mapper;
import com.giuseppe.expensetracker.repository.CategoryRepository;
import com.giuseppe.expensetracker.repository.ExpenseRepository;
import com.giuseppe.expensetracker.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    public List<Expense> getAllExpenses(){
        return  expenseRepository.findAll();
    }

    public List<Expense> getAllExpensesByUserId(Long userId){
        return expenseRepository.findByUserId(userId);
    }

    @Transactional
    public Expense saveExpense(ExpenseDTO expenseDTO){

        User user = userRepository.findById(expenseDTO.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        Category category = categoryRepository.findById(expenseDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));

        Expense expense = mapper.map(expenseDTO,category,user);

        return expenseRepository.save(expense);
    }

    @Transactional
    public Expense updateExpense(Long expenseId,ExpenseDTO expenseDTO){


        Expense existingExpense = expenseRepository.findById(expenseId).orElseThrow(()->new RuntimeException("Expense not found"));
        User user = userRepository.findById(expenseDTO.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        Category category = categoryRepository.findById(expenseDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));

        return expenseRepository.save(mapper.map(existingExpense, expenseDTO,category,user));

    }

    @Transactional
    public void deleteExpense(Long expenseId){
        expenseRepository.deleteById(expenseId);
    }
}
