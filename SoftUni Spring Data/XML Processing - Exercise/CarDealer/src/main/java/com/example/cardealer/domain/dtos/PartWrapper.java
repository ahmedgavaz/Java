package com.example.cardealer.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartWrapper {
    @XmlElement(name = "part")
    private List<PartDTO> list;

    public PartWrapper(List<PartDTO> list) {
        this.list = list;
    }

    public PartWrapper() {
    }

    public List<PartDTO> getList() {
        return list;
    }

    public void setList(List<PartDTO> list) {
        this.list = list;
    }
}
