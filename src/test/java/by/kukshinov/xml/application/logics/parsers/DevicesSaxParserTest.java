package by.kukshinov.xml.application.logics.parsers;

import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DevicesSaxParserTest {
    Logger logger = LogManager.getLogger(DevicesSaxParserTest.class);
    private static final String FILE_PATH = "src/test/resources/devices.xsd.xml";

    @Test(dataProvider = "getDevicesList", dataProviderClass = DevicesDomParserTest.class)
    public void testParseShouldParseDevicesAndReturnDevicesList(List<Device> expected) throws ParserException {
	   DevicesSaxParser saxParser = new DevicesSaxParser();
	   //when
        List<Device> result = saxParser.parse(FILE_PATH);
        //then
	   Assert.assertEquals(result, expected);
    }
}
