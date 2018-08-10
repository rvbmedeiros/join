package br.com.join.demo.cliente.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import br.com.join.demo.cliente.model.Customer;

public class CustomerRepository {

	public List<Customer> retrieveCustomers() {

		List<Customer> customers = new ArrayList<Customer>();

		Customer c = new Customer();
		c.setName("teste");
		c.setBirthdate(new Date(2018, 10, 20));
		c.setCity("Curitiba");
		c.setUf("PR");
		c.setId(1l);
		c.setType("F");
		customers.add(c);

		c = new Customer();
		c.setName("teste 2");
		c.setBirthdate(new Date(2015, 5, 7));
		c.setCity("Curitiba");
		c.setUf("PR");
		c.setId(2l);
		c.setType("J");
		customers.add(c);

		return customers;

	}

	public Customer createCustomer(String nome, String municipio, String estado, Date nascimento , String tipo) {
		Customer c = new Customer();
		c.setName(nome);
		c.setBirthdate(nascimento);
		c.setCity(municipio);
		c.setUf(estado);
		c.setId(new Random().nextLong());
		c.setType(tipo);
		return c;
	}

	public Customer retrieveCustomer(String id) {
		Customer c = new Customer();
		c.setName("teste");
		c.setBirthdate(new Date(2018, 10, 20));
		c.setCity("Curitiba");
		c.setUf("PR");
		c.setId(1l);
		c.setType("F");
		return c;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCustomer(String id) {
		// TODO Auto-generated method stub
		
	}

}
