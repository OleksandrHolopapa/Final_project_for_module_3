package com.javarush.servlets;

import com.javarush.services.ServletService;
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
    private final transient ServletService servletService = new ServletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletService.setRequestAttributesFromJson(req, "/resources/json/crossroads.json", getServletContext());
        req.getRequestDispatcher("/WEB-INF/jsp/crossroads.jsp").forward(req, resp);
    }
}