package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Doctor;


public class DoctorDAO {

	private Connection conn;
		
	public DoctorDAO(Connection conn) {
		this.conn = conn; 
	}
	
	public void cadastrarMedico (Doctor medico) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("call inserirMedico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			// st.setInt(1, medico.getIdPaciente());
			//st.setString(2, medico.getName());
			//st.setDate(3, medico.getDateOfBirth());
			//st.setString(4, medico.getGender());
			// st.setInt(5, medico.getCpf());
			//st.setString(6, medico.getPhoneNumber());
			//st.setString(7, medico.getCrm());
			//st.setString(8,  getEspecialidade);
			// st.setInt(8, medico.getCep());
			// st.setString(9, medico.getRua());
			// st.setString(10, medico.getBairro());
			// st.setString(11, medico.getCidade());
			// st.setString(12, medico.getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarMedico(Doctor medico) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		//busca pelo id do paciente
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("call alterarMedico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			//st.setInt(1, medico.getId());
			//st.setString(2, medico.getName());
			//st.setDate(3, medico.getDateOfBirth());
			//st.setString(4, medico.getGender());
			//st.getString(5, medico.getCpf);
			//st.setString(6, medico.getPhoneNumber());
			st.setString(7, medico.getCrmNumber());
			//st.setString(8, medico.getPhoto());
			//st.setInt(9, medico.getCep());
			//st.setString(10, medico.getAddress());
			//st.setString(11, medico.getBairro());
			//st.setString(12, medico.getCidade());
			//st.setString(13, medico.getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	

	public int excluirMedico(int cpf) throws SQLException {
		//busca pelo cpf do medico
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("call excluirMedico (?) ");
			
			st.setInt(1, cpf);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
public List<Doctor> buscarTodosMedico() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement("call buscarPacienteTodos() ");
		
			rs = st.executeQuery();
			
			List<Doctor> listaMedico = new ArrayList<>();
			
			while (rs.next()) {
				Doctor medico = new Doctor(); //criar construtor adequado
				
				//medico.setName(rs.getString("Nome Paciente"));
				//medico.setDateOfBirth(rs.getDate("Data nascimento"));
				//medico.setGender(rs.getString("Sexo"));
				//medico.setCpf(rs.getInt("Cpf"));
				medico.setPhoneNumber(rs.getString("Numero de telefone"));
				//medico.setPhoto(rs.getString("Foto"));
			
				listaMedico.add(medico);
			}
			
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
}
