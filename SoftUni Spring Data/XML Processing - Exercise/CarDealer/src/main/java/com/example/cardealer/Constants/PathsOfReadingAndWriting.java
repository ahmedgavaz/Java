package com.example.cardealer.Constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.util.List;

public class PathsOfReadingAndWriting {
    ;
    public static final String CARS_PATH_READING = "src/main/resources/files/cars.xml";
    public static final String CUSTOMERS_PATH_READING = "src/main/resources/files/customers.xml";
    public static final String PARTS_PATH_READING = "src/main/resources/files/parts.xml";
    public static final String SUPPLIERS_PATH_READING = "src/main/resources/files/suppliers.xml";
    public static final String QUERY1_PATH_WRITING = "src/main/resources/Output/Query1.xml";
    public static final String QUERY2_PATH_WRITING = "src/main/resources/Output/Query2.xml";
    public static final String QUERY3_PATH_WRITING = "src/main/resources/Output/Query3.xml";
    public static final String QUERY4_PATH_WRITING = "src/main/resources/Output/Query4.xml";
    public static final String QUERY5_PATH_WRITING = "src/main/resources/Output/Query5.xml";
    public static final String QUERY6_PATH_WRITING = "src/main/resources/Output/Query6.xml";
    public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setPrettyPrinting().create();
    public static final ModelMapper modelMapper = new ModelMapper();
    public static void writingJSON(String path, List<?> list) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path));
        gson.toJson(list,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}
