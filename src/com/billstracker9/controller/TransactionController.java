package com.billstracker9.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.billstracker9.entities.Payee;
import com.billstracker9.entities.Transaction;
import com.billstracker9.services.PayeeService;
import com.billstracker9.services.TransactionService;
import com.billstracker9.services.UserServices;

/**
 * @author Mohamed Abouregila
 * 
 * all transactions requests get mapped to this controller
 *
 */
@Controller
@SessionAttributes("userLogin")
public class TransactionController{
	
	TransactionService transactionService=new TransactionService();
	PayeeService payeeService=new PayeeService();
	UserServices userServices=new UserServices();

	
	 @ModelAttribute("Transaction")
	  public Transaction populateTransaction() {
	    Transaction transaction = new Transaction();
	    
	    return transaction;
	  }
	 
	 
	 @RequestMapping(value = "/newBill")
	    public ModelAndView newBillHandler() {
		 ModelAndView mav= new ModelAndView();
		 List<Payee> payeeList=payeeService.getAllPayee();
		 System.out.println(payeeList);
		 
		 mav.addObject("payeeList", payeeList);
		 mav.setViewName("newBill");
	        return mav;
	    }
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/addBill")
	    public @ResponseBody ModelAndView addPayeeHandler(@ModelAttribute() Transaction transaction, BindingResult bindingResult, HttpSession session,
	    		@RequestParam("payeeName") String payeeName,@RequestParam("accountNumber") String accountNumber
	    		,@RequestParam("transactionDate") Date transactionDate, @RequestParam("dueDate") Date dueDate) {
	      //  userValidator.validate(userForm, bindingResult);
		 	ModelAndView mav = new ModelAndView();
		 	String view="newBill";


	        transaction.setTransactionDate(transactionDate);
	        transaction.setDueDate(dueDate);
	        //the bills credit the payee
	        transaction.setAmount(-transaction.getAmount());
	        System.out.println(transaction);


	        if(transactionService.addTransaction(transaction, payeeName, accountNumber, userServices.getUserBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId()))) {
		 		
	        	mav.addObject("sucessmessage", "Bill Added Successfully");


	        }else {
	        	mav.addObject("errormessage", " Failed, pls make sure that the bill is not allready there, and try later");

	        }
	        List<Payee> payeeList=payeeService.getAllPayee();			 
			 mav.addObject("payeeList", payeeList);
			mav.setViewName(view); // jsp
			return mav;

	        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	    }


}
