package com.javarush.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/fail")
public class FailServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String FAIL_JSP_ADDRESS = "/WEB-INF/jsp/fail.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(FAIL_JSP_ADDRESS).forward(req, resp);
    }
}