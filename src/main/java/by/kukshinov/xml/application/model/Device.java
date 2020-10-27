package by.kukshinov.xml.application.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)


@XmlType(name = "device-type", namespace = "http://www.example.com/devices", propOrder = {
	   "energyConsumption",
	   "producer",
	   "name"
})

@XmlSeeAlso({
	   Cooler.class, Processor.class
})


public abstract class Device {
    @XmlElement(name = "energy-consumption", required = true, namespace = "http://www.example.com/devices")
    private int energyConsumption;
    @XmlElement(name = "producer", required = true, namespace = "http://www.example.com/devices")
    private Producer producer;
    @XmlElement(required = true, namespace = "http://www.example.com/devices")
    @XmlID
    @XmlSchemaType(name = "ID")
    private String name;

    public Device(Producer producer, int energyConsumption, String name) {
	   this.producer = producer;
	   this.energyConsumption = energyConsumption;
	   this.name = name;
    }

    public Device() {
    }

    public Producer getProducer() {
	   return producer;
    }

    public void setProducer(Producer producer) {
	   this.producer = producer;
    }

    public int getEnergyConsumption() {
	   return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
	   this.energyConsumption = energyConsumption;
    }

    public String getName() {
	   return name;
    }

    public void setName(String name) {
	   this.name = name;
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   Device device = (Device) o;

	   if (getEnergyConsumption() != device.getEnergyConsumption()) {
		  return false;
	   }
	   if (getProducer() != null ? !getProducer().equals(device.getProducer()) : device
			 .getProducer() != null) {
		  return false;
	   }
	   return getName() != null ? getName().equals(device.getName()) : device
			 .getName() == null;
    }

    @Override
    public int hashCode() {
	   int result = getProducer() != null ? getProducer().hashCode() : 0;
	   result = 31 * result + getEnergyConsumption();
	   result = 31 * result + (getName() != null ? getName().hashCode() : 0);
	   return result;
    }

    @Override
    public String toString() {
	   return "Device{" + "producer=" + producer + ", energyConsumption=" + energyConsumption + ", name='" + name + '\'' + '}';
    }
}
