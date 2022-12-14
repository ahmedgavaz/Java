package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    public AgentServiceImpl(AgentRepository agentRepository, ModelMapper modelMapper, TownRepository townRepository) {
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count()>0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("src/main/resources/files/json/agents.json");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            stringBuilder.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentDTO[].class)).forEach(elem->{
            if (elem.isValid()){
                if (agentRepository.findFirstByEmail(elem.getEmail()).isEmpty()
                        && agentRepository.findFirstByFirstName(elem.getFirstName()).isEmpty()){
                    Agent agent = modelMapper.map(elem,Agent.class);
                    agent.setTown(townRepository.findFirstByTownName(elem.getTownName()).orElseThrow());
                    stringBuilder.append(String.format("Successfully imported agent - %s %s\n",agent.getFirstName(),agent.getLastName()));
                    agentRepository.saveAndFlush(agent);
                }else {
                    stringBuilder.append("Invalid agent\n");
                }
            }else{
                stringBuilder.append("Invalid agent\n");
            }
        });

        return stringBuilder.toString();
    }
}
