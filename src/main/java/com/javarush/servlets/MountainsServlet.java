package com.javarush.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.Map;

@WebServlet("/mountains")
public class MountainsServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonPath = getServletContext().getRealPath("/resources/json/mountains.json");
        var jsonData = objectMapper.readValue(new File(jsonPath), Map.class);

        req.setAttribute("message", jsonData.get("message"));
        req.setAttribute("rightAnswer", jsonData.get("rightAnswer"));
        req.setAttribute("wrongAnswer", jsonData.get("wrongAnswer"));
        req.setAttribute("consequencesOfWrongChoices", jsonData.get("consequencesOfWrongChoices"));

        req.getRequestDispatcher("/WEB-INF/jsp/mountains.jsp").forward(req, resp);
    }
}