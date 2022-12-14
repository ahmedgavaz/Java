package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesWrapper {
    @XmlElement(name = "customer")
    List<CustomerTotalSalesDTO> list;

    public CustomerTotalSalesWrapper(List<CustomerTotalSalesDTO> list) {
        this.list = list;
    }

    public CustomerTotalSalesWrapper() {
    }

    public List<CustomerTotalSalesDTO> getList() {
        return list;
    }

    public void setList(List<CustomerTotalSalesDTO> list) {
        this.list = list;
    }
}
