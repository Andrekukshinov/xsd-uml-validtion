package by.kukshinov.xml.application.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producer-type", namespace = "http://www.example.com/devices")
public class Producer {
    @XmlElement(name = "producer-name", required = true, namespace = "http://www.example.com/devices")
    private String producerName;
    @XmlElement(name = "country", required = true, namespace = "http://www.example.com/devices")
    @XmlSchemaType(name = "country-type")
    private String country;

    public Producer(String producerName, String country) {
	   this.producerName = producerName;
	   this.country = country;
    }

    public Producer() {
    }

    public String getProducerName() {
	   return producerName;
    }

    public void setProducerName(String producerName) {
	   this.producerName = producerName;
    }

    public String getCountry() {
	   return country;
    }

    public void setCountry(String country) {
	   this.country = country;
    }


    @Override
    public String toString() {
	   return "Producer{" + "producerName='" + producerName + '\'' + ", country=" + country + '}';
    }

    @Override
    public boolean equals(Object o) {
	   if (this == o) {
		  return true;
	   }
	   if (o == null || getClass() != o.getClass()) {
		  return false;
	   }

	   Producer producer = (Producer) o;

	   if (getProducerName() != null ? !getProducerName()
			 .equals(producer.getProducerName()) : producer
			 .getProducerName() != null) {
		  return false;
	   }
	   return getCountry() != null ? getCountry()
			 .equals(producer.getCountry()) : producer.getCountry() == null;
    }

    @Override
    public int hashCode() {
	   int result = getProducerName() != null ? getProducerName().hashCode() : 0;
	   result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
	   return result;
    }
}
