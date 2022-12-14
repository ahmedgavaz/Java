package com.example.json_processing_exercise.services;

import com.example.json_processing_exercise.Constants.PathAndWriter;
import com.example.json_processing_exercise.entities.dto.CategoryTotalProductsDTO;
import com.example.json_processing_exercise.entities.dto.ProductInRangeDTO;
import com.example.json_processing_exercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
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
    public List<ProductInRangeDTO> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductInRangeDTO> list = this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low,high)
                .orElseThrow(NoSuchElementException::new).stream().map(elem->elem.toProductQuery1DTO()).collect(Collectors.toList());
        PathAndWriter.writeInFile(list,FIRST_QUERY);
        return list;
    }


}
