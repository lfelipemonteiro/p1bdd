package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dao_grupos;

@WebServlet("/geraGrupos")
public class grupos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public grupos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao_grupos gd = new dao_grupos();
		try {
			gd.geraGrupos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
