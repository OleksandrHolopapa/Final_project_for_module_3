package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final String TRAVEL_JSP_ADDRESS = "/WEB-INF/jsp/travel.jsp";
    private final String TRAVEL_JSON_ADDRESS = "/resources/json/travel.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userInput");
        req.getSession().setAttribute("username", username);
        servletService.setRequestAttributesFromJson(req, TRAVEL_JSON_ADDRESS, getServletContext());
        req.getRequestDispatcher(TRAVEL_JSP_ADDRESS).forward(req, resp);
    }
}