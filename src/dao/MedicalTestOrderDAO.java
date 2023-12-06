package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Doctor;
import entities.MedicalTestOrder;

public class MedicalTestOrderDAO {

	private Connection conn;
	
	public MedicalTestOrderDAO(Connection conn) {
		this.conn = conn; 
	}
	
	public void cadastrarPedidoExame (MedicalTestOrder pedidoExame) throws SQLException {
		
		CallableStatement st = null;
		
		try {
			st = conn.prepareCall("call inserirPedidoExame (?, ?, ?) ");
						
			st.setString(1, pedidoExame.getPatient().getCpf());
			st.setInt(2, pedidoExame.getDoctor().getCrmNumber());			
			st.setDouble(3, pedidoExame.getValuePaid());
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	public void atualizarPedidoExame(MedicalTestOrder pedidoExame) throws SQLException {
		
		CallableStatement st = null; 
		
		try {
			
			st = conn.prepareCall("call atualizarPedidoExame (?, ?, ?, ?, ?, ?, ?) ");
			
			st.setInt(1, pedidoExame.getId());
			st.setString(2, pedidoExame.getTestDate());
			st.setString(3, pedidoExame.getTime());
			st.setDouble(4, pedidoExame.getValuePaid());
			st.setInt(5, pedidoExame.getTest().getId());
			st.setInt(6, pedidoExame.getPatient().getId());
			st.setInt(7, pedidoExame.getDoctor().getId());			
			
			st.execute();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public void excluirPedidoExame(int idPedido) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from PedidoExame where id_pedidoExame = ? ");
			
			st.setInt(1, idPedido);
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public List<MedicalTestOrder> buscarTodosPedidoExame() throws SQLException {
		
		CallableStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareCall("call buscarTodosPedidoExame () ");
			
			st.execute();
		
			rs = st.getResultSet();
			
			List<MedicalTestOrder> listaPedidoMedico = new ArrayList<>();
			
			while (rs.next()) {
				MedicalTestOrder pedidoExame = new MedicalTestOrder(); 
				
				pedidoExame.getPatient().setName(rs.getString("Nome Paciente "));
				pedidoExame.getPatient().setCpf(rs.getString("Cpf paciente"));
				pedidoExame.getPatient().setPhoneNumber(rs.getString("Numero de telefone paciente"));
				pedidoExame.getDoctor().setCrmNumber(rs.getInt("CRM medico "));
				pedidoExame.setTestDate(rs.getString("Data Exame"));
				pedidoExame.setTime(rs.getString("Hora Exame"));
							
				listaPedidoMedico.add(pedidoExame);
			}
			
			return listaPedidoMedico;
			 
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.finalizarResultSet(rs);
			DataBase.desconectar();
		}
	}
	
}
