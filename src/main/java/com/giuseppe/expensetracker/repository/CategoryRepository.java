package com.giuseppe.expensetracker.repository;

import com.giuseppe.expensetracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
