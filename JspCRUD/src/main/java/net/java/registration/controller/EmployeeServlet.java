package net.java.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.ConnectionInterface;
import Interface.EmpDaoImp;
import net.java.registration.dao.EmployeeDao;
import net.java.registration.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;

	public void init() {
		employeeDao = new EmployeeDao();
	}
	public EmployeeServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("Hello In");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String submitType = request.getParameter("submit");

		ConnectionInterface connectionInterface = new EmpDaoImp();
		Employee employee_ = connectionInterface.getEmployee(username, password);
		System.err.println("submitType ------ " + submitType);
		if (submitType.equals("login") && employee_ != null && employee_.getUsername() != null) {
			request.setAttribute("message", employee_.getUsername());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Welcom.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("Welcom.jsp");
		} else if (submitType.equals("register")) {
			Employee employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setContact(contact);
			employee.setAddress(address);
			try {
				employeeDao.registerEmployee(employee);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("Sucessmessage", "Registration Done, Please Login");
			request.getRequestDispatcher("employeedetails.jsp").forward(request, response);
		} else {
			request.setAttribute("Errormessage", "Invalid data");
			request.getRequestDispatcher("employeelogin.jsp").forward(request, response);
		}
	}

}