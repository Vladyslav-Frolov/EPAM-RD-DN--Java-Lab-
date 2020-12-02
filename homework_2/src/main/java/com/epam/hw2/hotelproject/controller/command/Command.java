package com.epam.hw2.hotelproject.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Main interface for the Command pattern implementation.
 */
public abstract class Command implements Serializable {	

	/**
	 * Execution method for command.
	 * @return Address to go once the command is executed.
	 */
	public abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException;
	
	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}
}