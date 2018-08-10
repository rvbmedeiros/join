package br.com.join.demo.cliente.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.join.demo.cliente.service.CustomerService;

public class DeleteCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -2981363862306066192L;
	private CustomerService service = new CustomerService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");

			if (id != null) {
				service.deleteCustomer(id);
			}

			request.getRequestDispatcher("/cadastro").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/error").forward(request, response);
		}

	}

}
