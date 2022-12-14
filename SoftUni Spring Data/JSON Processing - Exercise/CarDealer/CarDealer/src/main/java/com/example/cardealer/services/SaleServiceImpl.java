package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.SalesDiscountsDTO;
import com.example.cardealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.QUERY6_PATH_WRITING;
import static com.example.cardealer.Constants.PathsOfReadingAndWriting.writingJSON;

@Service
public class SaleServiceImpl implements SaleService{
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<SalesDiscountsDTO> findAllBy() {
        return this.saleRepository.findAllBy().orElseThrow(NoSuchElementException::new);
    }

    public void salesWithAppliedDiscount() throws IOException {
        List<SalesDiscountsDTO> list = findAllBy();
        writingJSON(QUERY6_PATH_WRITING,list);
    }
}
