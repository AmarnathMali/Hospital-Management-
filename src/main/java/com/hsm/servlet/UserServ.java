package com.hsm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hms.model.User;
import com.hms.model.Intr.UserIntr;

@WebServlet("/")
public class UserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserIntr ui;
	public void init(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("patient-cfg.xml");
		ui = (UserIntr)ctx.getBean("udao");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		//PrintWriter pw = response.getWriter();
		String action = request.getServletPath();
		
		switch (action){
		
		case "/new":
			showNewForm(request,response);
			break;
			
		case "/insert":
			insertUser(request,response);
			break;
			
		case "/update":
			updateUser(request,response);
			break;
			
		case "/delete":
			deleteUser(request,response);
			break;
			
		case "/edit":
			showEditForm(request,response);
			break;
			
		default:
			listUser(request,response);
			break;
		}
		
	}


	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> listUser = ui.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request,response);
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		Map existingUser = ui.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

		
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		ui.deleteUser(id);
		response.sendRedirect("list");
	}


	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String bloodgroup = request.getParameter("bgroup");
		String disease = request.getParameter("disease");

		User user = new User(id, name, bloodgroup, disease);
		ui.updateUser(user);
		response.sendRedirect("list");

	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String bloodgroup = request.getParameter("bgroup");
		String disease = request.getParameter("disease");
		User u = new User(name,bloodgroup,disease);
		ui.insertUser(u);
		response.sendRedirect("list");
		
	}


	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);

		
	}

}
