package by.kukshinov.xml.application.logics.parsers;


import by.kukshinov.xml.application.model.*;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DevicesDomParserTest {

    private static final String FILE_PATH = "src/test/resources/devices.xsd.xml";


    @DataProvider(name = "getDevicesList")
    public static Object[][] getDevicesList() {
	   Producer coolerProducer = new Producer("Swift", "USA");
	   Device cooler = new Cooler(coolerProducer, 4350, "Jade", 4350, CoolerType.AIR);

	   Producer processorProducer = new Producer("Intel", "USA");
	   Device processor = new Processor(processorProducer, 252552, "Intel-corei56440hq",
			 4, "2323.00HHz");

	   List<Device> expected = Arrays.asList(cooler, processor);
	   return new Object[][]{{expected}};
    }


    @Test(dataProvider = "getDevicesList")
    public void testParseShouldParseXmlAndBuildListOfDevices(List<Device> expected) {
	   DevicesDomParser domParser = new DevicesDomParser();

	   //when
	   List<Device> result = domParser.parse(FILE_PATH);
	   //then
	   Assert.assertEquals(result, expected);
    }
}
