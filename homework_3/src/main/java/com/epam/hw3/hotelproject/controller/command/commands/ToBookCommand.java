package com.epam.hw3.hotelproject.controller.command.commands;

import com.epam.hw3.hotelproject.Const;
import com.epam.hw3.hotelproject.Path;
import com.epam.hw3.hotelproject.controller.command.Command;
import com.epam.hw3.hotelproject.dao.ClientDao;
import com.epam.hw3.hotelproject.dao.OrderDao;
import com.epam.hw3.hotelproject.model.Order;
import com.epam.hw3.hotelproject.model.OrderImpl;
import com.epam.hw3.hotelproject.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.epam.hw3.hotelproject.model.RoomStatus.UNAVAILABLE;

@Component
public class ToBookCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(ToBookCommand.class);

    @Autowired
    private Order order;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ClientDao clientDao;

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) {
        //TODO добавить проверку на админа
        LOGGER.debug("Command starts");
        LOGGER.trace("1tb - I'm in toBook command");

        User registeredUser = (User) request.getSession().getAttribute("user");

        if(!request.getSession().getAttribute(Const.COMMIT_TRUE).equals(Const.COMMIT_TRUE)){
            order.setId(orderDao.getLastOrderId() + 1);
            order.setClientId(clientDao.getClientId(registeredUser));// client
            LOGGER.trace("2tb - setClientId in toBook: " + clientDao.getClientId((User) request.getSession().getAttribute("user")));
            order.setRoomId(Integer.parseInt(request.getSession().getAttribute("session_room_id").toString()));// rooms
            LOGGER.trace("3tb - ... in toBook: ");
            order.setCheckIn((String) request.getSession().getAttribute("session_check_in_date")); // check in
            LOGGER.trace("4tb - ... in toBook: ");
            order.setCheckOut((String) request.getSession().getAttribute("session_check_out_date")); // check out
            LOGGER.trace("5tb - ... in toBook: ");
            order.setTotalPrice(Double.parseDouble(request.getSession().getAttribute("session_total_price").toString())); // total price
            LOGGER.trace("6tb - ... in toBook: ");
            order.setPaymentStatus(false);
            LOGGER.trace("7tb - ... in toBook: ");
            order.setStartBookingTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.")
                    .withZone(ZoneId.systemDefault())
                    .format(Clock.systemDefaultZone().instant())); // start booking datetime
            LOGGER.trace("8tb - ... in toBook: ");
            order.setOrderStatus(UNAVAILABLE); // room order status
            LOGGER.trace("9tb - ... in toBook: ");

            Boolean commitResult = orderDao.insertNewOrder(order);
            if (Boolean.TRUE.equals(commitResult)) {
                request.getSession().setAttribute(Const.COMMIT_TRUE, Const.COMMIT_TRUE);
            }
        }

        LOGGER.trace("10tb - started taking out all orders in toBook: ");

        // процедура вынимания списка зказа юзера
        List<OrderImpl> ordersOfUsers = orderDao.getUserOrders(registeredUser);
        ordersOfUsers.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));
        request.getSession().setAttribute("ordersOfUsers", ordersOfUsers);

        LOGGER.trace("11tb - took out all the orders and offered to the session in toBook: ");



        LOGGER.debug("Command finished");
        return Path.REDIRECT_PERSONAL_ACCOUNT;
    }
}
