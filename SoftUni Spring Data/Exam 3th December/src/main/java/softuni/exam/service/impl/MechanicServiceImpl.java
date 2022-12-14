package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.Messages.IMPORTED_MECHANIC;
import static softuni.exam.constants.Messages.INVALID_MECHANIC;
import static softuni.exam.constants.Paths.MECHANICS_PATH;

@Service
public class MechanicServiceImpl implements MechanicService {
    private final MechanicRepository mechanicRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository, Gson gson, ModelMapper modelMapper) {
        this.mechanicRepository = mechanicRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicDTO[].class)).sequential().forEach(mechanicDTO -> {
            if (mechanicRepository.findFirstByFirstName(mechanicDTO.getFirstName()).isEmpty()
                    && mechanicRepository.findFirstByEmail(mechanicDTO.getEmail()).isEmpty()
                    && mechanicRepository.findFirstByPhone(mechanicDTO.getPhone()).isEmpty()) {
                if (mechanicDTO.isValid()) {
                    Mechanic mechanic = modelMapper.map(mechanicDTO, Mechanic.class);
                    stringBuilder.append(String.format(IMPORTED_MECHANIC, mechanic.getFirstName(), mechanic.getLastName()));
                    mechanicRepository.saveAndFlush(mechanic);
                } else {
                    stringBuilder.append(INVALID_MECHANIC).append(System.lineSeparator());
                }
            } else {
                stringBuilder.append(INVALID_MECHANIC).append(System.lineSeparator());
            }
        });
        return stringBuilder.toString();
    }
}
