package com.epam.finalproject.hotel.controller;

import com.epam.finalproject.hotel.Path;
import com.epam.finalproject.hotel.controller.command.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontControllerServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(FrontControllerServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
        } catch (IOException | ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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

        LOGGER.debug("ЧЧ> Controller starts");
        // 1. extract command name from the request
        String commandName = request.getParameter("command");
        LOGGER.trace("ЧЧ> Request parameter: command --> " + commandName);


        // 1.2. переход на предыдущую страницу (через сохранЄнную команду) или сохранение текущей команды
        if (commandName == null) {
            LOGGER.trace("€ в диспетчере и тут пусто");
            commandName = (String) request.getSession().getAttribute("path");
            LOGGER.trace("+ 1. исполн€ю предедыщующую команду: " + commandName);
        } else {
            request.getSession().setAttribute("path", commandName);
            LOGGER.trace("+ 1. выполнил новую команду и записал атрибут сессии: " + commandName);
        }


        // 2. obtain command object by its name
        Command command = CommandContainer.get(commandName);
        LOGGER.trace("ЧЧ> Obtained command --> " + command);
        LOGGER.trace("+ 2. вытащил команду: " + commandName + " = " + command);


        // 3. execute command and get forward address
        String forward = null;
        LOGGER.trace("+ 3. начал выполн€ть команду: " + commandName);
        forward = command.execute(request, response);
        LOGGER.trace("+ 4. выполнил команду: " + commandName);
        LOGGER.trace("ЧЧ> Forward address --> " + forward);
        LOGGER.debug("ЧЧ> Controller finished, now go to forward address --> " + forward);


        // 4. if the forward address is not null go to the address
        if (forward != null) {
            if (forward.contains("redirect")) {
                forward = forward.replaceAll("\\Qredirect/\\E", "");
                LOGGER.trace("€ в редиректе: " + forward);
                response.sendRedirect(forward);
            }else{
                request.getRequestDispatcher(forward).forward(request, response);
            }

        } else {
            request.getRequestDispatcher(Path.PAGE_ERROR_PAGE).forward(request, response);
            LOGGER.trace("null в адресе форварда");
        }
    }
}
