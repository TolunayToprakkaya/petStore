package com.example.petstore.factory;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class JsonFileLoader {

    public static JsonElement getJsonForFile(String fileName) {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        JsonParser jp = new JsonParser();
        Resource resource = resourceLoader.getResource("classpath:/json/" + fileName + ".json");
        InputStream stream = null;
        try {
            stream = resource.getInputStream();
        } catch (IOException e) {
            System.err.println("Read of file " + fileName + " failed\n");
        }
        JsonElement root = jp.parse(new InputStreamReader(stream));
        return root;
    }
}
