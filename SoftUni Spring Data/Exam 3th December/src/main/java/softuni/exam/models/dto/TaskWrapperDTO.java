package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskWrapperDTO {
    @XmlElement(name = "task")
    List<TaskDTO> list;

    public TaskWrapperDTO() {
    }

    public TaskWrapperDTO(List<TaskDTO> list) {
        this.list = list;
    }

    public List<TaskDTO> getList() {
        return list;
    }

    public void setList(List<TaskDTO> list) {
        this.list = list;
    }
}
