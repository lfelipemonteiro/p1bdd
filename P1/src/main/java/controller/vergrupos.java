package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.grupos;
import persistence.dao_grupos;

@WebServlet("/listagemGrupos")
public class vergrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public vergrupos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao_grupos gd = new dao_grupos();
		ArrayList<grupos> listagem = new ArrayList<>();
		try {
			listagem = gd.buscaGrupos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		ArrayList<grupos> agrupamentos[] = new ArrayList[4];
		
		for(int i = 0; i<agrupamentos.length; i++) {
			agrupamentos[i] = new ArrayList<grupos>();
		}
		
		for(grupos g : listagem) {
			String grupo = g.getGrupo();
			if(grupo.equalsIgnoreCase("a")) {
				agrupamentos[0].add(g);
			}else if(grupo.equalsIgnoreCase("b")) {
				agrupamentos[1].add(g);
			}else if(grupo.equalsIgnoreCase("c")) {
				agrupamentos[2].add(g);
			}else {
				agrupamentos[3].add(g);
			}
		}
		for(ArrayList<grupos> listagens : agrupamentos) {
			System.out.println("listagem_"+listagens.get(0).getGrupo());
			request.setAttribute("listagem_"+listagens.get(0).getGrupo(), listagens);
		}
		request.getRequestDispatcher("/tabela.jsp").forward(request, response);
	}

}
