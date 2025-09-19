package com.javarush.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/mountains")
public class MountainsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession reqSession = req.getSession();
        reqSession.setAttribute("Message", "There will be my message");
        reqSession.setAttribute("rightAnswer", "There will be my right answer");
        reqSession.setAttribute("wrongAnswer", "There will be my wrong answer");

        req.getRequestDispatcher("/WEB-INF/jsp/mountains.jsp").forward(req, resp);
    }
}