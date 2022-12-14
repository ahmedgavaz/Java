package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        StringBuilder str = new StringBuilder();
        File file = new File("src/main/resources/files/json/towns.json");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            str.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Arrays.stream(gson.fromJson(readTownsFileContent(), TownDTO[].class))
                .forEach(elem->{
                    if (elem.isCorrect()){
                        Town town = modelMapper.map(elem,Town.class);
                        if (this.townRepository.findFirstByTownName(town.getTownName()).isEmpty()){
                            stringBuilder.append(String.format("Successfully imported town %s - %d\n",town.getTownName(),town.getPopulation()));
                            this.townRepository.saveAndFlush(town);
                        }else{
                            stringBuilder.append("Invalid town\n");
                        }
                    }else{
                        stringBuilder.append("Invalid town\n");
                    }
                });
        return stringBuilder.toString();
    }
}
