package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWrapper {
    @XmlElement(name = "customer")
    private List<CustomerDTO> list;

    public List<CustomerDTO> getList() {
        return list;
    }

    public void setList(List<CustomerDTO> list) {
        this.list = list;
    }

    public CustomerWrapper() {
    }

    public CustomerWrapper(List<CustomerDTO> list) {
        this.list = list;
    }
}
