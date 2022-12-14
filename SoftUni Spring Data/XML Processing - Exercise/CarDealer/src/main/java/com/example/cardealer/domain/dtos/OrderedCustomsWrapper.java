package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderedCustomsWrapper {
    @XmlElement(name = "customer")
    List<CustomerOrderDTO> list;

    public OrderedCustomsWrapper() {
    }

    public OrderedCustomsWrapper(List<CustomerOrderDTO> list) {
        this.list = list;
    }

    public List<CustomerOrderDTO> getList() {
        return list;
    }

    public void setList(List<CustomerOrderDTO> list) {
        this.list = list;
    }
}
