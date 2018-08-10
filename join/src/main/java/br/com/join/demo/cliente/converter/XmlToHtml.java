package br.com.join.demo.cliente.converter;

import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class XmlToHtml {

	public static void convertXMLToHTML(Source xml, Source xslt, OutputStream o) throws TransformerException {
		StringWriter sw = new StringWriter();
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer trasform = tFactory.newTransformer(xslt);
		trasform.transform(xml, new StreamResult(o));
	}

}
