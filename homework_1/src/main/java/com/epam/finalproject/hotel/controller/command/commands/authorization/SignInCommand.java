package com.epam.finalproject.hotel.controller.command.commands.authorization;

import com.epam.finalproject.hotel.Path;
import com.epam.finalproject.hotel.controller.command.Command;
import com.epam.finalproject.hotel.dao.OrderDao;
import com.epam.finalproject.hotel.dao.UserDao;
import com.epam.finalproject.hotel.model.Order;
import com.epam.finalproject.hotel.model.User;
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

        LOGGER.trace("� � sign in");
        // 1. ��������� ��������� ������ � ������
        String login = request.getParameter("username");
        String password = request.getParameter("pass");
        LOGGER.trace("login: " + login + " pass:" + password);

        // 2. ��������� ������ � ������ �� ������� � �. �.

        // 3. ��������� ����� ��� ��������� null
        User user = new UserDao().getUser(login, password);
        LOGGER.trace(user);
        LOGGER.trace(user.getRole());
        session.setAttribute("user", user);
        session.setAttribute("userRole", user.getRole());

        // 4. �������� ��������� �� ������ ��������������
        if (user == null) {
            LOGGER.trace("������ ����� ���");
            request.setAttribute("identification_error", "Wrong login or password");
            return Path.PAGE_LOGIN;
        }

        //4.1 ��������� ���� ������� ����� ����� �������� �����������
        // ��������� ��������� ������ ����� �����
        List<Order> ordersOfUsers = new OrderDao().getUserOrders((User) request.getSession().getAttribute("user"));
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        // 5. � ������ �������� ������������� ��������������� �� ������ �������
        LOGGER.debug("Command finished");
        return Path.REDIRECT_PERSONAL_ACCOUNT;
    }
}