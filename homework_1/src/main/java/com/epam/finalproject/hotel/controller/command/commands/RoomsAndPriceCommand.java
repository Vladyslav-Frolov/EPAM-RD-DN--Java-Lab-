package com.epam.finalproject.hotel.controller.command.commands;

import com.epam.finalproject.hotel.Path;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomsAndPriceCommand extends com.epam.finalproject.hotel.controller.command.Command {
    private static final Logger LOGGER = Logger.getLogger(RoomsAndPriceCommand.class);
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");

        LOGGER.debug("Command finished");

        return Path.PAGE_ROOMS_PRICES;
    }
}
