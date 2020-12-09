package com.epam.hw4.controller.command.commands;

import com.epam.hw4.Path;
import com.epam.hw4.controller.command.Command;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RoomsAndPriceCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(RoomsAndPriceCommand.class);
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");

        LOGGER.debug("Command finished");

        return Path.PAGE_ROOMS_PRICES;
    }
}
