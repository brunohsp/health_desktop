package dao;

import java.sql.CallableStatement;
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
		CallableStatement st = null; 
		
		try {
			st = conn.prepareCall("call inserirConsulta(cpfpaciente, crm) ");
			
			st.setInt(1, consulta.getPatient().getId());
			st.setInt(2, consulta.getDoctor().getId());
			
			st.execute();
			
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
			st.setInt(3, consulta.getPatient().getId());
			st.setInt(4, consulta.getDoctor().getId());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public void excluirConsulta(int cpf, Date dia)  throws SQLException {
		
		CallableStatement st = null; 
		
		try {
			
			st = conn.prepareCall("call alterarConsulta(?, ? )" );
			
			st.setInt(1, cpf);
			st.setDate(2, dia);
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public List<Appointment> buscarTodosConsulta() throws SQLException {
		
		CallableStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareCall("call buscarTodosConsulta() ");
			
			st.execute();
		
			rs = st.getResultSet();
			
			List<Appointment> listaConsulta = new ArrayList<>();
			
			while (rs.next()) {
				Appointment consulta = new Appointment(); 
				
				consulta.setId(rs.getInt("consulta.id_consulta"));
				consulta.getPatient().setName(rs.getString("pessoa.nome_pes"));
				consulta.getPatient().setCpf(rs.getString("pessoa.cpf_pes"));
				consulta.getPatient().setPhoneNumber(rs.getString("pessoa.telefone_pes"));
				consulta.getDoctor().setCrmNumber(rs.getInt("medico.crm_med"));
				consulta.setAppointmentDate(rs.getString("consulta.data_con"));
				consulta.setTime(rs.getString("consulta.hora_con"));
			
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
