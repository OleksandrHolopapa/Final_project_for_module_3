package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/mountains")
public class MountainsServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final String MOUNTAINS_JSP_ADDRESS = "/WEB-INF/jsp/mountains.jsp";
    private final String MOUNTAINS_JSON_ADDRESS = "/resources/json/mountains.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletService.setRequestAttributesFromJson(req, MOUNTAINS_JSON_ADDRESS, getServletContext());
        req.getRequestDispatcher(MOUNTAINS_JSP_ADDRESS).forward(req, resp);
    }
}