package com.giuseppe.expensetracker.mapper;

import com.giuseppe.expensetracker.dto.ExpenseDTO;
import com.giuseppe.expensetracker.entity.Category;
import com.giuseppe.expensetracker.entity.Expense;
import com.giuseppe.expensetracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Expense map(ExpenseDTO expenseDTO, Category category, User user){
        Expense expense = new Expense();
        expense.setAmount(expenseDTO.getAmount());
        expense.setPurchase_date(expenseDTO.getPurchaseDate());
        expense.setCategory(category);
        expense.setUser(user);
        expense.setStore(expenseDTO.getStore());
        expense.setNotes(expenseDTO.getNotes());

        return expense;
    }

    public Expense map(Expense expense, ExpenseDTO expenseDTO, Category category, User user){
        expense.setAmount(expenseDTO.getAmount());
        expense.setPurchase_date(expenseDTO.getPurchaseDate());
        expense.setCategory(category);
        expense.setUser(user);
        expense.setStore(expenseDTO.getStore());
        expense.setNotes(expenseDTO.getNotes());

        return expense;
    }
}
