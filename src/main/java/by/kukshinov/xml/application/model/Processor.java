package by.kukshinov.xml.application.model;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processor-type", namespace = "http://www.example.com/devices")
public class Processor extends Device {
    @XmlElement(name = "frequency", required = true, namespace = "http://www.example.com/devices")
    @XmlSchemaType(name = "frequency-type")
    private String frequency;
    @XmlElement(name = "core-amount", required = true, namespace = "http://www.example.com/devices")
    private int coreAmount;

    public Processor(
		  Producer producer, int energyConsumption, String name, int coreAmount,
		  String frequency) {
	   super(producer, energyConsumption, name);
	   this.coreAmount = coreAmount;
	   this.frequency = frequency;
    }

    public Processor() {
    }

    public int getCoreAmount() {
	   return coreAmount;
    }

    public void setCoreAmount(int coreAmount) {
	   this.coreAmount = coreAmount;
    }

    public String getFrequency() {
	   return frequency;
    }

    public void setFrequency(String frequency) {
	   this.frequency = frequency;
    }

    @Override
    public String toString() {
	   return "Processor{" + "coreAmount=" + coreAmount + ", frequency='" + frequency + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }
	   if (!super.equals(o)) {
		  return false;
	   }

	   Processor processor = (Processor) o;

	   if (getCoreAmount() != processor.getCoreAmount()) {
		  return false;
	   }
	   return getFrequency() != null ? getFrequency()
			 .equals(processor.getFrequency()) : processor.getFrequency() == null;
    }

    @Override
    public int hashCode() {
	   int result = super.hashCode();
	   result = 31 * result + getCoreAmount();
	   result = 31 * result + (getFrequency() != null ? getFrequency().hashCode() : 0);
	   return result;
    }
}
