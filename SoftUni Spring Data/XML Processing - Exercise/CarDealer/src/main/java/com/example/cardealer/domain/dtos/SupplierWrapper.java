package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierDTO> list;

    public SupplierWrapper(List<SupplierDTO> list) {
        this.list = list;
    }

    public SupplierWrapper() {
    }

    public List<SupplierDTO> getList() {
        return list;
    }

    public void setList(List<SupplierDTO> list) {
        this.list = list;
    }
}
