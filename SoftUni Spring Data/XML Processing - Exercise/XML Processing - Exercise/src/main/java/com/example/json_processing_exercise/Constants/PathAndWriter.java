package com.example.json_processing_exercise.Constants;

import com.example.json_processing_exercise.entities.dto.CountOfUserDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public enum PathAndWriter {
    ;
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static final String USER_PATH = "src/main/resources/files/users.xml";
    public static final String CATEGORY_PATH = "src/main/resources/files/categories.xml";
    public static final String PRODUCT_PATH = "src/main/resources/files/products.xml";
    public static final String FIRST_QUERY = "src/main/resources/output/Query1.xml";
    public static final String SECOND_QUERY = "src/main/resources/output/Query2.xml";

    public static final String THIRD_QUERY = "src/main/resources/output/Query3.xml";
    public static final String FOURTH_QUERY = "src/main/resources/output/Query4.xml";
    public static void writeInFile(List<?> list, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path));
        gson.toJson(list,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
    public static void writeInFileElement(CountOfUserDTO elem, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path));
        gson.toJson(elem,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}
