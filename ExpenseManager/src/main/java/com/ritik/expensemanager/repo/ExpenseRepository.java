package com.ritik.expensemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ritik.expensemanager.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
