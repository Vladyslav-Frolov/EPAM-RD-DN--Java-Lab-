package com.epam.finalproject.hotel.config.filter;

import com.epam.finalproject.hotel.Const;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SessionParametersFilter implements Filter {
//TODO вынести все параметры в переменные стринг (так сразу виден перечень)
private static final Logger LOGGER = Logger.getLogger(SessionParametersFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LOGGER.debug("doFilter starts");
        LOGGER.trace("I'm in the filter of important parameters");
        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getParameter("room_id") != null)
            req.getSession().setAttribute("session_room_id", req.getParameter("room_id"));

        if (req.getParameter("days_of_stay") != null)
            req.getSession().setAttribute("session_days_of_stay", req.getParameter("days_of_stay"));

        if (req.getParameter("check_in_date") != null)
            req.getSession().setAttribute("session_check_in_date", req.getParameter("check_in_date"));

        if (req.getParameter("check_out_date") != null)
            req.getSession().setAttribute("session_check_out_date", req.getParameter("check_out_date"));

        if (req.getParameter("adults") != null)
            req.getSession().setAttribute("session_adults", req.getParameter("adults"));

        if (req.getParameter("children") != null)
            req.getSession().setAttribute("session_children", req.getParameter("children"));

        if (req.getParameter("total_price") != null)
            req.getSession().setAttribute("session_total_price", req.getParameter("total_price"));

        if (req.getParameter("room_type") != null)
            req.getSession().setAttribute("session_room_type", req.getParameter("room_type"));

        if (req.getParameter("room_class") != null)
            req.getSession().setAttribute("session_room_class", req.getParameter("room_class"));

        if (req.getParameter("cost_per_day") != null)
            req.getSession().setAttribute("session_cost_per_day", req.getParameter("cost_per_day"));
        LOGGER.trace("///");
        if (req.getParameter(Const.COMMIT_TRUE) != null && req.getParameter(Const.COMMIT_TRUE).equals("commitFalse")) {
            req.getSession().setAttribute("commitTrue", req.getParameter(Const.COMMIT_TRUE));
        }
        LOGGER.trace("transferred important parameters to the session and exited the filter");
        LOGGER.debug("doFilter finished");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }
}
