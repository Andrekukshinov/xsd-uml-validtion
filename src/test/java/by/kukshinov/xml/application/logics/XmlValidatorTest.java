package by.kukshinov.xml.application.logics;


import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlValidatorTest {
    @Test
    public void test() throws ParserException {
	   XmlValidator validator = new XmlValidator();
	   boolean result = validator.isSchemaValid("src/test/resources/devices.xsd.xml",
			 "src/test/resources/devices.xsd");
	   Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ParserException.class)
    public void testInvalid() throws ParserException {
	   XmlValidator validator = new XmlValidator();
	   boolean result = validator.isSchemaValid("src/test/resources/invalidDevices.xsd.xml",
			 "src/test/resources/devices.xsd");
    }
}
//todo rework exception in validator
