package com.javarush.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ServletService {
    private static final ObjectMapper jsonMapper = new JsonMapper();

    private Map<String, String> getJsonData(ServletContext context, String jsonFilePath) throws IOException {
        String jsonPath = context.getRealPath(jsonFilePath);
        return jsonMapper.readValue(new File(jsonPath), new TypeReference<>() {});
    }

    public void setRequestAttributesFromJson(HttpServletRequest request, String jsonFilePath, ServletContext servletContext) throws IOException {
        Map<String, String> jsonData = getJsonData(servletContext, jsonFilePath);
        for (Map.Entry<String, String> entry : jsonData.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}