package com.epam.hw2.hotelproject;

/**
 * Path holder (jsp pages, controller commands).
 */
public final class Path {
	private Path() {
	}

	// pages
	public static final String PAGE_HOME = "/index.jsp";
	public static final String PAGE_ROOMS_PRICES = "WEB-INF/jsp/rooms_and_prices.jsp";
	public static final String PAGE_LOGIN = "WEB-INF/jsp/login.jsp";
	public static final String PAGE_PERSONAL_ACCOUNT = "WEB-INF/jsp/personal_account.jsp";
	public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error/error_page.jsp";
	public static final String PAGE_SIGN_UP = "WEB-INF/jsp/sign_up.jsp";

	// commands
	public static final String REDIRECT_PERSONAL_ACCOUNT =
			"redirect/http://localhost:8080/frontControllerServlet?command=ownCabinet";
}