package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Serial;

@WebServlet("/start")
public class GameStartServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final String GAME_START_JSP_ADDRESS = "index.jsp";
    private final String GAME_START_JSON_ADDRESS = "/resources/json/gameStart.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws jakarta.servlet.ServletException, java.io.IOException {
        servletService.setRequestAttributesFromJson(req, GAME_START_JSON_ADDRESS, getServletContext());
        req.getRequestDispatcher(GAME_START_JSP_ADDRESS).forward(req, resp);
    }
}