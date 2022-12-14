package com.example.cardealer.services;

import com.example.cardealer.domain.dtos.*;
import com.example.cardealer.domain.entities.*;
import com.example.cardealer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
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
    public void seedSuppliers() throws IOException, JAXBException {
        if (this.supplierRepository.count() == 0) {
            FileReader fileReader = new FileReader(SUPPLIERS_PATH_READING);
            JAXBContext context =JAXBContext.newInstance(SupplierWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SupplierWrapper supplierWrapper = (SupplierWrapper) unmarshaller.unmarshal(fileReader);
            List<Supplier> list = supplierWrapper.getList().stream().map(e->modelMapper.map(e,Supplier.class)).toList();
            this.supplierRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedParts() throws IOException, JAXBException {
        if (this.partRepository.count() == 0) {
            FileReader fileReader = new FileReader(PARTS_PATH_READING);
            JAXBContext context = JAXBContext.newInstance(PartWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PartWrapper partWrapper = (PartWrapper) unmarshaller.unmarshal(fileReader);
            List<Part> list = partWrapper.getList().stream().map(e->modelMapper.map(e,Part.class)).map(this::randomSupplier).toList();
            this.partRepository.saveAllAndFlush(list);
            fileReader.close();
        }
    }

    @Override
    public void seedCars() throws IOException, JAXBException {
        if (this.carRepository.count() == 0) {
            FileReader fileReader = new FileReader(CARS_PATH_READING);
            JAXBContext context = JAXBContext.newInstance(CarWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CarWrapper customerWrapper = (CarWrapper) unmarshaller.unmarshal(fileReader);
            List<Car> list = customerWrapper.getList().stream().map(e->modelMapper.map(e,Car.class)).toList();
            this.carRepository.saveAllAndFlush(list);
            list.stream().map(elem -> randomParts(elem)).collect(Collectors.toList());
            this.carRepository.saveAllAndFlush(list);
        }
    }

    @Override
    public void seedCustomers() throws IOException, JAXBException {
        if (this.customerRepository.count() == 0) {
            FileReader fileReader = new FileReader(CUSTOMERS_PATH_READING);
            JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CustomerWrapper customerWrapper = (CustomerWrapper) unmarshaller.unmarshal(fileReader);
            List<Customer> list = customerWrapper.getList().stream().map(e->{
                LocalDateTime elem = LocalDateTime.parse(e.getBirthDate());
                Customer customer = modelMapper.map(e,Customer.class);
                customer.setBirthDate(elem);
                return customer;
            }).toList();
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
        int number = random.nextInt(10, 21);
        Set<Part> set = new HashSet<>();
        while (set.size() < number) {
            set.add(this.partRepository.findRandomPart().orElseThrow(NoSuchElementException::new));
        }
        car.setParts(set);
        return car;
    }
}
