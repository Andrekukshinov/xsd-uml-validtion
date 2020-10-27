package by.kukshinov.xml.application.model;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "devices", namespace = "http://www.example.com/devices")
@XmlType( namespace = "http://www.example.com/devices")
public class Devices {
    @XmlElements(
		  {@XmlElement(name = "cooler", namespace = "http://www.example.com/devices", type = Cooler.class),
		  @XmlElement(name = "processor", namespace = "http://www.example.com/devices", type = Processor.class)}
    )
    private List<Device> devices;

    public Devices() {
    }

    public List<Device> getDevices() {
	   return new ArrayList<>(devices);
    }

    public void setDevices(List<Device> devices) {
	   this.devices = devices;
    }

    @Override
    public String toString() {
	   return "Devices{" + "devices=" + devices + '}';
    }
}

