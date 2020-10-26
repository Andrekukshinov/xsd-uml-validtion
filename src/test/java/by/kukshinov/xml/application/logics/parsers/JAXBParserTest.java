package by.kukshinov.xml.application.logics.parsers;


import by.kukshinov.xml.application.model.Device;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JAXBParserTest {

    private static final String FILE_PATH = "src/test/resources/devices.xsd.xml";


    @Test(dataProvider = "getDevicesList", dataProviderClass = DevicesDomParserTest.class)
    public void test(List<Device> expected) {
	   JAXBParser parser = new JAXBParser();
	   List<Device> parse = parser.parse(FILE_PATH);
	   Assert.assertEquals(parse, expected);
    }

}
