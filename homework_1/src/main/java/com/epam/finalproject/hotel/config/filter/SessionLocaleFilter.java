package com.epam.finalproject.hotel.config.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionLocaleFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SessionLocaleFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("doFilter starts");
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("sessionLocale") != null) {
            req.getSession().setAttribute("lang", req.getParameter("sessionLocale"));
        } else if (req.getSession().getAttribute("lang") == null) {
            req.getSession().setAttribute("lang", req.getServletContext().getInitParameter("language"));
        }
        LOGGER.debug("doFilter finished");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //
    }

    @Override
    public void init(FilterConfig arg0) {
        //
    }
}
