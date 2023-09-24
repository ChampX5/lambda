package com.lambda.primary.Middlewares;


import com.lambda.primary.Objects.Http.MutableHttpServletRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@Order(2)
public class AuthenticationMiddleware implements Filter {

    @Value("${application.config.auth.keyword}")
    private String authKeyword;

    /**
     *
     * @param servletRequest :
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     *
     * Method to add to the header the user information using mutable http object
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //extracting the protocol type
        String requestProtocol = servletRequest.getProtocol();

        if(requestProtocol.equalsIgnoreCase("HTTP/1.1")){
            MutableHttpServletRequest httpRequest = new MutableHttpServletRequest((HttpServletRequest) servletRequest);

            //extracting the header from the header list
            String authHeader = httpRequest.getHeader("Authorization");
            if(authHeader==null){
                httpRequest.setHeader("user","-1");
                filterChain.doFilter(
                        httpRequest,
                        servletResponse
                );
                return;
            }
            String authToken = authHeader.toLowerCase()
                    .trim().replaceFirst(authKeyword.toLowerCase(),"").trim();

            //extracting user associated with the token from database
            /*
                To be implemented
            */
            System.out.println(authToken);

        }

        //follows the execution
         filterChain.doFilter(
                servletRequest,
                servletResponse
        );
    }
}
