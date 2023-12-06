package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import entities.Appointment;
import entities.Doctor;

public class AppointmentDAO {

	private Connection conn; 
	
	public AppointmentDAO (Connection conn) {
		this.conn = conn; 
	}
	
	public void cadastrarConsulta(Appointment consulta) throws SQLException {
		//cpf do paciente e do medico
		
		PreparedStatement st = null; 
		
		try {
			st = conn.prepareStatement("call inserirConsulta(cpfpaciente, crm) ");
			
			st.setInt(1, consulta.getPatient().getId());
			st.setInt(2, consulta.getDoctor().getId());
			
			st.executeUpdate();
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarConsulta(Appointment consulta) throws SQLException {
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("update Consulta set data_con = ?, hora_con = ?, id_paciente_fk = ?, id_medico_fk = ? where id_consulta = ? ");
			
			st.setString(1, consulta.getAppointmentDate());
			st.setString(2, consulta.getTime());
			st.setInt(4, consulta.getPatient().getId());
			st.setInt(5, consulta.getDoctor().getId());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	public int excluirConsulta(int cpf, Date dia)  throws SQLException {
		
		PreparedStatement st = null; 
		
		try {
			
			st = conn.prepareStatement("call alterarConsulta(?, ? )" );
			
			st.setInt(1, cpf);
			st.setDate(2, dia);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public List<Appointment> buscarTodosConsulta() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement("call buscarTodosConsulta() ");
		
			rs = st.executeQuery();
			
			List<Appointment> listaConsulta = new ArrayList<>();
			
			while (rs.next()) {
				Appointment consulta = new Appointment(); 
				
				consulta.getPatient().setName(rs.getString("Nome Paciente "));
				consulta.getPatient().setCpf(rs.getString("Cpf Paciente "));
				consulta.getPatient().setPhoneNumber(rs.getString("Telefone Paciente "));
				consulta.getDoctor().setCrmNumber(rs.getInt("CRM Médico "));
				consulta.setAppointmentDate(rs.getString("Data Consulta "));
				consulta.setTime(rs.getString("Hora Consulta "));
			
				listaConsulta.add(consulta);
			}
			
			 return listaConsulta;
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
	
	
	
	
	
}
