package by.kukshinov.xml.application.logics;


import org.testng.Assert;
import org.testng.annotations.Test;

public class XmlValidatorTest {

    public static final String DEVICES_XML = "src/test/resources/devices.xsd.xml";
    public static final String DEVICES_XSD = "src/test/resources/devices.xsd";
    public static final String INVALID_DEVICES_XML = "src/test/resources/invalidDevices.xsd.xml";

    @Test
    public void testValidateShouldValidateXmlByXsdAndReturnTrue() throws ValidatorException {
	   XmlValidator validator = new XmlValidator();
	   boolean result = validator.isSchemaValid(DEVICES_XML, DEVICES_XSD);
	   Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ValidatorException.class)
    public void testValidateShouldTryValidateInvalidXmlAndThrowException() throws ValidatorException {
	   XmlValidator validator = new XmlValidator();
	   boolean result = validator.isSchemaValid(INVALID_DEVICES_XML,
			 DEVICES_XSD);
    }
}
