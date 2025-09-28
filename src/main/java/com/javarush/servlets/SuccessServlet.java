package com.javarush.servlets;

import com.javarush.services.ServletService;
import com.javarush.services.SuccessServletService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient ServletService servletService = ServletService.getInstance();
    private final transient SuccessServletService successServletService = new SuccessServletService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletService.setRequestAttributesFromJson(req, "/resources/json/success.json", getServletContext());
        successServletService.testYourLuck(req, resp);
    }
}