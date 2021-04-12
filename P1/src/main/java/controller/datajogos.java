package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.jogos;
import persistence.dao_jogos;

@WebServlet("/pesquisaJogos")
public class datajogos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public datajogos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("data");
		dao_jogos jd = new dao_jogos();
		ArrayList<jogos> listagem = new ArrayList<>();
		try {
			listagem = jd.buscaData(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("data", data);
		request.setAttribute("listagem", listagem);
		request.getRequestDispatcher("/tabela_dia.jsp").forward(request, response);
	}

}
