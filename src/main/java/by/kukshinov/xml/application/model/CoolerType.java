package by.kukshinov.xml.application.model;

import javax.xml.bind.annotation.*;

@XmlType(name = "CoolerType", namespace = "http://www.example.com/devices")
@XmlEnum()
public enum CoolerType {
    @XmlEnumValue("AIR") AIR,
    @XmlEnumValue("WATER") WATER
}
