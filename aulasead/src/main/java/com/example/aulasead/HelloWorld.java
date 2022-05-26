package com.example.aulasead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public void toGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		var pipoca = request.getAttribute("pipoca");
		
		response.setContentType("text/html");
		response.getWriter().write("<html><h1>Olá Mundo, o usuário logado é " + pipoca + "</h1></html>");
	}
	
	@RequestMapping(value = "/casa", method = RequestMethod.GET)
	public void toGet2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().write("<h1>Olá Mundo, casa</h1>");
	}
	
	
	@RequestMapping(value ="/redirecionar", method =RequestMethod.GET)
	public void doRedirecionar(HttpServletRequest request , HttpServletResponse response) throws IOException {
		response.sendRedirect("http://americanas.com");
	}
	
	@RequestMapping(value = "/encaminhar", method = RequestMethod.GET)
	public void doEncaminhar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		var dispatcher = request.getRequestDispatcher("/home");
		request.setAttribute("pipoca", "pipoca encaminhada");
		dispatcher.forward(request, response);
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public void doSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
		var session = request.getSession(true);
		response.getWriter().println(session.getId());
	}
	
//FIM DA CLASSE
	
	
	
	
}
