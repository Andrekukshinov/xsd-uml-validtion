package by.kukshinov.xml.application.logics.parsers;

import by.kukshinov.xml.application.logics.ConstantNotPresentException;
import by.kukshinov.xml.application.model.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class DeviceHandler extends DefaultHandler {

    //device fields
    private static final String ENERGY_CONSUMPTION = "energy-consumption";
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";

    //cooler fields
    private static final String ROUTES_PER_MINUTE = "routes-per-minute";
    private static final String COOLER_TYPE = "cooler-type";

    //processor fields
    private static final String CORE_AMOUNT = "core-amount";
    private static final String FREQUENCY = "frequency";

    //producer fields
    private static final String PRODUCER_NAME = "producer-name";
    private static final String COUNTRY = "country";

    private static final String ROOT = "devices";

    public static final String COOLER = "cooler";
    public static final String PROCESSOR = "processor";

    List<Device> devices = new ArrayList<>();

    private Device currentDevice;

    private Producer currentProducer;

    private String currentFieldName;

    public List<Device> getDevices() {
	   return new ArrayList<>(this.devices);
    }

    @Override
    public void startElement(
		  String uri, String localName, String qName, Attributes attributes) {
	   switch (localName) {
		  case COOLER:
			 currentDevice = new Cooler();
			 break;
		  case PROCESSOR:
			 currentDevice = new Processor();
			 break;
		  case PRODUCER:
			 currentProducer = new Producer();
			 break;
		  default:
			 currentFieldName = localName;
			 break;
	   }
    }


    @Override
    public void endElement(
		  String uri, String localName, String qName) throws SAXException {
	   currentFieldName = ROOT;
	   if (COOLER.equalsIgnoreCase(localName) || PROCESSOR.equalsIgnoreCase(localName)) {
		  devices.add(currentDevice);
	   }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
	   String fieldValue = new String(ch, start, length).trim();
	   if (currentFieldName != null) {
		  setDeviceField(fieldValue);
	   }
    }

    private void setDeviceField(String fieldValue) {
	   switch (currentFieldName) {
		  case ENERGY_CONSUMPTION:
			 int energyConsumption = Integer.parseInt(fieldValue);
			 currentDevice.setEnergyConsumption(energyConsumption);
			 break;
		  case NAME:
			 currentDevice.setName(fieldValue);
			 break;
		  case PRODUCER_NAME:
			 currentProducer.setProducerName(fieldValue);
			 if (currentProducer.getCountry() != null) {
				currentDevice.setProducer(currentProducer);
			 }
			 break;
		  case COUNTRY:
			 currentProducer.setCountry(fieldValue);
			 if (currentProducer.getProducerName() != null) {
				currentDevice.setProducer(currentProducer);
			 }
			 break;
		  case ROUTES_PER_MINUTE:
			 int routesPerMinute = Integer.parseInt(fieldValue);
			 ((Cooler) currentDevice).setRoutesPerMinute(routesPerMinute);
			 break;
		  case COOLER_TYPE:
			 CoolerType coolerType = CoolerType.valueOf(fieldValue);
			 ((Cooler) currentDevice).setCoolerType(coolerType);
			 break;
		  case CORE_AMOUNT:
			 int coreAmount = Integer.parseInt(fieldValue);
			 ((Processor) currentDevice).setCoreAmount(coreAmount);
			 break;
		  case FREQUENCY:
			 ((Processor) currentDevice).setFrequency(fieldValue);
			 break;
		  case ROOT:
			 break;
		  default:
			 throw new ConstantNotPresentException("Such field is not allowed");
	   }
    }

    //for testing
    void setCurrentFileName(String fieldName) {
	   this.currentFieldName = fieldName;
    }

    void setCurrentDevice(Device device) {
	   this.currentDevice = device;
    }

    void setCurrentProducer(Producer producer) {
	   this.currentProducer = producer;
    }

    Device getCurrentDevice() {
	   return this.currentDevice;
    }

    Producer getCurrentProducer() {
	   return this.currentProducer;
    }

}
