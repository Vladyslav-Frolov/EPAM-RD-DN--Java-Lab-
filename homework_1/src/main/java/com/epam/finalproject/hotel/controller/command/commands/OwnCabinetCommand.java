package com.epam.finalproject.hotel.controller.command.commands;

import com.epam.finalproject.hotel.Path;
import com.epam.finalproject.hotel.controller.command.Command;
import com.epam.finalproject.hotel.dao.OrderDao;
import com.epam.finalproject.hotel.model.Order;
import com.epam.finalproject.hotel.model.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class OwnCabinetCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(OwnCabinetCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");
        //4.1 Receiving all user orders after successful registration
        // procedure for taking out the user's order list
        List<Order> ordersOfUsers = new OrderDao().getUserOrders((User) request.getSession().getAttribute("user"));
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        LOGGER.debug("Command finished");
        return Path.PAGE_PERSONAL_ACCOUNT;
    }
}
