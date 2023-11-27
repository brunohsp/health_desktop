package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class AppointmentForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public AppointmentForm(Menu menu) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeWindow();
			}
			
		});
		
		initComponents();
	}
	
	private void closeWindow() {
		System.out.println("afuiodjoifjasoidfjaoi");
		this.dispose();
	}
	
	private void initComponents() {
		setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		setTitle("Formulário - Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel pacient = new JPanel();
		GridBagLayout gbl_pacient = new GridBagLayout();
		gbl_pacient.columnWidths = new int[]{71, 0};
		gbl_pacient.rowHeights = new int[]{38, 0};
		gbl_pacient.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pacient.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pacient.setLayout(gbl_pacient);
		
		JLabel lblPacient = new JLabel("Nome do paciente selecionado");
		lblPacient.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacient.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPacient = new GridBagConstraints();
		gbc_lblPacient.anchor = GridBagConstraints.WEST;
		gbc_lblPacient.gridx = 0;
		gbc_lblPacient.gridy = 0;
		pacient.add(lblPacient, gbc_lblPacient);
		
		JPanel dateOfBirth = new JPanel();
		GridBagLayout gbl_dateOfBirth = new GridBagLayout();
		gbl_dateOfBirth.columnWidths = new int[]{85, 20, 436, 0};
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
		txtDate.setText("  /  /    ");
		txtDate.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtDate.setColumns(12);
		GridBagConstraints gbc_txtDate = new GridBagConstraints();
		gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDate.gridx = 2;
		gbc_txtDate.gridy = 0;
		dateOfBirth.add(txtDate, gbc_txtDate);
		
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
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
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
					.addGap(10)
					.addComponent(pacient, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(value_1, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(doctor, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pacient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(value_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
