package com.billstracker9.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.billstracker9.entities.Transaction;
import com.billstracker9.entities.User;
import com.billstracker9.services.PayeeService;
import com.billstracker9.services.TransactionService;
import com.billstracker9.services.UserServices;



@Controller
@SessionAttributes("userLogin")
public class UserController {
	@ModelAttribute("userLogin")
	public User setUpUser() {
		return new User();
	}

	UserServices userServices=new UserServices();
	PayeeService payeeService=new PayeeService();
	TransactionService transactionService=new TransactionService();


	// nav main menu
	
	@RequestMapping("/")
	public String indexHandler() {
		return "login";  //jsp
	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ModelAndView login(@ModelAttribute() User user, @SessionAttribute("userLogin") User userSession, Model model) {
		 	System.out.println();
		 	ModelAndView mav = new ModelAndView();
		 	String view="login";
		 	
		 	User foundUser=userServices.getUserByEmail(user.getEmail());

		 	if(foundUser!=null && foundUser.getPassword().equals(user.getPassword())) {
		 		userServices.updateSessionId(user.getEmail(), RequestContextHolder.currentRequestAttributes().getSessionId());
		 		userSession.setEmail(foundUser.getEmail());
		 		userSession.setPassword(foundUser.getPassword());
		 		userSession.setfName(foundUser.getfName());
		 		model.addAttribute("userEmail", user.getEmail());
		 		mav.addObject("user", user);
		 		//System.out.println("login Handler User: "+user);
		 		List<Transaction> dueSoonBillList = transactionService.getDueSoonBills(foundUser);
				System.out.println(" Transaction list : "+dueSoonBillList);
				mav.addObject("dueSoonBillList", dueSoonBillList);
				
				List<Transaction> pastDueBillList = transactionService.findPastDueTransactions(foundUser);
				System.out.println(" Past due Transaction list : "+pastDueBillList);
				mav.addObject("pastDueBillList", pastDueBillList);
		 		

		 		view="home";
		 	}else {
		 		mav.addObject("errormessage", "Your email and/or password is invalid.");
		 	}
			mav.setViewName(view); // jsp
	        return mav;
	    }
	 
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public ModelAndView loginGetHandler(@ModelAttribute() User user, @SessionAttribute("userLogin") User userSession, Model model) {
		 	System.out.println();
		 	ModelAndView mav = new ModelAndView();
		 	String view="login";
		 	
		 	User foundUser=userServices.getUserByEmail(user.getEmail());
		 	if(foundUser==null) {
		 		mav.setViewName(view); // jsp
		        return mav;
		 	}else if(foundUser!=null && foundUser.getPassword().equals(user.getPassword())) {
		 		userServices.updateSessionId(user.getEmail(), RequestContextHolder.currentRequestAttributes().getSessionId());
		 		userSession.setEmail(foundUser.getEmail());
		 		userSession.setPassword(foundUser.getPassword());
		 		userSession.setfName(foundUser.getfName());
		 		model.addAttribute("userEmail", user.getEmail());
		 		mav.addObject("user", user);
		 		//System.out.println("login Handler User: "+user);
		 		List<Transaction> dueSoonBillList = transactionService.getDueSoonBills(foundUser);
				System.out.println(" Transaction list : "+dueSoonBillList);
				mav.addObject("dueSoonBillList", dueSoonBillList);
				
				List<Transaction> pastDueBillList = transactionService.findPastDueTransactions(foundUser);
				System.out.println(" Past due Transaction list : "+pastDueBillList);
				mav.addObject("pastDueBillList", pastDueBillList);
		 		

		 		view="home";
		 	}else {
		 		mav.addObject("errormessage", "Your email and/or password is invalid.");
		 	}
			mav.setViewName(view); // jsp
	        return mav;
	    }
	 @RequestMapping("/home")
		public ModelAndView homeHandler() {
		 System.out.println("Home mapping ");
		 	ModelAndView mav = new ModelAndView();
		 	String viewName = null;
		 	User user=userServices.getUserBySessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
			if (user==null) {  // if (verifyLogin(userSession))
				viewName = "login";
			} else {
				 System.out.println("Home mapping Else ********");

				List<Transaction> dueSoonBillList = transactionService.getDueSoonBills(user);
				System.out.println(" Transaction list : "+dueSoonBillList);
				mav.addObject("dueSoonBillList", dueSoonBillList);
				viewName = "home";
			}
			mav.setViewName(viewName); // jsp
			return mav;		}
	 
	 /**/
	 @RequestMapping(value = "/signup")
	    public String signUpHandler() {
	        return "signup";
	    }
	 
	 @RequestMapping(value = "/addUser")
	    public ModelAndView registration(@ModelAttribute() User user, BindingResult bindingResult, Model model) {
	      //  userValidator.validate(userForm, bindingResult);
		 	ModelAndView mav = new ModelAndView();
		 	String view="login";
		 	


	        if (bindingResult.hasErrors()) {
	            view= "signup";
	        }
	        

	        if(userServices.addUser(user)) {
		 		userServices.updateSessionId(user.getEmail(), RequestContextHolder.currentRequestAttributes().getSessionId());
		 		mav.addObject("firstName", user.getfName());

	        	view= "home";
	        }else {
	        	model.addAttribute("errorMessage", "Sign Up Failed, pls try later");
		        view= "redirect:/login";

	        }
			mav.setViewName(view); // jsp
			return mav;

	        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	    }
	 
	

	
	
	

}
