package com.epam.hw3.hotelproject.controller.command.commands;

import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import com.epam.hw3.hotelproject.dao.OrderDaoImpl;
import com.epam.hw3.hotelproject.model.OrderImpl;
import com.epam.hw3.hotelproject.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class OwnCabinetCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(OwnCabinetCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        LOGGER.debug("Command starts");
        //4.1 Receiving all user orders after successful registration
        // procedure for taking out the user's order list
        List<OrderImpl> ordersOfUsers = new OrderDaoImpl().getUserOrders((User) request.getSession().getAttribute("user"));
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        LOGGER.debug("Command finished");
        return Path.PAGE_PERSONAL_ACCOUNT;
    }
}
