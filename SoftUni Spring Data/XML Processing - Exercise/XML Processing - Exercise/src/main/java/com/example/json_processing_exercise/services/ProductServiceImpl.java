package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import com.example.json_processing_exercise.entities.dto.ProductInRangeDTO;
import com.example.json_processing_exercise.entities.dto.ProductsInRangeWrapper;
import com.example.json_processing_exercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.json_processing_exercise.Constants.PathAndWriter.FIRST_QUERY;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public List<ProductInRangeDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException, JAXBException {
        List<ProductInRangeDTO> list = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low,high)
                .orElseThrow(NoSuchElementException::new).stream().map(elem->elem.toProductQuery1DTO()).collect(Collectors.toList());
        //Записването не съм го извел в отделен метод защото исках да се упражнявам с XML
        FileWriter fileWriter = new FileWriter(Path.of(FIRST_QUERY).toFile());
        JAXBContext context = JAXBContext.newInstance(ProductsInRangeWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        ProductsInRangeWrapper products = new ProductsInRangeWrapper(list);
        marshaller.marshal(products,fileWriter);
        return list;
    }


}
