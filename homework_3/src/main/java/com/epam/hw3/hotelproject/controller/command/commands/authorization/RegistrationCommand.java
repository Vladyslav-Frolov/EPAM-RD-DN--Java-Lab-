package com.epam.hw3.hotelproject.controller.command.commands.authorization;

import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RegistrationCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");

//TODO удалить после последней отладки
        LOGGER.trace(login);
        LOGGER.trace(email);
        LOGGER.trace(password);
        LOGGER.trace(firstName);
        LOGGER.trace(lastName);
        LOGGER.debug("Command finished");
        return Path.PAGE_PERSONAL_ACCOUNT;
    }
}
