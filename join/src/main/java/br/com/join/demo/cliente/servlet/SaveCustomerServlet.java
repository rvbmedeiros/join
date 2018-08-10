package br.com.join.demo.cliente.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.join.demo.cliente.model.Customer;
import br.com.join.demo.cliente.service.CustomerService;

public class SaveCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -2981363862306066192L;
	private CustomerService service = new CustomerService();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String municipio = request.getParameter("municipio");
			String estado = request.getParameter("estado");
			String nascimento = request.getParameter("nascimento");
			String tipo = request.getParameter("tipo");
			
			if (id != null) {
				Customer customer = service.retrieveCustomer(id);
				customer.setBirthdate(sdf.parse(nascimento));
				customer.setCity(municipio);
				customer.setName(nome);
				customer.setType(tipo);
				customer.setUf(estado);
				service.updateCustomer(customer);
			} else {
				Customer customer = service.createCustomer(nome, municipio, estado, sdf.parse(nascimento), tipo);
			}

			request.getRequestDispatcher("/cadastro").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("/error").forward(request, response);
		}

	}

}
