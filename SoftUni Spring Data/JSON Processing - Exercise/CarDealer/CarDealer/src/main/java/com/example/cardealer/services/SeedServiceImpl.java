package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.CarDTO;
import com.example.cardealer.domain.dtos.CustomerDTO;
import com.example.cardealer.domain.dtos.PartDTO;
import com.example.cardealer.domain.dtos.SupplierDTO;
import com.example.cardealer.domain.entities.*;
import com.example.cardealer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.cardealer.Constants.PathsOfReadingAndWriting.*;

@Service
public class SeedServiceImpl implements SeedService {
    private final SupplierRepository supplierRepository;
    private final SaleRepository saleRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SeedServiceImpl(SupplierRepository supplierRepository, SaleRepository saleRepository, PartRepository partRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.supplierRepository = supplierRepository;
        this.saleRepository = saleRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepository.count() == 0) {
            FileReader fileReader = new FileReader(SUPPLIERS_PATH_READING);
            List<Supplier> list = Arrays.stream(
                            gson.fromJson(fileReader, SupplierDTO[].class))
                    .map(e -> modelMapper.map(e, Supplier.class))
                    .collect(Collectors.toList());
            this.supplierRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedParts() throws IOException {
        if (this.partRepository.count() == 0) {
            FileReader fileReader = new FileReader(PARTS_PATH_READING);
            List<Part> list = Arrays.stream(
                            gson.fromJson(fileReader, PartDTO[].class))
                    .map(e -> modelMapper.map(e, Part.class))
                    .map(elem -> randomSupplier(elem))
                    .collect(Collectors.toList());
            this.partRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedCars() throws IOException {
        if (this.carRepository.count() == 0) {
            FileReader fileReader = new FileReader(CARS_PATH_READING);
            List<Car> list = Arrays.stream(
                            gson.fromJson(fileReader, CarDTO[].class))
                    .map(e -> modelMapper.map(e, Car.class))
                    //.map(elem -> randomParts(elem))
                    .collect(Collectors.toList());
            this.carRepository.saveAllAndFlush(list);
            list.stream().map(elem -> randomParts(elem)).collect(Collectors.toList());
            this.carRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedCustomers() throws IOException {
        if (this.customerRepository.count() == 0) {
            FileReader fileReader = new FileReader(CUSTOMERS_PATH_READING);
            List<Customer> list = Arrays.stream(
                            gson.fromJson(fileReader, CustomerDTO[].class))
                    .map(e -> modelMapper.map(e, Customer.class))
                    .collect(Collectors.toList());
            this.customerRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedSales() {
        if (this.saleRepository.count() == 0) {
            List<Sale> list = new ArrayList<>();
            int[] percentage = new int[]{0,5,10,15,20,30,40,50};
            for (int i = 0; i < 30; i++) {
                Car car = this.carRepository.findRandomCar().orElseThrow(NoSuchFieldError::new);
                Customer customer = this.customerRepository.findRandomCustomer().orElseThrow(NoSuchFieldError::new);
                Random random = new Random();
                int num = random.nextInt(8);
                list.add(new Sale(percentage[num], car, customer));
            }
            this.saleRepository.saveAllAndFlush(list);
        }
    }

    private Part randomSupplier(Part part) {
        part.setSupplier(this.supplierRepository.findRandomSupplier().orElseThrow(NoSuchElementException::new));
        return part;
    }

    private Car randomParts(Car car) {
        Random random = new Random();
        int number = random.nextInt(3, 6);
        Set<Part> set = new HashSet<>();
        while (set.size() < number) {
            set.add(this.partRepository.findRandomPart().orElseThrow(NoSuchElementException::new));
        }
        car.setParts(set);
        return car;
    }
}
