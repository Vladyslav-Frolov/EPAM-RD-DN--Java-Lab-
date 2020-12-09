package com.epam.hw3.hotelproject.controller.command.commands;

import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import com.epam.hw3.hotelproject.dao.FreeRoomsDao;
import com.epam.hw3.hotelproject.model.FreeRooms;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.util.List;

@Component
public class ListFreeRoomsCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(ListFreeRoomsCommand.class);
    @Autowired
    FreeRoomsDao freeRoomsDao;

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
        List<FreeRooms> freeRoomsList = freeRoomsDao.getFreeRooms(checkInDate, checkOutDate);
        LOGGER.trace("Found in DB: menuItemsList --> freeRoomsList");

        // sort menu by category
        freeRoomsList.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        // put menu items list to the request
        request.setAttribute("freeRoomsList", freeRoomsList);
        LOGGER.trace("Set the request attribute: menuItems --> freeRoomsList ");

        LOGGER.debug("Command finished");

        return Path.PAGE_ROOMS_PRICES;
    }
}
