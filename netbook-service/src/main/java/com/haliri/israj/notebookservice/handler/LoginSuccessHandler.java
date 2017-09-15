package com.haliri.israj.notebookservice.handler;

import com.haliri.israj.notebookservice.config.UserDetailsConfig;
import com.haliri.israj.notebookservice.utils.AppUtils;
import com.haliri.israj.notebookservice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by israjhaliri on 8/30/17.
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsConfig userDetailsConfig;

    @Value("${jwt.header}")
    private String tokenHeader;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        AppUtils.getLogger(this).info("LOGIN SUCCESS");
        handle(request, response, a);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String username = authentication.getName();
        AppUtils.getLogger(this).info("HANDLER LOGIN SUCCESS FOR USERNAME [{}]",username);

        final UserDetails userDetails = userDetailsConfig.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        response.setHeader(tokenHeader, token);
        response.setHeader(HttpHeaders.LOCATION, request.getServletContext().getContextPath() + "/#/");

        try (PrintWriter writer = response.getWriter()) {
            writer.write("{\"code\":\""+response.getStatus()
                    + "\", \"status\":\"SUCESS\", "
                    + "\"token\":\""+token+"\"}");
            writer.flush();
            writer.close();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
