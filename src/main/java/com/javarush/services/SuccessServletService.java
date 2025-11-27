package com.javarush.services;

import com.javarush.exceptions.RequestRedirectionException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SuccessServletService {
    private final Logger logger = LoggerFactory.getLogger(SuccessServletService.class);
    private final Random random;
    private final String SUCCESS_JSP_ADDRESS = "/WEB-INF/jsp/success.jsp";
    private final String FAIL_SERVLET_ADDRESS = "/fail";

    public SuccessServletService() {
        this(new Random());
    }

    public SuccessServletService(Random random) {
        this.random = random;
    }

    public void testYourLuck(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (isLuckOnYourSide()) {
                logger.info("isLuckOnYourSide() returns true");
                req.getRequestDispatcher(SUCCESS_JSP_ADDRESS).forward(req, resp);
            } else {
                logger.info("isLuckOnYourSide() returns false");
                resp.sendRedirect(req.getContextPath() + FAIL_SERVLET_ADDRESS +"?answer=" + req.getAttribute("failureMessage"));
            }
        } catch (Exception e) {
            logger.error("Error processing luck check request: {}", e.getMessage());
            throw new RequestRedirectionException(e.getMessage());
        }
    }

    private boolean isLuckOnYourSide() {
        return random.nextBoolean();
    }
}