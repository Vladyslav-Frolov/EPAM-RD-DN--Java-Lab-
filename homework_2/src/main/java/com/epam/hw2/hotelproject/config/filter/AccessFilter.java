package com.epam.hw2.hotelproject.config.filter;

import com.epam.hw2.hotelproject.Path;
import com.epam.hw2.hotelproject.controller.command.CommandContainer;
import com.epam.hw2.hotelproject.model.Role;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(AccessFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("doFilter starts");
        HttpServletRequest req = (HttpServletRequest) request;

        if (accessAllowed(req)) {
            LOGGER.trace("access allowed, executing the selected command");
            chain.doFilter(request, response);
        } else {
            String errorMessasge = "you need to log in";

            req.setAttribute("errorMessage", errorMessasge);

            LOGGER.trace("access not allowed, forward to --> " + Path.PAGE_LOGIN);

            req.getRequestDispatcher(Path.PAGE_LOGIN)
                    .forward(request, response);
        }
        LOGGER.debug("doFilter finished");
    }

    private boolean accessAllowed(HttpServletRequest req) {
        LOGGER.debug("accessAllowed starts");
        String commandName = req.getParameter("command");
        LOGGER.trace("filter command name: " + commandName);

        HttpSession session = req.getSession(false);
        if (session == null)
            return false;

        if (!CommandContainer.isAuthorized(commandName)) {
            LOGGER.trace("filter command consist: " + CommandContainer.isAuthorized(commandName) +
                    ", do not filter, return true");
            return true;
        }

        Role userRole = (Role) session.getAttribute("userRole");
        LOGGER.trace("filter user role: " + userRole);
        if (userRole == null)
            return false;
        LOGGER.debug("accessAllowed finished");
        return true;
    }


    @Override
    public void destroy() {
        // some text
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // some text
    }
}
