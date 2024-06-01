package com.giuseppe.expensetracker.service;

import com.giuseppe.expensetracker.entity.Category;
import com.giuseppe.expensetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> findCategoryById(Long id){
        return categoryRepository.findById(id);
    }
}
