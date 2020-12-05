package com.epam.hw2.hotelproject.controller.command;

import com.epam.hw2.hotelproject.controller.command.commands.*;
import com.epam.hw2.hotelproject.controller.command.commands.authorization.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Holder for all commands.<br/>
 */
@Component
public class CommandContainerImpl implements CommandContainer {
    @Autowired
    private ListFreeRoomsCommand listFreeRoomsCommand;

    @Autowired
    private NoCommand noCommand;
    @Autowired
    private HomePageCommand homePageCommand;
    @Autowired
    private LoginPageCommand loginPageCommand;
    @Autowired
    private LogoutCommand logoutCommand;
    @Autowired
    private RegistrationCommand registrationCommand;
    @Autowired
    private SignInCommand signInCommand;
    @Autowired
    private SignUpCommand signUpCommand;
    @Autowired
    private OwnCabinetCommand ownCabinetCommand;
    @Autowired
    private RoomsAndPriceCommand roomsAndPriceCommand;
    @Autowired
    private ToBookCommand toBookCommand;

    private static final Logger LOGGER = Logger.getLogger(CommandContainerImpl.class);

    private final Map<String, Command> commands = new TreeMap<>();
    private final List<String> authorizedCommands = new ArrayList<>();

    public CommandContainerImpl() {
    }

    @PostConstruct
    @Override
    public void commandContainerInit() {
        // commands
        commands.put("noCommand", noCommand);
        commands.put("homePage", homePageCommand);
        commands.put("login", loginPageCommand);
        commands.put("logout", logoutCommand);
        commands.put("registration", registrationCommand);
        commands.put("signIn", signInCommand);
        commands.put("signUp", signUpCommand);

        commands.put("fetchRooms", listFreeRoomsCommand);
        commands.put("ownCabinet", ownCabinetCommand);
        commands.put("roomsAndPrice", roomsAndPriceCommand);
        commands.put("toBook", toBookCommand);

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
    @Override
    public Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            LOGGER.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

    @Override
    public boolean isAuthorized(String commandName) {
        return authorizedCommands.contains(commandName);
    }
}