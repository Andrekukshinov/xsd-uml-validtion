package by.kukshinov.xml.application.logics.parsers;


import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.Device;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeviceJAXBParserTest {

    private static final String FILE_PATH = "src/test/resources/devices.xsd.xml";
    public static final String DEVICES_XSD = "src/test/resources/devices.xsd";


    @Test(dataProvider = "getDevicesList", dataProviderClass = DevicesDomParserTest.class)
    public void test(List<Device> expected) throws ParserException {
	   DeviceJAXBParser parser = new DeviceJAXBParser(DEVICES_XSD);
	   List<Device> parse = parser.parse(FILE_PATH);
	   Assert.assertEquals(parse, expected);
    }

}
