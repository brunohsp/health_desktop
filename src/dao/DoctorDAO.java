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
			st = conn.prepareCall("call inserirMedico ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			//st.setInt(1, medico.getId());
			st.setString(1, medico.getName());
			st.setString(2, medico.getDateOfBirth());
			st.setString(3, medico.getGender());
			st.setString(4, medico.getCpf());
			st.setString(5, medico.getPhoneNumber());
			st.setInt(6, medico.getCrmNumber());			
			st.setInt(7, medico.getAddress().getCep());
			st.setString(8, medico.getAddress().getLocation());
			st.setString(9, medico.getAddress().getNeighborhood());
			st.setString(10, medico.getAddress().getCity());
			st.setString(11, medico.getAddress().getUf());
			st.setString(12, medico.getSpecialty().getSpecialtyName());
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarMedico(Doctor medico) throws SQLException {
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
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public void excluirMedico(int cpf) throws SQLException {
		
		CallableStatement st = null;
		
		try {
			
			st = conn.prepareCall("call excluirMedico (?) ");
			
			st.setInt(1, cpf);
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public List<Doctor> buscarTodosMedico() throws SQLException {
		
		CallableStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareCall("call buscarMedicoTodos() ");
			
			st.execute();
		
			rs = st.getResultSet();
			
			List<Doctor> listaMedico = new ArrayList<>();
			
			while (rs.next()) {
				Doctor medico = new Doctor();
				
				medico.setId(rs.getInt("medico.id_medico"));
				medico.setCrmNumber(rs.getInt("medico.crm_med"));
				medico.setName(rs.getString("pessoa.nome_pes"));
				medico.setDateOfBirth(rs.getString("pessoa.dataNascimento_pes"));
				medico.setGender(rs.getString("pessoa.sexo_pes"));
				medico.setCpf(rs.getString("pessoa.cpf_pes"));
				medico.setPhoneNumber(rs.getString("pessoa.telefone_pes"));
			
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
