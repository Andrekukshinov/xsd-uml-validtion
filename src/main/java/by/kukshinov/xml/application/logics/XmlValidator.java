package by.kukshinov.xml.application.logics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public boolean isSchemaValid(String fileName, String schemaName ) throws ValidatorException {
	   String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	   SchemaFactory factory = SchemaFactory.newInstance(language);
	   File schemaLocation = new File(schemaName);
	   try {
		  Schema schema = factory.newSchema(schemaLocation);
		  Validator validator = schema.newValidator();
		  Source source = new StreamSource(fileName);
		  validator.validate(source);
	   } catch (SAXException | IOException e) {
		  throw new ValidatorException(e.getMessage(), e);
	   }
	   return true;
    }
}
