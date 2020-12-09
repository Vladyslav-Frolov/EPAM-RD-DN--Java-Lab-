package com.epam.hw4.controller.command.commands.authorization;

import com.epam.hw4.Path;
import com.epam.hw4.controller.command.Command;
import com.epam.hw4.dao.OrderDaoImpl;
import com.epam.hw4.dao.UserDaoImpl;
import com.epam.hw4.model.OrderImpl;
import com.epam.hw4.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Go to the Sign in conform.
 */
@Component
public class SignInCommand extends Command {

    private static final Logger LOGGER = Logger.getLogger(SignInCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Command starts");
        HttpSession session = request.getSession();

        LOGGER.trace("� � sign in");
        // 1. Getting the entered username and password
        String login = request.getParameter("username");
        String password = request.getParameter("pass");
        LOGGER.trace("login: " + login + " pass:" + password);

        // 2. Login and password validation for emptiness, etc.

        // 3. Getting user or getting null
        User user = new UserDaoImpl().getUser(login, password);
        LOGGER.trace(user);
        LOGGER.trace(user.getRole());
        session.setAttribute("user", user);
        session.setAttribute("userRole", user.getRole());

        // 4. Send an Authentication Error Message
        if (user == null) {
            LOGGER.trace("������ ����� ���");
            request.setAttribute("identification_error", "Wrong login or password");
            return Path.PAGE_LOGIN;
        }

        //4.1 Receiving all user orders after successful registration
        // procedure for taking out the user's order list
        List<OrderImpl> ordersOfUsers = new OrderDaoImpl().getUserOrders((User) request.getSession().getAttribute("user"));
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        // 5. In case of successful authentication, redirection to your personal account
        LOGGER.debug("Command finished");
        return Path.REDIRECT_PERSONAL_ACCOUNT;
    }
}