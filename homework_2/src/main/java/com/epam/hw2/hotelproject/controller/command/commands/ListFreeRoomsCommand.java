package com.epam.hw2.hotelproject.controller.command.commands;

import com.epam.hw2.hotelproject.Path;
import com.epam.hw2.hotelproject.controller.command.Command;
import com.epam.hw2.hotelproject.dao.FreeRoomsDao;
import com.epam.hw2.hotelproject.model.FreeRooms;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFreeRoomsCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(ListFreeRoomsCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        LOGGER.debug("Command starts");
        String checkInDate = (String) request.getSession().getAttribute("session_check_in_date");
        String checkOutDate = (String) request.getSession().getAttribute("session_check_out_date");
        LOGGER.trace(checkInDate + "\n" + checkOutDate);
        if (checkInDate.equals("") || checkOutDate.equals("")) {
            request.setAttribute("enter_period", "label for jsp localization");
            LOGGER.trace("date is empty");
            return Path.PAGE_ROOMS_PRICES;
        }

        // get rooms items list
        List<FreeRooms> freeRoomsList = new FreeRoomsDao().getFreeRooms(checkInDate, checkOutDate);
        LOGGER.trace("Found in DB: menuItemsList --> " + freeRoomsList);

        // sort menu by category
        freeRoomsList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        // put menu items list to the request
        request.setAttribute("freeRoomsList", freeRoomsList);
        LOGGER.trace("Set the request attribute: menuItems --> " + freeRoomsList);

        LOGGER.debug("Command finished");
        return Path.PAGE_ROOMS_PRICES;
    }
}
