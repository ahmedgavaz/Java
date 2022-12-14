package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.Product;
import com.example.json_processing_exercise.entities.dto.*;
import com.example.json_processing_exercise.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.json_processing_exercise.Constants.PathAndWriter.FOURTH_QUERY;
import static com.example.json_processing_exercise.Constants.PathAndWriter.SECOND_QUERY;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public List<UserWithSoldProductDTO> findAllBySellingProductsBuyerIsNotNullOrderByLastNameAscFirstNameAsc() throws IOException, JAXBException {
        List<UserWithSoldProductDTO> list = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem -> {
                    Set<Product> selling = elem.getSellingProducts();
                    UserWithSoldProductDTO user = modelMapper.map(elem, UserWithSoldProductDTO.class);
                    user.setSellingProducts(new ProductSoldWrapper(selling.stream().map(e -> modelMapper.map(e, ProductSoldDTO.class)).toList()));
                    return user;
                })
                .collect(Collectors.toList());
        //Тук премахваме продуктите, които нямат куповач
        for (int i = 0; i < list.size(); i++) {
            int size = list.get(i).getSellingProducts().getList().size();
            List<ProductSoldDTO> products = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (list.get(i).getSellingProducts().getList().get(j).getBuyerLastName() != null) {
                    products.add(list.get(i).getSellingProducts().getList().get(j));
                }
            }
            list.get(i).getSellingProducts().setList(products);
        }
        //Записването не съм го извел в отделен метод защото исках да се упражнявам с XML
        FileWriter fileWriter = new FileWriter(Path.of(SECOND_QUERY).toFile());
        UserWithSoldProductWrapper user = new UserWithSoldProductWrapper(list);
        JAXBContext context = JAXBContext.newInstance(UserWithSoldProductWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(user, fileWriter);
        return list;
    }


    // Извинявам се за сложната логика, но не разбрах начина на работа на Николай на упражнението
    // и започнах да си измислям собствена, която се оказа доста сложна и объркваща
    public CountOfUserDTO fourthQuery() throws IOException, JAXBException {
        List<UsersAndProductsDTO> list = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem->modelMapper.map(elem, UsersAndProductsDTO.class))
                .collect(Collectors.toList());
        //Използвам листа от второто Query и взимам от там нещата като ги слагам във отделните подкласове
        List<UserWithSoldProductDTO> list2 = this.userRepository.findDistinctAllBySellingProductsIsNotNullOrderByLastNameAscFirstNameAsc().orElseThrow()
                .stream()
                .map(elem->{
                    List<ProductSoldDTO> products = elem.getSellingProducts().stream().map(e->modelMapper.map(e,ProductSoldDTO.class)).toList();
                    UserWithSoldProductDTO user = modelMapper.map(elem, UserWithSoldProductDTO.class);
                    user.setSellingProducts(new ProductSoldWrapper(products));
                    return user;
                })
                .collect(Collectors.toList());
        CountOfUserDTO searchedElement = new CountOfUserDTO(list);
        for (int i = 0; i < list2.size(); i++) {
            List<ProductDTO> list3 = List.of(modelMapper.map(list2.get(i).getSellingProducts().getList(), ProductDTO[].class));
            CountAndProductsDTO elem = new CountAndProductsDTO(list3);
            searchedElement.getUsers().get(i).setCount(elem);
        }
        //Записването не съм го извел в отделен метод защото исках да се упражнявам с XML
        FileWriter fileWriter = new FileWriter(Path.of(FOURTH_QUERY).toFile());
        JAXBContext context = JAXBContext.newInstance(CountOfUserDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(searchedElement,fileWriter);
        return searchedElement;
    }
}
