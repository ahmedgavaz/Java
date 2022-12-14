package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocalSupplierWrapper {
    @XmlElement(name = "supplier")
    List<SupplierDTOWithCountOfParts> list;

    public LocalSupplierWrapper() {
    }

    public LocalSupplierWrapper(List<SupplierDTOWithCountOfParts> list) {
        this.list = list;
    }

    public List<SupplierDTOWithCountOfParts> getList() {
        return list;
    }

    public void setList(List<SupplierDTOWithCountOfParts> list) {
        this.list = list;
    }
}
