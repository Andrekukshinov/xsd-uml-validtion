package by.kukshinov.xml.application.logics.factory;

import by.kukshinov.xml.application.logics.parsers.DevicesSaxParser;
import by.kukshinov.xml.application.logics.parsers.Parser;

public class SaxFactory implements ParserFactory {
    @Override
    public Parser createParser() {
	   return new DevicesSaxParser();
    }
}
