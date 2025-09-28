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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws jakarta.servlet.ServletException, java.io.IOException {
        req.getSession().setAttribute("username", "JohnDoe");
        servletService.setRequestAttributesFromJson(req, "/resources/json/gameStart.json", getServletContext());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
