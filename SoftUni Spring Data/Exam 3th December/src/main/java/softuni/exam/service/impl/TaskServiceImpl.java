package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DataExport;
import softuni.exam.models.dto.TaskWrapperDTO;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.repository.PartRepository;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.TaskService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

import static softuni.exam.constants.Messages.IMPORTED_TASK;
import static softuni.exam.constants.Messages.INVALID_TASK;
import static softuni.exam.constants.Paths.TASKS_PATH;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    private final PartRepository partRepository;

    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskService, CarRepository carRepository, MechanicRepository mechanicRepository, PartRepository partRepository, ModelMapper modelMapper) {
        this.taskRepository = taskService;
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        JAXBContext context = JAXBContext.newInstance(TaskWrapperDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TaskWrapperDTO taskWrapperDTO = (TaskWrapperDTO) unmarshaller.unmarshal(Path.of(TASKS_PATH).toFile());
        taskWrapperDTO.getList().forEach(taskDTO -> {
            if (carRepository.findFirstById(taskDTO.getCar().get(0)).isEmpty()
                    || mechanicRepository.findFirstByFirstName(taskDTO.getMechanic().get(0)).isEmpty()
                    || partRepository.findFirstById(taskDTO.getPart().get(0)).isEmpty()) {
                stringBuilder.append(INVALID_TASK).append(System.lineSeparator());
            } else {
                if (taskDTO.isValid()) {
                    Task task = modelMapper.map(taskDTO, Task.class);
                    task.setCar(carRepository.findFirstById(taskDTO.getCar().get(0)).orElseThrow(NoSuchElementException::new));
                    task.setMechanic(mechanicRepository.findFirstByFirstName(taskDTO.getMechanic().get(0)).orElseThrow(NoSuchElementException::new));
                    task.setPart(partRepository.findFirstById(taskDTO.getPart().get(0)).orElseThrow(NoSuchElementException::new));
                    stringBuilder.append(String.format(IMPORTED_TASK, task.getPrice()));
                    taskRepository.saveAndFlush(task);
                } else {
                    stringBuilder.append(INVALID_TASK).append(System.lineSeparator());
                }
            }
        });
        return stringBuilder.toString();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder stringBuilder = new StringBuilder();
        List<DataExport> list = taskRepository.findTheHighestPricedTasks().orElseThrow(NoSuchElementException::new);
        list.forEach(element -> stringBuilder.append(element));
        return stringBuilder.toString();
    }
}
