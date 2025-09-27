package com.javarush.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SuccessServletService {
    private final Logger logger = LoggerFactory.getLogger(SuccessServletService.class);
    private final Random random = new Random();

    public void testYourLuck(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (isLuckOnYourSide()) {
                logger.info("isLuckOnYourSide() returns true");
                req.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(req, resp);
            } else {
                logger.info("isLuckOnYourSide() returns false");
                resp.sendRedirect(req.getContextPath() + "/fail?answer=" + req.getAttribute("failureMessage"));
            }
        } catch (Exception e) {
            logger.error("Error processing luck check request: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private boolean isLuckOnYourSide() {
        return random.nextBoolean();
    }
}