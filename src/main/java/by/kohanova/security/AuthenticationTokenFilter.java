package by.kohanova.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationTokenFilter extends GenericFilterBean {
    private final TokenAuthenticationService authenticationService;

    public AuthenticationTokenFilter(TokenAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Authentication authentication = authenticationService.authenticate(httpRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
