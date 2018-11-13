package com.topshelf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topshelf.models.Chef;
import com.topshelf.services.ChefService;
import com.topshelf.util.Log4j;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
			// log print 
			Log4j.LOGGER.info("In DOPOST LoginServlet");
			
			// create ChefService object
		 	ChefService chefService = new ChefService();
	        
		 	//create ObjectMapper object
		 	ObjectMapper mapper = new ObjectMapper(); 
	        
		 	// read the Request's input stream and parse the desired values
	        String[] userCredentials = mapper.readValue(request.getInputStream(), String[].class);
	        String username = userCredentials[0];
	        String password = userCredentials[1];
	        
	        Chef authChef = chefService.loginChef(username, password);
	       
	        // set the session if chef with the given username and password is found
	        if(authChef != null) {
	        	authChef.setPassword("**********");
	            HttpSession session = request.getSession();
	            session.setAttribute("user", authChef);
	        }
	        
	        // structure the result into a response object and send it to the client side
	        PrintWriter pw = response.getWriter();
	        response.setContentType("application/json");
	        String authUserJSON = mapper.writeValueAsString(authChef);
	        pw.write(authUserJSON);
	}
	
}
