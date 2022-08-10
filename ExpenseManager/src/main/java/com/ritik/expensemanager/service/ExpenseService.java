package com.ritik.expensemanager.service;

import java.util.List;

import com.ritik.expensemanager.model.Expense;

public interface ExpenseService {

	List<Expense> findAll();
	void save(Expense expense);
	Expense findById(Long id);
	void delete(Long id);
}
