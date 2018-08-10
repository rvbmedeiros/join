package br.com.join.demo.cliente.converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;

import br.com.join.demo.cliente.model.Page;

public class ModelConverter<T> {

	public Document toXML(Page page) throws ParserConfigurationException, JAXBException, TransformerException {
		DOMResult res = new DOMResult();
		JAXBContext context = JAXBContext.newInstance(Page.class);
		context.createMarshaller().marshal(page, res);
		Document doc = (Document) res.getNode();
		return doc;
	}

}
