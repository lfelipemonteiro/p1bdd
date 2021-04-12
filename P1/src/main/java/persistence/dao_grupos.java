package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.grupos;

public class dao_grupos {
	public void geraGrupos() throws SQLException {
		Connection con = singleton.getInstance().getConnection();
		String sql = "EXEC distribui_times";
		CallableStatement statement = con.prepareCall(sql);
		statement.execute();
	}

	public ArrayList<grupos> buscaGrupos() throws SQLException {
		Connection con = singleton.getInstance().getConnection();
		String sql = "SELECT * FROM grupos";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		ArrayList<grupos> listaJogos = new ArrayList<>();

		while (rs.next()) {
			grupos g = new grupos();
			g.setCodigoTime(rs.getInt("CodigoTime"));
			g.setGrupo(rs.getString("Grupo"));
			listaJogos.add(g);
		}

		return listaJogos;
	}
}
