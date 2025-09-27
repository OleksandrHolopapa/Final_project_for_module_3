package com.javarush.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class ServletService {
    private final ObjectMapper jsonMapper = new JsonMapper();
    private final Logger logger = LoggerFactory.getLogger(ServletService.class);

    private Map<String, String> getJsonData(ServletContext context, String jsonFilePath) {
        try {
            String jsonPath = context.getRealPath(jsonFilePath);
            return jsonMapper.readValue(new File(jsonPath), new TypeReference<>() {});
        } catch (IOException e) {
            logger.error("Failed to read JSON file: {}", e.getMessage());
            return Collections.emptyMap();
        }
    }

    public boolean setRequestAttributesFromJson(HttpServletRequest request, String jsonFilePath, ServletContext servletContext) {
        Map<String, String> jsonData = getJsonData(servletContext, jsonFilePath);

        if (jsonData.isEmpty()) {
            logger.error("JSON data is empty");
            return false;
        }

        jsonData.forEach(request::setAttribute);
        return true;
    }
}