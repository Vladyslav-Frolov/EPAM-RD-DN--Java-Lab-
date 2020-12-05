package com.epam.hw2.hotelproject.controller.command;

public interface CommandContainer {

    void commandContainerInit();

    Command get(String commandName);

    boolean isAuthorized(String commandName);
}
