package com.javarush.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Random;

class SuccessServletServiceTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private Random random;

    private SuccessServletService successServletService;

    @BeforeEach
    void begin() {
        MockitoAnnotations.openMocks(this);
        successServletService = new SuccessServletService(random);
    }

    @Test
    void shouldForwardToSuccessJspWhenMethodIsLuckOnYourSideReturnsTrue() throws Exception {
        Mockito.when(random.nextBoolean()).thenReturn(true);
        Mockito.when(request.getRequestDispatcher("/WEB-INF/jsp/success.jsp"))
                .thenReturn(requestDispatcher);

        successServletService.testYourLuck(request, response);

        Mockito.verify(request).getRequestDispatcher("/WEB-INF/jsp/success.jsp");
        Mockito.verify(requestDispatcher).forward(request, response);
    }

    @Test
    void shouldSendRedirectToFailWhenMethodIsLuckOnYourSideReturnsFalse() throws Exception {
        String failureMessage = "testFailureMessage";
        String contextPath = "/testContext";

        Mockito.when(random.nextBoolean()).thenReturn(false);
        Mockito.when(request.getAttribute("failureMessage")).thenReturn(failureMessage);
        Mockito.when(request.getContextPath()).thenReturn(contextPath);

        successServletService.testYourLuck(request, response);

        Mockito.verify(response).sendRedirect(contextPath + "/fail?answer=" + failureMessage);
    }
}