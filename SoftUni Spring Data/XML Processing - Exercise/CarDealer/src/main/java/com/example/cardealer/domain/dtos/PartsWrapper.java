package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsWrapper {
    @XmlElement(name = "parts")
    private List<PartNameAndPriceDTO> list;

    public PartsWrapper() {
    }

    public PartsWrapper(List<PartNameAndPriceDTO> list) {
        this.list = list;
    }

    public List<PartNameAndPriceDTO> getList() {
        return list;
    }

    public void setList(List<PartNameAndPriceDTO> list) {
        this.list = list;
    }
}
