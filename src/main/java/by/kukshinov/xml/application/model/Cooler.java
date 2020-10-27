package by.kukshinov.xml.application.model;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cooler-entity-type", namespace = "http://www.example.com/devices")
public class Cooler extends Device {
    @XmlElement(name = "cooler-type", required = true, namespace = "http://www.example.com/devices")
    @XmlSchemaType(name = "string")
    private CoolerType coolerType;
    @XmlElement(name = "routes-per-minute", required = true, namespace = "http://www.example.com/devices")
    private int routesPerMinute;

    public Cooler() {
    }

    public Cooler(
		  Producer producer, int energyConsumption, String name, int routesPerMinute,
		  CoolerType coolerType) {
	   super(producer, energyConsumption, name);
	   this.routesPerMinute = routesPerMinute;
	   this.coolerType = coolerType;
    }

    public Cooler(
		  int routesPerMinute, CoolerType coolerType) {
	   this.routesPerMinute = routesPerMinute;
	   this.coolerType = coolerType;
    }

    public int getRoutesPerMinute() {
	   return routesPerMinute;
    }

    public void setRoutesPerMinute(int routesPerMinute) {
	   this.routesPerMinute = routesPerMinute;
    }

    public CoolerType getCoolerType() {
	   return coolerType;
    }

    public void setCoolerType(CoolerType coolerType) {
	   this.coolerType = coolerType;
    }
}
