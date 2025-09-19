package com.javarush.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/fail")
public class FailServlet extends HttpServlet {
    Map<String, File> map = new HashMap<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");
        req.setAttribute("answer", answer);
        req.getRequestDispatcher("/WEB-INF/jsp/fail.jsp").forward(req, resp);
    }
}