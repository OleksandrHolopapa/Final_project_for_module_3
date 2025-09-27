package com.javarush.servlets;

import com.javarush.services.ServletService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class GameStartServlet extends HttpServlet {
    private final ServletService servletService = new ServletService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws jakarta.servlet.ServletException, java.io.IOException {
        req.getSession().setAttribute("username", "JohnDoe");
        servletService.setRequestAttributesFromJson(req, "/resources/json/gameStart.json", getServletContext());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
