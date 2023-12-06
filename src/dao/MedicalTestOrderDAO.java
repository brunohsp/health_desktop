package dao;

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
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("call inserirPedidoExame (?, ?, ?) ");
						
			st.setString(1, pedidoExame.getPatient().getCpf());
			st.setInt(2, pedidoExame.getDoctor().getCrmNumber());			
			st.setDouble(5, pedidoExame.getValuePaid());
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
		
	}
	
	
	public void atualizarPedidoExame(MedicalTestOrder pedidoExame) throws SQLException {
		// deve preencher todos os dados na tela e enviar todos os dados mesmos os que nao foram alterados 
		
		
		PreparedStatement st = null; 
		
		try {
			
			//atualizarPedidoExame (idPedido int, dataExa date, horaExa time, valor double, 
			//		pagamento double, idExame int, idPaciente int, idMedico int)
			
			st = conn.prepareStatement("call atualizarPedidoExame (?, ?, ?, ?, ?, ?, ?) ");
			
			st.setInt(1, pedidoExame.getId());
			st.setString(2, pedidoExame.getTestDate());
			st.setString(3, pedidoExame.getTime());
			st.setDouble(5, pedidoExame.getValuePaid());
			st.setInt(6, pedidoExame.getTest().getId());
			st.setInt(7, pedidoExame.getPatient().getId());
			st.setInt(8, pedidoExame.getDoctor().getId());			
			
			st.executeUpdate();
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	public int excluirPedidoExame(int idPedido) throws SQLException {
		//busca pelo cpf do medico
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("delete from PedidoExame where id_pedidoExame = ? ");
			
			st.setInt(1, idPedido);
			
			int linhasManipuladas = st.executeUpdate();
			
			return linhasManipuladas; 
			
		} finally {
			DataBase.finalizarStatement(st);
			DataBase.desconectar();
		}
	}
	
	
	
public List<MedicalTestOrder> buscarTodosPedidoExame() throws SQLException {
		
		PreparedStatement st = null; 
		ResultSet rs = null; 
		
		try {
			st = conn.prepareStatement("call buscarTodosPedidoExame () ");
		
			rs = st.executeQuery();
			
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
