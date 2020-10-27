package by.kukshinov.xml.application.logics.parsers;

import by.kukshinov.xml.application.logics.ConstantNotPresentException;
import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DevicesDomParser implements Parser {
    private static final Logger LOGGER = LogManager.getLogger();

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

    private final List<Device> devices;

    public DevicesDomParser() {
	   devices = new ArrayList<>();
    }

    @Override
    public List<Device> parse(String filePath) throws ParserException {
	   DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	   try {
		  DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		  Document document = documentBuilder.parse(filePath);
		  Element root = document.getDocumentElement();
		  NodeList devicesNodesList = root.getChildNodes();

		  for (int runner = 0; runner < devicesNodesList.getLength(); ++runner) {
			 Node item = devicesNodesList.item(runner);
			 Element element = null;
			 String nodeValue = item.getNodeName();
			 if (COOLER.equalsIgnoreCase(nodeValue) || PROCESSOR
				    .equalsIgnoreCase(nodeValue)) {
				element = (Element) item;
			 } else {
				continue;
			 }
			 String tagName = element.getTagName();
			 if (PROCESSOR.equalsIgnoreCase(tagName) || COOLER
				    .equalsIgnoreCase(tagName)) {
				Device deviceToAdd = buildDevice(element);
				devices.add(deviceToAdd);
			 }
		  }
	   } catch (ParserConfigurationException | SAXException | IOException e) {
		 throw new ParserException(e.getMessage(), e);
	   }
	   return new ArrayList<>(devices);
    }


    private Device buildDevice(Element deviceElement) {
	   String tagName = deviceElement.getTagName();
	   Device device;
	   switch (tagName) {
		  case COOLER:
			 device = new Cooler();
			 setCoolerFields(deviceElement, (Cooler) device);
			 break;
		  case PROCESSOR:
			 device = new Processor();
			 setProcessorFields(deviceElement, (Processor) device);
			 break;
		  default:
			 throw new ConstantNotPresentException("No such device found");
	   }

	   setCommonFieldsForDevices(deviceElement, device);
	   return device;
    }

    private void setProcessorFields(Element deviceElement, Processor device) {
	   int coreAmount = Integer
			 .parseInt(getElementTextContent(deviceElement, CORE_AMOUNT));
	   String frequency = getElementTextContent(deviceElement, FREQUENCY);
	   device.setCoreAmount(coreAmount);
	   device.setFrequency(frequency);
    }

    private void setCoolerFields(Element deviceElement, Cooler device) {
	   CoolerType coolerType = CoolerType
			 .valueOf(getElementTextContent(deviceElement, COOLER_TYPE));
	   int routesPerMinute = Integer
			 .parseInt(getElementTextContent(deviceElement, ROUTES_PER_MINUTE));
	   device.setCoolerType(coolerType);
	   device.setRoutesPerMinute(routesPerMinute);
    }

    private void setCommonFieldsForDevices(Element deviceElement, Device device) {
	   device.setName(getElementTextContent(deviceElement, NAME));
	   int energyConsumption = Integer
			 .parseInt(getElementTextContent(deviceElement, ENERGY_CONSUMPTION));
	   device.setEnergyConsumption(energyConsumption);
	   String producerName = getElementTextContent(deviceElement, PRODUCER_NAME);
	   Producer producer = new Producer();
	   producer.setProducerName(producerName);
	   String countryString = getElementTextContent(deviceElement, COUNTRY);
	   producer.setCountry(countryString);
	   device.setProducer(producer);
    }

    private String getElementTextContent(Element deviceElement, String elementName) {
	   NodeList nList = deviceElement.getElementsByTagName(elementName);
	   Node node = nList.item(0);
	   return node.getTextContent();
    }
}
