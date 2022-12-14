package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.dto.*;
import com.example.json_processing_exercise.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.json_processing_exercise.Constants.PathAndWriter.FOURTH_QUERY;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public List<UserWithSoldProductDTO> findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc() throws IOException {
        List<UserWithSoldProductDTO> list = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem->modelMapper.map(elem, UserWithSoldProductDTO.class))
                .collect(Collectors.toList());
        //Тук премахваме продуктите, които нямат куповач
        list.stream().map(e->{
            for (int i = e.getSellingProducts().size()-1; i >=0 ; i--) {
                if (e.getSellingProducts().get(i).getBuyerLastName()==null){
                    e.getSellingProducts().remove(i);
                }
            }
            return e;
        }).collect(Collectors.toList());

        PathAndWriter.writeInFile(list,PathAndWriter.SECOND_QUERY);
        return list;
    }


    // Извинявам се за сложната логика, но не разбрах начина на работа на Николай на упражнението
    // и започнах да си измислям собствена, която се оказа доста сложна и объркваща
    public CountOfUserDTO fourthQuery() throws IOException {
        List<UsersAndProductsDTO> list = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem->modelMapper.map(elem, UsersAndProductsDTO.class))
                .collect(Collectors.toList());
        //Използвам листа от второто Query и взимам от там нещата като ги слагам във отделните подкласове
        List<UserWithSoldProductDTO> list2 = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem->modelMapper.map(elem, UserWithSoldProductDTO.class))
                .collect(Collectors.toList());
        CountOfUserDTO searchedElement = new CountOfUserDTO(list);
        for (int i = 0; i < list2.size(); i++) {
            List<ProductDTO> list3 = List.of(modelMapper.map(list2.get(i).getSellingProducts(), ProductDTO[].class));
            CountAndProductsDTO elem = new CountAndProductsDTO(list3);
            searchedElement.getUsers().get(i).setCount(elem);
        }
        PathAndWriter.writeInFileElement(searchedElement,FOURTH_QUERY);
        return searchedElement;
    }
}
