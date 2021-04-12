package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.jogos;

public class dao_jogos {

	public void geraJogos() throws SQLException {
			Connection con = singleton.getInstance().getConnection();
			String sql = "EXEC gera_tabela_jogos";
			CallableStatement statement = con.prepareCall(sql);
			statement.execute();
	}
	
	public ArrayList<jogos> buscaJogos() throws SQLException {
		Connection con = singleton.getInstance().getConnection();
		String sql = "SELECT * FROM jogos";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		ArrayList<jogos> listaJogos = new ArrayList<>();
		
		while(rs.next()) {
			jogos j = new jogos();
			j.setCodigoTimeA(rs.getString("CodigoTimeA"));
			j.setCodigoTimeB(rs.getString("CodigoTimeB"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));
			j.setGolsTimeB(rs.getInt("GolsTimeB"));
			j.setDataJogo(rs.getDate("DataJogo").toLocalDate());
			listaJogos.add(j);
		}
		
		return listaJogos;
	}
	
	public ArrayList<jogos> buscaData(String data) throws SQLException{
		Connection con = singleton.getInstance().getConnection();
		String sql = "SELECT jogos.CodigoTimeA, jogos.CodigoTimeB, jogos.DataJogo,\r\n"
				+ "FROM jogos WHERE jogos.DataJogo = (?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, data);
		ResultSet rs = statement.executeQuery();
		
		ArrayList<jogos> listaJogos = new ArrayList<>();
		
		while(rs.next()) {
			jogos j = new jogos();
			j.setCodigoTimeA(rs.getString("CodigoTimeA"));
			j.setCodigoTimeB(rs.getString("CodigoTimeB"));
			j.setDataJogo(rs.getDate("DataJogo").toLocalDate());
			listaJogos.add(j);
		}
		
		return listaJogos;
	}
}
