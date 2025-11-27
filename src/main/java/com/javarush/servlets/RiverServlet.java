package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/river")
public class RiverServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final String RIVER_JSP_ADDRESS = "/WEB-INF/jsp/river.jsp";
    private final String RIVER_JSON_ADDRESS = "/resources/json/river.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletService.setRequestAttributesFromJson(req, RIVER_JSON_ADDRESS, getServletContext());
        req.getRequestDispatcher(RIVER_JSP_ADDRESS).forward(req, resp);
    }
}