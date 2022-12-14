package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.entities.Category;
import com.example.json_processing_exercise.entities.Product;
import com.example.json_processing_exercise.entities.User;
import com.example.json_processing_exercise.entities.dto.CategoryReadingDTO;
import com.example.json_processing_exercise.entities.dto.ProductDTO;
import com.example.json_processing_exercise.entities.dto.ProductReadingDTO;
import com.example.json_processing_exercise.entities.dto.UserReadingDTO;
import com.example.json_processing_exercise.repositories.CategoryRepository;
import com.example.json_processing_exercise.repositories.ProductRepository;
import com.example.json_processing_exercise.repositories.UserRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.json_processing_exercise.Constants.PathAndWriter.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new Gson();
    }

    @Override
    public void seedUser() throws IOException, JAXBException {
        if (this.userRepository.count() == 0) {
           final FileReader fileReader = new FileReader(Path.of(USER_PATH).toFile());
            final JAXBContext context = JAXBContext.newInstance(UserReadingDTO.class);
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            final UserReadingDTO user = (UserReadingDTO) unmarshaller.unmarshal(fileReader);
            final List<User> list = user.getUsers().stream().map(e->modelMapper.map(e,User.class)).toList();
            fileReader.close();
            this.userRepository.saveAllAndFlush(list);
        }
    }

    @Override
    public void seedProduct() throws IOException, JAXBException {
        if (this.productRepository.count() == 0) {
            FileReader fileReader = new FileReader(new File(PRODUCT_PATH));
            JAXBContext context = JAXBContext.newInstance(ProductReadingDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ProductReadingDTO productReadingDTO = (ProductReadingDTO) unmarshaller.unmarshal(fileReader);
            List<Product> list = productReadingDTO.getList().stream()
                    .map(elem -> modelMapper.map(elem, Product.class))
                    .map(this::addSeller)
                    .map(this::addBuyer)
                    .map(this::addCategories)
                    .collect(Collectors.toList());
            this.productRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedCategory() throws IOException, JAXBException {
        if (this.categoryRepository.count() == 0) {
            FileReader fileReader = new FileReader(new File(CATEGORY_PATH));
            JAXBContext context = JAXBContext.newInstance(CategoryReadingDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CategoryReadingDTO categories = (CategoryReadingDTO) unmarshaller.unmarshal(fileReader);
            List<Category> list = categories.getCategories().stream().map(elem -> modelMapper.map(elem, Category.class)).collect(Collectors.toList());
            fileReader.close();
            this.categoryRepository.saveAllAndFlush(list);
        }
    }

    private Product addSeller(Product product) {
        User user = this.userRepository.findRandomUser().orElseThrow(NoSuchElementException::new);
        product.setSeller(user);
        return product;
    }

    private Product addBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
            User user = this.userRepository.findRandomUser().orElseThrow(NoSuchElementException::new);
            while (user.equals(product.getSeller())) {
                user = this.userRepository.findRandomUser().orElseThrow(NoSuchElementException::new);
            }
            product.setBuyer(user);
        }
        return product;
    }

    private Product addCategories(Product product) {
        Random random = new Random();
        int countCategories = random.nextInt((int) categoryRepository.count());
        Set<Category> categories = new HashSet<>();
        for (int i = 0; i <= countCategories; i++) {
            Category category = this.categoryRepository.findRandomCategory().orElseThrow(NoSuchElementException::new);
            categories.add(category);
        }
        product.setCategories(categories);
        return product;
    }
}
