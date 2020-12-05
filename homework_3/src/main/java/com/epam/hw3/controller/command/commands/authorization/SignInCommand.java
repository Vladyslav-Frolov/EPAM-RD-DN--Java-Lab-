package com.epam.hw3.controller.command.commands.authorization;

import com.epam.hw3.Path;
import com.epam.hw3.controller.command.Command;
import com.epam.hw3.dao.OrderDao;
import com.epam.hw3.dao.UserDao;
import com.epam.hw3.model.Order;
import com.epam.hw3.model.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Go to the Sign in conform.
 */
public class SignInCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Command starts");
        HttpSession session = request.getSession();

        LOGGER.trace("я в sign in");
        // 1. Getting the entered username and password
        String login = request.getParameter("username");
        String password = request.getParameter("pass");
        LOGGER.trace("login: " + login + " pass:" + password);

        // 2. Login and password validation for emptiness, etc.

        // 3. Getting user or getting null
        User user = new UserDao().getUser(login, password);
        LOGGER.trace(user);
        LOGGER.trace(user.getRole());
        session.setAttribute("user", user);
        session.setAttribute("userRole", user.getRole());

        // 4. Send an Authentication Error Message
        if (user == null) {
            LOGGER.trace("такого юзера нет");
            request.setAttribute("identification_error", "Wrong login or password");
            return Path.PAGE_LOGIN;
        }

        //4.1 Receiving all user orders after successful registration
        // procedure for taking out the user's order list
        List<Order> ordersOfUsers = new OrderDao().getUserOrders((User) request.getSession().getAttribute("user"));
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        // 5. In case of successful authentication, redirection to your personal account
        LOGGER.debug("Command finished");
        return Path.REDIRECT_PERSONAL_ACCOUNT;
    }
}