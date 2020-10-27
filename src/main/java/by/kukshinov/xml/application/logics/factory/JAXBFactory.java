package by.kukshinov.xml.application.logics.factory;

import by.kukshinov.xml.application.logics.parsers.DeviceJAXBParser;
import by.kukshinov.xml.application.logics.parsers.Parser;

public class JAXBFactory implements ParserFactory{
    private final String schemaName;

    public JAXBFactory(String schemaName) {
	   this.schemaName = schemaName;
    }

    @Override
    public Parser createParser() {
	   return new DeviceJAXBParser(schemaName);
    }
}
