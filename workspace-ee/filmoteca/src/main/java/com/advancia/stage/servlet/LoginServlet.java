package com.advancia.stage.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancia.stage.dao.*;
import com.advancia.stage.model.*;




@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente loginUtente = VideotecaDao.getUtenteByUsernamePassword(username, password);

		if (loginUtente != null) {
			request.setAttribute("listaFilm", VideotecaDao.getAllFilm());
			
			request.getSession().setAttribute("utenteLoggato", loginUtente);
			
			RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "KO");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
