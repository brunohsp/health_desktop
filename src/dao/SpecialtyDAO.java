package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Specialty;


public class SpecialtyDAO {

	private Connection conn; 
	
	public SpecialtyDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrarEspecialidade(Specialty especialidade) throws SQLException{
		PreparedStatement st = null; 
		
		try {
			st = conn.prepareStatement("insert especialidade values (null, ?) " );
			
			st.setString(2, especialidade.getSpecialtyName());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();			
		}
	}
	
	
	public void atualizarEspecialidade (Specialty especialidade) throws SQLException {
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("update Especialidade set nome_esp = ? where id_especialidade = ? ");
			
			st.setInt(1, especialidade.getId());
			st.setString(2, especialidade.getSpecialtyName());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public int excluirPaciente(String especialidade) throws SQLException {
		//busca pelo nome da especialidade
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("call excluirEspecialidade(?) ");
			
			st.setString(1, especialidade);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas;
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	
	public List<Specialty> buscarTodosEspecialidade() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			
			st = conn.prepareStatement("select * from Especialidade "); 
			
			rs = st.executeQuery();
			
			List<Specialty> listEspecialidade = new ArrayList<>();
			
			while(rs.next() ) {
				Specialty especialidade = new Specialty();
				
				//especialidade.setIDSpecialty(rs.getInt("ID Especialidade" ));
				especialidade.setSpecialtyName(rs.getString("Especialidade" ));
				
				listEspecialidade.add(especialidade);
			}
			
			return listEspecialidade; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
		
		
	}
	
	
	
	
	
	
}
