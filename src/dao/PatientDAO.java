package dao;

import java.sql.CallableStatement;
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
		
		
		CallableStatement st = null;
		
		try {
			 
			st = conn.prepareCall("call inserirPaciente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");
			
			// st.setInt(1, paciente.getId());
			st.setString(1, paciente.getName());
			st.setString(2, paciente.getDateOfBirth());
			st.setString(3, paciente.getGender());
			st.setString(4, paciente.getCpf());
			st.setString(5, paciente.getPhoneNumber());
			st.setString(6, paciente.getPhoto());
			st.setString(7, paciente.getPaymentMethod());
			st.setInt(8, paciente.getAddress().getCep());
			st.setString(9, paciente.getAddress().getLocation());
			st.setString(10, paciente.getAddress().getNeighborhood());
			st.setString(11, paciente.getAddress().getCity());
			st.setString(12, paciente.getAddress().getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	
	public void atualizarPaciente(Patient paciente) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		//busca pelo id do paciente
		
		CallableStatement st = null; 
		
		try {
			
			st = conn.prepareCall("call alterarPaciente (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			st.setInt(1, paciente.getId());
			st.setString(2, paciente.getName());
			st.setString(3, paciente.getDateOfBirth());
			st.setString(4, paciente.getGender());
			st.setString(5, paciente.getCpf());
			st.setString(6, paciente.getPhoneNumber());
			st.setString(7, paciente.getPhoto());
			st.setString(8, paciente.getPaymentMethod());
			st.setInt(9, paciente.getAddress().getCep());
			st.setString(10,  paciente.getAddress().getLocation());
			st.setString(11, paciente.getAddress().getNeighborhood());
			st.setString(12, paciente.getAddress().getCity());
			st.setString(13, paciente.getAddress().getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	
	
	public int excluirPaciente(int cpf) throws SQLException {
		//busca pelo cpf do paciente
		
		CallableStatement st = null;
		
		try {
			
			st = conn.prepareCall("call excluirPaciente (?) ");
			
			st.setInt(1, cpf);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	
	public List<Patient> buscarTodosPaciente() throws SQLException {
		
		CallableStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareCall("call buscarPacienteTodos() ");
			
			rs = st.executeQuery();
			
			List<Patient> listaPaciente = new ArrayList<>();
			
			while (rs.next()) {
				Patient paciente = new Patient(); 
				
				paciente.setName(rs.getString("Nome Paciente"));
				paciente.setDateOfBirth(rs.getString("Data nascimento"));
				paciente.setGender(rs.getString("Sexo"));
				paciente.setCpf(rs.getString("Cpf"));
				paciente.setPhoneNumber(rs.getNString("Numero de telefone"));
				paciente.setPhoto(rs.getString("Foto"));
				paciente.setPaymentMethod(rs.getString("Metodo pagamento "));
			
				listaPaciente.add(paciente);
			}
			
			 return listaPaciente;
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
	public Patient buscarCpf(String cpf) throws SQLException {

		CallableStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareCall("call buscarPacienteCpf(?)");

			st.setString(1, cpf);

			rs = st.executeQuery();

			if (rs.next()) {

				Patient patient = new Patient();
				
				patient.setName(rs.getString("Nome Paciente"));
				patient.setDateOfBirth(rs.getString("Data nascimento"));
				patient.setGender(rs.getString("Sexo"));
				patient.setCpf(rs.getString("Cpf"));
				patient.setPhoto(rs.getString("Foto"));
				patient.setPaymentMethod(rs.getString("Metodo pagamento "));
				
				return patient;
			}

			return null;

		} finally {

			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
	
	
	
	
	
}
