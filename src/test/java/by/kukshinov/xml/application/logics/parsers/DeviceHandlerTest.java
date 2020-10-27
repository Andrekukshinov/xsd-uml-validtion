package by.kukshinov.xml.application.logics.parsers;

import by.kukshinov.xml.application.logics.parsers.DeviceHandler;
import by.kukshinov.xml.application.model.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.xml.sax.ext.Attributes2Impl;

import java.util.Arrays;
import java.util.List;

public class DeviceHandlerTest {


    @Test
    public void testCharactersShouldSetEnergyConsumptionForDevice() throws SAXException {
	   DeviceHandler handler = new DeviceHandler();
	   Device device = new Cooler();
	   handler.setCurrentDevice(device);
	   handler.setCurrentFileName("energy-consumption");
	   char[] fieldValue = {'1', '2', '4', '5'};
	   int expected = 1245;
	   //when
	   handler.characters(fieldValue, 0, fieldValue.length);
	   //then
	   Device currentDevice = handler.getCurrentDevice();
	   int deviceEnergyConsumption = currentDevice.getEnergyConsumption();
	   Assert.assertEquals(expected, deviceEnergyConsumption);
    }

    @Test
    public void testCharactersShouldSetProducerForDevice() throws SAXException {
	   DeviceHandler handler = new DeviceHandler();
	   Device device = new Cooler();
	   handler.setCurrentProducer(new Producer());
	   handler.setCurrentDevice(device);
	   handler.setCurrentFileName("country");
	   char[] fieldCountryValue = {'m', 'i', 'n', 's', 'k'};
	   String expectedCountry = "minsk";
	   //when
	   handler.characters(fieldCountryValue, 0, fieldCountryValue.length);
	   //then
	   Producer producer = handler.getCurrentProducer();
	   String countryName = producer.getCountry();

	   Assert.assertEquals(expectedCountry, countryName);
    }

    @Test
    public void testStartElementShouldCreateCooler() throws SAXException {
	   DeviceHandler handler = new DeviceHandler();
	   String deviceName = "cooler";
	   Device expected = new Cooler();
	   //when
	   handler.startElement("someUrl", deviceName, "none", new Attributes2Impl());
	   //then
	   Device currentDevice = handler.getCurrentDevice();
	   Assert.assertEquals(expected, currentDevice);
	   Assert.assertTrue(currentDevice instanceof Cooler);
    }

    @Test
    public void testStartElementShouldCreateProcessor() throws SAXException {
	   DeviceHandler handler = new DeviceHandler();
	   String deviceName = "processor";
	   Device expected = new Processor();
	   //when
	   handler.startElement("someUrl", deviceName, "none", new Attributes2Impl());
	   //then
	   Device currentDevice = handler.getCurrentDevice();
	   Assert.assertEquals(expected, currentDevice);
	   Assert.assertTrue(currentDevice instanceof Processor);
    }

    @Test
    public void testEndElementShouldCreateProcessor() throws SAXException {
	   DeviceHandler handler = new DeviceHandler();
	   String deviceName = "processor";
	   Device device = new Processor();
	   handler.setCurrentDevice(device);
	   List<Device> expected = Arrays.asList(device);
	   //when
	   handler.endElement("someUrl", deviceName, "none");
	   //then
	   List<Device> currentDevices = handler.getDevices();
	   Assert.assertEquals(currentDevices, expected);
    }
}

