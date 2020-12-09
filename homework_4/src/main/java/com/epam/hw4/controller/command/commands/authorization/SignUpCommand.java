package com.epam.hw4.controller.command.commands.authorization;

import com.epam.hw4.Path;
import com.epam.hw4.controller.command.Command;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SignUpCommand extends Command {
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
