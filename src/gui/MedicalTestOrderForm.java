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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class MedicalTestOrderForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValue;
	private JTextField textField;

	public MedicalTestOrderForm() {
		initComponents();
	}
	
	private void initComponents(){
		setTitle("Formulário - Agendamento de Exames");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 412);
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
		
		JLabel lblCode = new JLabel("Exame:");
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
		
		JLabel lblPacient = new JLabel("Nome do paciente selecionado");
		lblPacient.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacient.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JPanel doctor = new JPanel();
		GridBagLayout gbl_doctor = new GridBagLayout();
		gbl_doctor.columnWidths = new int[]{110, 20, 426, 0};
		gbl_doctor.rowHeights = new int[]{38, 0};
		gbl_doctor.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_doctor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		doctor.setLayout(gbl_doctor);
		
		JLabel lblSpecialty = new JLabel("Doutor:");
		lblSpecialty.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblSpecialty = new GridBagConstraints();
		gbc_lblSpecialty.anchor = GridBagConstraints.WEST;
		gbc_lblSpecialty.insets = new Insets(0, 0, 0, 5);
		gbc_lblSpecialty.gridx = 0;
		gbc_lblSpecialty.gridy = 0;
		doctor.add(lblSpecialty, gbc_lblSpecialty);
		
		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_2.gridx = 1;
		gbc_horizontalStrut_1_2.gridy = 0;
		doctor.add(horizontalStrut_1_2, gbc_horizontalStrut_1_2);
		
		JComboBox cbbDoctor = new JComboBox();
		cbbDoctor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbDoctor = new GridBagConstraints();
		gbc_cbbDoctor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbDoctor.gridx = 2;
		gbc_cbbDoctor.gridy = 0;
		doctor.add(cbbDoctor, gbc_cbbDoctor);
		
		JPanel dateOfBirth = new JPanel();
		GridBagLayout gbl_dateOfBirth = new GridBagLayout();
		gbl_dateOfBirth.columnWidths = new int[]{71, 20, 258, 0};
		gbl_dateOfBirth.rowHeights = new int[]{38, 0};
		gbl_dateOfBirth.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_dateOfBirth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dateOfBirth.setLayout(gbl_dateOfBirth);
		
		JLabel lblDate = new JLabel("Dia:");
		lblDate.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 0, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		dateOfBirth.add(lblDate, gbc_lblDate);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1.gridx = 1;
		gbc_horizontalStrut_1_1.gridy = 0;
		dateOfBirth.add(horizontalStrut_1_1, gbc_horizontalStrut_1_1);
		
		JFormattedTextField txtDate = new JFormattedTextField();
		txtDate.setHorizontalAlignment(SwingConstants.LEFT);
		txtDate.setText("  /  /    ");
		txtDate.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtDate.setColumns(12);
		GridBagConstraints gbc_txtDate = new GridBagConstraints();
		gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDate.anchor = GridBagConstraints.NORTH;
		gbc_txtDate.gridx = 2;
		gbc_txtDate.gridy = 0;
		dateOfBirth.add(txtDate, gbc_txtDate);
		
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
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1.gridy = 0;
		value.add(horizontalStrut_1_1_1, gbc_horizontalStrut_1_1_1);
		
		txtValue = new JTextField();
		txtValue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtValue.setColumns(15);
		GridBagConstraints gbc_txtValue = new GridBagConstraints();
		gbc_txtValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValue.anchor = GridBagConstraints.NORTH;
		gbc_txtValue.gridx = 2;
		gbc_txtValue.gridy = 0;
		value.add(txtValue, gbc_txtValue);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JPanel value_1 = new JPanel();
		GridBagLayout gbl_value_1 = new GridBagLayout();
		gbl_value_1.columnWidths = new int[]{71, 20, 321, 0};
		gbl_value_1.rowHeights = new int[]{38, 0};
		gbl_value_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_value_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		value_1.setLayout(gbl_value_1);
		
		JLabel lblHour = new JLabel("Horário:");
		lblHour.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblHour = new GridBagConstraints();
		gbc_lblHour.anchor = GridBagConstraints.WEST;
		gbc_lblHour.insets = new Insets(0, 0, 0, 5);
		gbc_lblHour.gridx = 0;
		gbc_lblHour.gridy = 0;
		value_1.add(lblHour, gbc_lblHour);
		
		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1_1.gridy = 0;
		value_1.add(horizontalStrut_1_1_1_1, gbc_horizontalStrut_1_1_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField.setColumns(15);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		value_1.add(textField, gbc_textField);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(value_1, GroupLayout.PREFERRED_SIZE, 444, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPacient, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 444, Short.MAX_VALUE)
						.addComponent(dateOfBirth, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
						.addComponent(code, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(value, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPacient, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(code, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(value_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(value, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		
		JComboBox cbbMedicalTest = new JComboBox();
		cbbMedicalTest.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbMedicalTest = new GridBagConstraints();
		gbc_cbbMedicalTest.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbMedicalTest.gridx = 2;
		gbc_cbbMedicalTest.gridy = 0;
		code.add(cbbMedicalTest, gbc_cbbMedicalTest);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalTestOrderForm frame = new MedicalTestOrderForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
