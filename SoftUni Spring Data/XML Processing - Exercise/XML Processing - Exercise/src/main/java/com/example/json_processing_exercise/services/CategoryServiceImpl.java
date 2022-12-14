package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.dto.CategoriesWrapper;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import com.example.json_processing_exercise.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.json_processing_exercise.Constants.PathAndWriter.THIRD_QUERY;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryTotalProductsDTO> findAllByCountOfProducts() throws IOException, JAXBException {
        FileWriter fileWriter = new FileWriter(Path.of(THIRD_QUERY).toFile());
        List<CategoryTotalProductsDTO> list =this.categoryRepository.getCategorySummary().orElseThrow(NoSuchElementException::new);
        CategoriesWrapper categoriesWrapper = new CategoriesWrapper(list);
        //Записването не съм го извел в отделен метод защото исках да се упражнявам с XML
        JAXBContext context = JAXBContext.newInstance(CategoriesWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(categoriesWrapper,fileWriter);
        return list;
    }
}
