package com.javarush.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.Map;

@WebServlet("/boat")
public class BoatServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final ObjectMapper jsonMapper = new JsonMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonPath = getServletContext().getRealPath("/resources/json/boat.json");
        var jsonData = jsonMapper.readValue(new File(jsonPath), Map.class);
        req.setAttribute("message", jsonData.get("message"));
        req.setAttribute("choice", jsonData.get("choice"));
        req.getRequestDispatcher("/WEB-INF/jsp/boat.jsp").forward(req, resp);
    }
}
