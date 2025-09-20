package com.javarush.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ServletService {
    private static final ObjectMapper jsonMapper = new JsonMapper();

    public static void forward(String jsonPath, String jspPath, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var jsonData = jsonMapper.readValue(new File(jsonPath), Map.class);

        req.setAttribute("message", jsonData.get("message"));
        req.setAttribute("rightAnswer", jsonData.get("rightAnswer"));
        req.setAttribute("wrongAnswer", jsonData.get("wrongAnswer"));
        req.setAttribute("consequencesOfWrongChoices", jsonData.get("consequencesOfWrongChoices"));

        req.getRequestDispatcher(jspPath).forward(req, resp);
    }
}
