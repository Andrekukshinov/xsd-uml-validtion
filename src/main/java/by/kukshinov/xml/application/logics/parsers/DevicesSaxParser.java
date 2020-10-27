package by.kukshinov.xml.application.logics.parsers;


import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class DevicesSaxParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();
    private XMLReader reader;

    @Override
    public List<Device> parse(String filePath) throws ParserException {
	   DeviceHandler handler = new DeviceHandler();
	   try {
		  reader = XMLReaderFactory.createXMLReader();
		  reader.setContentHandler(handler);
		  reader.parse(filePath);
	   } catch (IOException | SAXException e) {
		  throw new ParserException(e.getMessage(), e);
	   }
	   return handler.getDevices();

    }
}
