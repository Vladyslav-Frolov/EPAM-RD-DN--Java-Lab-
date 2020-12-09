package com.epam.hw4.controller.command;

public interface CommandContainer {

    void commandContainerInit();

    Command get(String commandName);

    boolean isAuthorized(String commandName);
}
