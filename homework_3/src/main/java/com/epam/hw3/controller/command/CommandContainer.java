package com.epam.hw3.controller.command;

import com.epam.hw3.controller.command.commands.*;
import com.epam.hw3.controller.command.commands.authorization.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Holder for all commands.<br/>
 */
public class CommandContainer {
    private CommandContainer() {
    }

    private static final Logger LOGGER = Logger.getLogger(CommandContainer.class);

    private static final Map<String, Command> commands = new TreeMap<>();
    private static final List<String> authorizedCommands = new ArrayList<>();

    static {
        // commands
        commands.put("noCommand", new NoCommand());
        commands.put("homePage", new HomePageCommand());
        commands.put("login", new LoginPageCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("signIn", new SignInCommand());
        commands.put("signUp", new SignUpCommand());

        commands.put("fetchRooms", new ListFreeRoomsCommand());
        commands.put("ownCabinet", new OwnCabinetCommand());
        commands.put("roomsAndPrice", new RoomsAndPriceCommand());
        commands.put("toBook", new ToBookCommand());




        // authorized commands
        authorizedCommands.add("ownCabinet");
        authorizedCommands.add("toBook");

        LOGGER.debug("Command container was successfully initialized");
        LOGGER.trace("Number of commands --> " + commands.size()
                + " authorizedCommands --> " + authorizedCommands.size());
    }

    /**
     * Returns command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOGGER.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

    public static boolean isAuthorized(String commandName) {
        return authorizedCommands.contains(commandName);
    }
}