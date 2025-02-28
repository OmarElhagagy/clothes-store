package com.yourstore;

import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ClothesServlet extends HttpServlet {
	private String dbUrl;
	private String dbUser;
	private String dbPass;

	public void init() {
		try (InputStream input = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties")) {
			Properties props = new Properties();
			props.load(input);
			dbUrl = props.getProperty("db.url");
			dbUser = props.getProperty("db.user");
			dbPass = props.getProperty("db.password");
		} catch(IOException e) {
			throw new RuntimeException("Failed to load DB config", e);
		}
	}
}
