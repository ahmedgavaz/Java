package com.example.cardealer.Constants;

import com.google.gson.*;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PathsOfReadingAndWriting {
    ;
    public static final String CARS_PATH_READING = "src/main/resources/files/cars.json";
    public static final String CUSTOMERS_PATH_READING = "src/main/resources/files/customers.json";
    public static final String PARTS_PATH_READING = "src/main/resources/files/parts.json";
    public static final String SUPPLIERS_PATH_READING = "src/main/resources/files/suppliers.json";
    public static final String QUERY1_PATH_WRITING = "src/main/resources/Output/Query1.json";
    public static final String QUERY2_PATH_WRITING = "src/main/resources/Output/Query2.json";
    public static final String QUERY3_PATH_WRITING = "src/main/resources/Output/Query3.json";
    public static final String QUERY4_PATH_WRITING = "src/main/resources/Output/Query4.json";
    public static final String QUERY5_PATH_WRITING = "src/main/resources/Output/Query5.json";
    public static final String QUERY6_PATH_WRITING = "src/main/resources/Output/Query6.json";
    public static final ModelMapper modelMapper = new ModelMapper();
    public static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter1())
            // .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeAdapter())
            .setPrettyPrinting().create();
    static class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime> {

        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        }
    }
    static class LocalDateTimeAdapter1 implements JsonDeserializer<LocalDateTime>{
        @Override
        public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDateTime.parse(jsonElement.getAsString());
        }
    }
    public static void writingJSON(String path, List<?> list) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(path));
        gson.toJson(list,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}
