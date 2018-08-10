package br.com.join.demo.cliente.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page {

	@XmlElement(name = "customer")
	private List<Customer> customers;
	
	@XmlElement(name = "id")
	private Long id;
	
	@XmlElement(name = "type")
	private String type;
	
	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "birthdate")
	private Date birthdate;
	
	@XmlElement(name = "uf")
	private String uf;
	
	@XmlElement(name = "city")
	private String city; 

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	

}
