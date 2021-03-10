package com.billstracker9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.billstracker9.entities.Payee;
import com.billstracker9.services.PayeeService;

/**
 * @author Mohamed Abouregila
 *
 *this controller where the requests of(user login/payee/new payee/addpayee) get mapped to
 */
@Controller
@SessionAttributes("userLogin")
public class PayeeController {
	
	PayeeService payeeService=new PayeeService();

	
	 @ModelAttribute("Payee")
	  public Payee populatePayee() {
	    Payee payee = new Payee();
	    
	    return payee;
	  }
	 
	 
	 @RequestMapping(value = "/newPayee")
	    public String newPayeeHandler() {
	        return "newPayee";
	    }
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/addPayee")
	    public ModelAndView addPayeeHandler(@ModelAttribute() Payee payee, BindingResult bindingResult, Model model) {
	      //  userValidator.validate(userForm, bindingResult);
		 	ModelAndView mav = new ModelAndView();
		 	String view="newPayee";


	        
	        

	        if(payeeService.addPayee(payee)) {
		 		
	        	mav.addObject("sucessmessage", "Payee Added Successfully");


	        }else {
	        	mav.addObject("errormessage", " Failed, pls make sure that the payee doesn't exist, and try later");

	        }
			mav.setViewName(view); // jsp
			return mav;

	        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	    }
	 
	 

}
