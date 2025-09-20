package com.javarush.servlets;

import com.javarush.utils.ServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/crossroads")
public class CrossroadsServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonPath = getServletContext().getRealPath("/resources/json/crossroads.json");
        ServletService.forward(jsonPath, "/WEB-INF/jsp/crossroads.jsp", req, resp);
    }
}