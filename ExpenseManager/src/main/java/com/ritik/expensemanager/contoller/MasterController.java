package com.ritik.expensemanager.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ritik.expensemanager.model.Expense;
import com.ritik.expensemanager.service.ExpenseService;

@Controller
public class MasterController {
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView("home");
		mav.addObject("message","List of expenses");
		List<Expense> expenses= expenseService.findAll();
		mav.addObject("expenses", expenses);
		System.out.println(expenses);
		return mav;
	}
	
	@RequestMapping("/expense")
	public ModelAndView addexpense() {
		ModelAndView mav = new ModelAndView("expense");
		mav.addObject("expense",new Expense());
		
		return mav;
	}
	@RequestMapping(value="/expense",method = RequestMethod.POST)
	public String save(@ModelAttribute("expense") Expense expense) {
		expense.setCreated_at(System.currentTimeMillis());
		expenseService.save(expense);
		return "redirect:/";
	}
	@RequestMapping(value="/expense/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("expense");
		Expense expense = expenseService.findById(id);
		mav.addObject("expense",expense);
		return mav;
	}
	
	@RequestMapping(value="/expense/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/";
	}
	
	
	
}
