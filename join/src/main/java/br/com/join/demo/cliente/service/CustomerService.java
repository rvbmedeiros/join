package br.com.join.demo.cliente.service;

import java.util.Date;
import java.util.List;

import br.com.join.demo.cliente.model.Customer;
import br.com.join.demo.cliente.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository repo = new CustomerRepository();

	public List<Customer> retrieveCustomers() {
		return repo.retrieveCustomers();
	}

	public Customer createCustomer(String nome, String municipio, String estado, Date nascimento, String tipo) {
		return repo.createCustomer(nome, municipio, estado, nascimento, tipo);
	}

	public Customer retrieveCustomer(String id) {
		return repo.retrieveCustomer(id);
	}

	public void updateCustomer(Customer customer) {
		repo.updateCustomer(customer);
	}

	public void deleteCustomer(String id) {
		repo.deleteCustomer(id);
	}

}
