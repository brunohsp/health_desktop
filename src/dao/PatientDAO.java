package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Patient;

public class PatientDAO {
	
	private Connection conn;
	
	public PatientDAO(Connection conn) {
		this.conn = conn; 
	}
	
	public void cadastrarPaciente (Patient paciente) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("call inserirPaciente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			// st.setInt(1, paciente.getIdPaciente());
			st.setString(2, paciente.getName());
			//st.setDate(3, paciente.getDateOfBirth());
			st.setString(4, paciente.getGender());
			// st.setInt(5, paciente.getCpf());
			st.setString(6, paciente.getPhoneNumber());
			st.setString(7, paciente.getPhoto());
			// st.setInt(8, paciente.getCep());
			// st.setString(9, paciente.getRua());
			// st.setString(10, paciente.getBairro());
			// st.setString(11, paciente.getCidade());
			// st.setString(12, paciente.getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	
	public void atualizarPaciente(Patient paciente) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		//busca pelo id do paciente
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("call alterarPaciente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			//st.setInt(1, paciente.getId());
			st.setString(2, paciente.getName());
			//st.setDate(3, paciente.getDateOfBirth());
			st.setString(4, paciente.getGender());
			//st.getInt(5, paciente.getCpf);
			st.setString(6, paciente.getPhoneNumber());
			st.setString(7, paciente.getPhoto());
			//st.setInt(8, paciente.getCep());
			st.setString(9, paciente.getAddress());
			//st.setString(10, paciente.getBairro());
			//st.setString(11, paciente.getCidade());
			//st.setString(12, paciente.getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	
	
	public int excluirPaciente(int cpf) throws SQLException {
		//busca pelo cpf do paciente
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("call excluirPaciente (?) ");
			
			st.setInt(1, cpf);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	
	public List<Patient> buscarTodosPaciente() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement("call buscarPacienteTodos() ");
			
			rs = st.executeQuery();
			
			List<Patient> listaPaciente = new ArrayList<>();
			
			while (rs.next()) {
				Patient paciente = new Patient(); //criar construtor adequado
				
				paciente.setName(rs.getString("Nome Paciente"));
				paciente.setDateOfBirth(rs.getDate("Data nascimento"));
				paciente.setGender(rs.getString("Sexo"));
				//paciente.setCpf(rs.getInt("Cpf"));
				paciente.setPhoneNumber(rs.getNString("Numero de telefone"));
				paciente.setPhoto(rs.getString("Foto"));
			
				listaPaciente.add(paciente);
			}
			
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
	
	
	
	
	
}
