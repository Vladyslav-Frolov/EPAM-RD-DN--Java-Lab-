package com.epam.finalproject.hotel.controller.command.commands.authorization;

import com.epam.finalproject.hotel.Path;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpCommand extends com.epam.finalproject.hotel.controller.command.Command {
    private static final Logger LOGGER = Logger.getLogger(SignUpCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");
        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);
        LOGGER.debug("Command finished");
        return Path.PAGE_SIGN_UP;
    }
}
