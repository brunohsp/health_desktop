package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Doctor;
import entities.MedicalTest;

public class MedicalTestDAO {

	private Connection conn;
	
	public  MedicalTestDAO(Connection conn) {
		this.conn = conn; 
	}
	
	public void cadastrarExame (MedicalTest exame) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("insert into Exame values (null, ?, ?, ?, ? ) ");
			
			st.setString(1, exame.getName());
			st.setDouble(2, exame.getValue());
			st.setString(3, exame.getInstructions());
			st.setString(4, exame.getCode());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarExame(MedicalTest exame) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("update Exame set nome_exa = ?, valor_exa = ?, orientacao_exa = ?, codigo_exa = ? where id_exame = ? ");
			
			st.setString(1, exame.getName());
			st.setDouble(2, exame.getValue());
			st.setString(3, exame.getInstructions());
			st.setString(4, exame.getCode());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}

	
	public int excluirMedico(String codigoExame) throws SQLException {
		//busca pelo codigo do exame
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from Consulta where codigo_exa = ? ) ");
			
			st.setString(1, codigoExame);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
public List<MedicalTest> buscarTodosExame() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement("select * from Exame ");
		
			rs = st.executeQuery();
			
			List<MedicalTest> listaExame = new ArrayList<>();
			
			while (rs.next()) {
				MedicalTest exame = new MedicalTest(); //criar construtor adequado
				
				//medico.setName(rs.getString("Nome Paciente"));
				//medico.setDateOfBirth(rs.getDate("Data nascimento"));
				//medico.setGender(rs.getString("Sexo"));
				//medico.setCpf(rs.getInt("Cpf"));
				medico.setPhoneNumber(rs.getString("Numero de telefone"));
				//medico.setPhoto(rs.getString("Foto"));
			
				listaExame.add(exame);
			}
			
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
}
