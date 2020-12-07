package com.epam.hw3.hotelproject.controller.command;

public interface CommandContainer {

    void commandContainerInit();

    Command get(String commandName);

    boolean isAuthorized(String commandName);
}
