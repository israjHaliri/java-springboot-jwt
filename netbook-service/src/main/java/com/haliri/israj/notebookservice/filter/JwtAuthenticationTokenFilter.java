package com.haliri.israj.notebookservice.filter;

import com.haliri.israj.notebookservice.utils.AppUtils;
import com.haliri.israj.notebookservice.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by israjhaliri on 8/30/17.
 */
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(this.tokenHeader);

        if(StringUtils.hasText(authToken) && authToken.startsWith("Bearer "))
            authToken = authToken.substring(7);

//        AppUtils.getLogger(this).info("TOKEN LOGIN IS : {} ",authToken);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
//        AppUtils.getLogger(this).info("USERNAME FROM TOKEN IS : {} ",username);
//        AppUtils.getLogger(this).info("SECURITY CONTEXT HOLDER IS : {} ",SecurityContextHolder.getContext().getAuthentication());

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            AppUtils.getLogger(this).info("GOING TO VALIDATE TOKEN");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}
