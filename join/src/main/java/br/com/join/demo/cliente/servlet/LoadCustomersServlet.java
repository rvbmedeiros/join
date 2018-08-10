package br.com.join.demo.cliente.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import br.com.join.demo.cliente.converter.ModelConverter;
import br.com.join.demo.cliente.converter.XmlToHtml;
import br.com.join.demo.cliente.model.Customer;
import br.com.join.demo.cliente.model.Page;
import br.com.join.demo.cliente.service.CustomerService;

public class LoadCustomersServlet extends HttpServlet {

	private static final long serialVersionUID = -7471464671986324338L;
	
	private CustomerService service = new CustomerService();
	private ModelConverter<Customer> mConverter = new ModelConverter<Customer>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Page page = new Page();
			String id = req.getParameter("id");
			if (id != null) {
				Customer customer = service.retrieveCustomer(id);
				page.setBirthdate(customer.getBirthdate());
				page.setCity(customer.getCity());
				page.setId(customer.getId());
				page.setName(customer.getName());
				page.setType(customer.getType());
				page.setUf(customer.getUf());
			}
			
			page.setCustomers(service.retrieveCustomers());
			
			
			ServletContext context = getServletContext();
			InputStream is1 = context.getResourceAsStream("xsl/cadastro.xsl");
			Source xsl = new StreamSource(is1);
			Document xml = mConverter.toXML(page);
			XmlToHtml.convertXMLToHTML(new DOMSource(xml), xsl, resp.getOutputStream());
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (JAXBException e1) {
			e1.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
