package com.javarush.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServletServiceTest {

    private ServletService servletService;

    @Mock
    private ServletContext servletContext;

    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void begin() {
        servletService = ServletService.getInstance();
    }

    @Test
    void shouldSetAttributesWhenJsonIsNotEmpty() throws IOException {
        String jsonFilePath = "test.json";
        String realPath = "/path/to/test.json";
        Map<String, String> testData = new HashMap<>();
        testData.put("key1", "value1");
        testData.put("key2", "value2");

        when(servletContext.getRealPath(jsonFilePath)).thenReturn(realPath);
        ObjectMapper realMapper = new ObjectMapper();
        File tempFile = File.createTempFile("test", ".json");
        realMapper.writeValue(tempFile, testData);

        when(servletContext.getRealPath(jsonFilePath)).thenReturn(tempFile.getAbsolutePath());

        boolean result = servletService.setRequestAttributesFromJson(request, jsonFilePath, servletContext);

        assertTrue(result);
        verify(request, times(testData.size())).setAttribute(anyString(), anyString());
        testData.forEach((key, value) -> verify(request).setAttribute(key, value));

        tempFile.delete();
    }

    @Test
    void shouldReturnFalseWhenJsonIsNotFound() {
        String invalidPath = "nonexistent.json";
        when(servletContext.getRealPath(invalidPath)).thenReturn("/invalid/path");

        boolean result = servletService.setRequestAttributesFromJson(request, invalidPath, servletContext);

        assertFalse(result);
        verify(request, never()).setAttribute(anyString(), anyString());
    }

    @Test
    void shouldReturnFalseWhenJsonIsEmpty() throws IOException {
        String jsonFilePath = "empty.json";
        File tempFile = File.createTempFile("empty", ".json");
        tempFile.deleteOnExit();

        when(servletContext.getRealPath(jsonFilePath)).thenReturn(tempFile.getAbsolutePath());

        boolean result = servletService.setRequestAttributesFromJson(request, jsonFilePath, servletContext);

        assertFalse(result);
        verify(request, never()).setAttribute(anyString(), anyString());
    }
}