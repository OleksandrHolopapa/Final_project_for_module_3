package com.javarush.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

public class SuccessServletService {
    private final Random random = new Random();

    public void testYourLuck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isLuckOnYourSide()) req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req, resp);
        else resp.sendRedirect(req.getContextPath()+"/fail?answer="+req.getAttribute("failureMessage"));
    }

    private boolean isLuckOnYourSide() {
        return random.nextBoolean();
    }
}