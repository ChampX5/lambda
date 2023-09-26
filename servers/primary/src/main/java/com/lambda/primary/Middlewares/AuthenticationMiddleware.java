package com.lambda.primary.Middlewares;


import com.lambda.primary.Objects.Http.MutableHttpServletRequest;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
@Order(1)
public class AuthenticationMiddleware implements Filter {

    @Value("${application.config.auth.keyword}")
    private String authKeyword;


    private UserServices userServices;
    private AuthTokenServices authTokenServices;

    @Autowired
    public AuthenticationMiddleware(UserServices userServices, AuthTokenServices authTokenServices){
        this.userServices = userServices;
        this.authTokenServices = authTokenServices;
    }

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
            HttpServletRequest request = (HttpServletRequest)servletRequest;

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
            httpRequest.setHeader("serverAuth",authToken);
            String username = authTokenServices.fetchUsernameOnAuthToken(authToken.trim());
            httpRequest.setHeader("user",username);
            filterChain.doFilter(
                    httpRequest,
                    servletResponse
            );
            return;

        }

        //follows the execution
         filterChain.doFilter(
                 servletRequest,
                servletResponse
        );
    }
}
