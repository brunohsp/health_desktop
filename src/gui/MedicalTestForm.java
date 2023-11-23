package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class MedicalTestForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtValue;

	public MedicalTestForm() {
		initComponents();
	}
	
	private void initComponents() {
		setTitle("Formulário - Exame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel code = new JPanel();
		GridBagLayout gbl_code = new GridBagLayout();
		gbl_code.columnWidths = new int[]{71, 20, 321, 0};
		gbl_code.rowHeights = new int[]{38, 0};
		gbl_code.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_code.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		code.setLayout(gbl_code);
		
		JLabel lblCode = new JLabel("Código:");
		lblCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.WEST;
		gbc_lblCode.insets = new Insets(0, 0, 0, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 0;
		code.add(lblCode, gbc_lblCode);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		code.add(horizontalStrut, gbc_horizontalStrut);
		
		txtCode = new JTextField();
		txtCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtCode.setColumns(15);
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.anchor = GridBagConstraints.NORTH;
		gbc_txtCode.gridx = 2;
		gbc_txtCode.gridy = 0;
		code.add(txtCode, gbc_txtCode);
		
		JPanel name = new JPanel();
		GridBagLayout gbl_name = new GridBagLayout();
		gbl_name.columnWidths = new int[]{71, 20, 321, 0};
		gbl_name.rowHeights = new int[]{38, 0};
		gbl_name.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_name.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		name.setLayout(gbl_name);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		name.add(lblName, gbc_lblName);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 0;
		name.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtName.setColumns(15);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.anchor = GridBagConstraints.NORTH;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 0;
		name.add(txtName, gbc_txtName);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JPanel value = new JPanel();
		GridBagLayout gbl_value = new GridBagLayout();
		gbl_value.columnWidths = new int[]{71, 20, 321, 0};
		gbl_value.rowHeights = new int[]{38, 0};
		gbl_value.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_value.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		value.setLayout(gbl_value);
		
		JLabel lblValue = new JLabel("Valor:");
		lblValue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblValue = new GridBagConstraints();
		gbc_lblValue.anchor = GridBagConstraints.WEST;
		gbc_lblValue.insets = new Insets(0, 0, 0, 5);
		gbc_lblValue.gridx = 0;
		gbc_lblValue.gridy = 0;
		value.add(lblValue, gbc_lblValue);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1.gridx = 1;
		gbc_horizontalStrut_1_1.gridy = 0;
		value.add(horizontalStrut_1_1, gbc_horizontalStrut_1_1);
		
		txtValue = new JTextField();
		txtValue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtValue.setColumns(15);
		GridBagConstraints gbc_txtValue = new GridBagConstraints();
		gbc_txtValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValue.anchor = GridBagConstraints.NORTH;
		gbc_txtValue.gridx = 2;
		gbc_txtValue.gridy = 0;
		value.add(txtValue, gbc_txtValue);
		
		JPanel instructions = new JPanel();
		GridBagLayout gbl_instructions = new GridBagLayout();
		gbl_instructions.columnWidths = new int[]{71, 20, 321, 0};
		gbl_instructions.rowHeights = new int[]{38, 0};
		gbl_instructions.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_instructions.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		instructions.setLayout(gbl_instructions);
		
		JLabel lblInstructions = new JLabel("Instruções:");
		lblInstructions.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblInstructions.insets = new Insets(0, 0, 0, 5);
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 0;
		instructions.add(lblInstructions, gbc_lblInstructions);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1.gridy = 0;
		instructions.add(horizontalStrut_1_1_1, gbc_horizontalStrut_1_1_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(code, GroupLayout.PREFERRED_SIZE, 416, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(name, GroupLayout.PREFERRED_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(value, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(instructions, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(code, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(value, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(instructions, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 0;
		instructions.add(textArea, gbc_textArea);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalTestForm frame = new MedicalTestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
