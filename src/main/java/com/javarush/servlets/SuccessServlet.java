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
import java.util.Random;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Random random = new Random();
    private final ObjectMapper jsonMapper = new JsonMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonPath = getServletContext().getRealPath("/resources/json/success.json");
        var jsonData = jsonMapper.readValue(new File(jsonPath), Map.class);

        if (isLuckOnYourSide()) {
            req.setAttribute("message", jsonData.get("successMessage"));
            req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req, resp);
        } else resp.sendRedirect(req.getContextPath()+"/fail?answer="+jsonData.get("failureMessage"));
    }

    private boolean isLuckOnYourSide() {
        return random.nextBoolean();
    }
}