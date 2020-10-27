package by.kukshinov.xml.application.logics.factory;

import by.kukshinov.xml.application.logics.parsers.DevicesDomParser;
import by.kukshinov.xml.application.logics.parsers.Parser;

public class DomFactory implements ParserFactory {
    @Override
    public Parser createParser() {
	   return new DevicesDomParser();
    }
}
