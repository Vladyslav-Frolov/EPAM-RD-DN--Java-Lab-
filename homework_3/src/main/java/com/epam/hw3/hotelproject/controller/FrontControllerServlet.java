package com.epam.hw3.hotelproject.controller;

import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import com.epam.hw3.hotelproject.controller.command.CommandContainerImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class FrontControllerServlet {
    private static final Logger LOGGER = Logger.getLogger(FrontControllerServlet.class);

    @Autowired
    CommandContainerImpl commandContainerImpl;

    @GetMapping("/frontControllerServlet")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
        } catch (IOException | ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/frontControllerServlet")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
        } catch (IOException | ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException, SQLException {

        LOGGER.debug("--> Controller starts");

        // 1. extract command name from the request
        String commandName = request.getParameter("command");
        LOGGER.trace("--> Request parameter: command --> " + commandName);


        // 1.2. go to the previous page (via a saved command) or save the current command
        if (commandName == null) {
            LOGGER.trace("I'm in the dispatcher and it's empty");
            commandName = (String) request.getSession().getAttribute("path");
            LOGGER.trace("+ 1-1. I execute the previous command: " + commandName);
        } else {
            request.getSession().setAttribute("path", commandName);
            LOGGER.trace("+ 1-2. executed a new command and wrote down the session attribute: " + commandName);
        }


        // 2. obtain command object by its name
        Command command = commandContainerImpl.get(commandName);
        LOGGER.trace("--> Obtained command --> " + command);
        LOGGER.trace("+ 2. pulled the command: " + commandName + " = " + command);


        // 3. execute command and get forward address
        String forward = null;
        LOGGER.trace("+ 3. started executing the command: " + commandName);
        forward = command.execute(request, response);
        LOGGER.trace("+ 3-1. executed the command: " + commandName);
        LOGGER.trace("--> Forward address --> " + forward);
        LOGGER.debug("--> Controller finished, now go to forward address --> " + forward);


        // 4. if the forward address is not null go to the address
        if (forward != null) {
            if (forward.contains("redirect")) {
                forward = forward.replace("redirect/", "");
                LOGGER.trace("4-1. I'm in redirect: " + forward);
                response.sendRedirect(forward);
            } else {
                LOGGER.trace("4-2. I'm in forward: " + forward);
                request.getRequestDispatcher(forward).forward(request, response);
            }

        } else {
            request.getRequestDispatcher(Path.PAGE_ERROR_PAGE).forward(request, response);
            LOGGER.trace("4-3. null in forward address");
        }
    }
}
