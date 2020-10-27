package by.kukshinov.xml.application.logics.parsers;


import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.Device;

import java.util.List;


public interface Parser {
    List<Device> parse(String filePath) throws ParserException;

}
