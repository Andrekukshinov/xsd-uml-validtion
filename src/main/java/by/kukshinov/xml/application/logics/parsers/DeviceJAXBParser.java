package by.kukshinov.xml.application.logics.parsers;

import by.kukshinov.xml.application.logics.ParserException;
import by.kukshinov.xml.application.model.Device;
import by.kukshinov.xml.application.model.Devices;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class DeviceJAXBParser implements Parser {
    private String schemaName;

    public DeviceJAXBParser(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public List<Device> parse(String filePath) throws ParserException {
        try {
            JAXBContext context = JAXBContext.newInstance(Devices.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);
            Devices devices = (Devices) unmarshaller.unmarshal(new File(filePath));
            System.out.println(devices);
            return devices.getDevices();
        } catch (JAXBException | SAXException e) {
            throw new ParserException();
        }
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
}
// TODO: 26.10.2020 refactor packages
