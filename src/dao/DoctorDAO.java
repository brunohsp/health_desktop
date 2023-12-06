package dao;

import java.sql.CallableStatement;
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
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall("call inserirMedico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			st.setInt(1, medico.getId());
			st.setString(2, medico.getName());
			st.setString(3, medico.getDateOfBirth());
			st.setString(4, medico.getGender());
			st.setString(5, medico.getCpf());
			st.setString(6, medico.getPhoneNumber());
			st.setInt(7, medico.getCrmNumber());
			st.setString(8, medico.getSpecialty().getSpecialtyName());
			st.setInt(9, medico.getAddress().getCep());
			st.setString(10, medico.getAddress().getLocation());
			st.setString(11, medico.getAddress().getNeighborhood());
			st.setString(12, medico.getAddress().getCity());
			st.setString(13, medico.getAddress().getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarMedico(Doctor medico) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		//busca pelo id do paciente
		
		CallableStatement st = null; 
		
		try {
			
			st = conn.prepareCall("call alterarMedico (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			st.setInt(1, medico.getId());
			st.setString(2, medico.getName());
			st.setString(3, medico.getDateOfBirth());
			st.setString(4, medico.getGender());
			st.setString(5, medico.getCpf());
			st.setString(6, medico.getPhoneNumber());
			st.setInt(7, medico.getCrmNumber());
			st.setInt(8, medico.getAddress().getCep());
			st.setString(9, medico.getAddress().getLocation());
			st.setString(10, medico.getAddress().getNeighborhood());
			st.setString(11, medico.getAddress().getCity());
			st.setString(12, medico.getAddress().getUf());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	

	public int excluirMedico(int cpf) throws SQLException {
		//busca pelo cpf do medico
		
		CallableStatement st = null;
		
		try {
			
			st = conn.prepareCall("call excluirMedico (?) ");
			
			st.setInt(1, cpf);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
public List<Doctor> buscarTodosMedico() throws SQLException {
		
		CallableStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareCall("call buscarPacienteTodos() ");
		
			rs = st.executeQuery();
			
			List<Doctor> listaMedico = new ArrayList<>();
			
			while (rs.next()) {
				Doctor medico = new Doctor(); //criar construtor adequado
				
				medico.setName(rs.getString("Nome Medico"));
				medico.setDateOfBirth(rs.getString("Data nascimento"));
				medico.setGender(rs.getString("Sexo"));
				medico.setCpf(rs.getString("Cpf"));
				medico.setPhoneNumber(rs.getString("Numero de telefone"));
			
				listaMedico.add(medico);
			}
			
			return listaMedico;
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
}
