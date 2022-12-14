package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SalesDiscountWrapper {
    @XmlElement(name = "sale")
    List<SalesDiscountsDTO> list;

    public SalesDiscountWrapper(List<SalesDiscountsDTO> list) {
        this.list = list;
    }

    public SalesDiscountWrapper() {
    }

    public List<SalesDiscountsDTO> getList() {
        return list;
    }

    public void setList(List<SalesDiscountsDTO> list) {
        this.list = list;
    }
}
