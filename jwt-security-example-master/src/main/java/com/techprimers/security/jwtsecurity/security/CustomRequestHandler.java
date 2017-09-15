package com.techprimers.security.jwtsecurity.security;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.haliri.israj.notebookservice.utils.AppUtils;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * Created by israjhaliri on 8/30/17.
 */
public class CustomRequestHandler extends HttpServletRequestWrapper {

    public CustomRequestHandler(HttpServletRequest request) {
        super(request);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        System.out.println("RUN GET READER {}"+super.getReader());
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }


}
