package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/forest")
public class ForestServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final String FOREST_JSP_ADDRESS = "/WEB-INF/jsp/forest.jsp";
    private final String FOREST_JSON_ADDRESS = "/resources/json/forest.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       servletService.setRequestAttributesFromJson(req, FOREST_JSON_ADDRESS, getServletContext());
       req.getRequestDispatcher(FOREST_JSP_ADDRESS).forward(req, resp);
    }
}