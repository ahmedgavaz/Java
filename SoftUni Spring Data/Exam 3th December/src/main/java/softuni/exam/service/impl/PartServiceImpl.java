package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static softuni.exam.constants.Messages.IMPORTED_PART;
import static softuni.exam.constants.Messages.INVALID_PART;
import static softuni.exam.constants.Paths.PARTS_PATH;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, Gson gson, ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(gson.fromJson(readPartsFileContent(), PartDTO[].class)).sequential().forEach(partDTO -> {
            if (partRepository.findFirstByPartName(partDTO.getPartName()).isEmpty()) {
                if (partDTO.isValid()) {
                    Part part = modelMapper.map(partDTO, Part.class);
                    stringBuilder.append(String.format(IMPORTED_PART, part.getPartName(), part.getPrice()));
                    partRepository.saveAndFlush(part);
                } else {
                    stringBuilder.append(INVALID_PART).append(System.lineSeparator());
                }
            } else {
                stringBuilder.append(INVALID_PART).append(System.lineSeparator());
            }
        });
        return stringBuilder.toString();
    }
}
