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
import java.awt.event.ActionEvent;

public class AppointmentForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentForm frame = new AppointmentForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppointmentForm() {
		setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		setTitle("Formulário - Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 282);
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
		gbl_dateOfBirth.columnWidths = new int[]{132, 20, 258, 0};
		gbl_dateOfBirth.rowHeights = new int[]{38, 0};
		gbl_dateOfBirth.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_dateOfBirth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dateOfBirth.setLayout(gbl_dateOfBirth);
		
		JLabel lblDateOfBirth_1 = new JLabel("Nascimento:");
		lblDateOfBirth_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblDateOfBirth_1 = new GridBagConstraints();
		gbc_lblDateOfBirth_1.anchor = GridBagConstraints.WEST;
		gbc_lblDateOfBirth_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateOfBirth_1.gridx = 0;
		gbc_lblDateOfBirth_1.gridy = 0;
		dateOfBirth.add(lblDateOfBirth_1, gbc_lblDateOfBirth_1);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1.gridx = 1;
		gbc_horizontalStrut_1_1.gridy = 0;
		dateOfBirth.add(horizontalStrut_1_1, gbc_horizontalStrut_1_1);
		
		JFormattedTextField txtDateOfBirth = new JFormattedTextField();
		txtDateOfBirth.setText("  /  /    ");
		txtDateOfBirth.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtDateOfBirth.setColumns(12);
		GridBagConstraints gbc_txtDateOfBirth = new GridBagConstraints();
		gbc_txtDateOfBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateOfBirth.gridx = 2;
		gbc_txtDateOfBirth.gridy = 0;
		dateOfBirth.add(txtDateOfBirth, gbc_txtDateOfBirth);
		
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
			}
		});
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
								.addComponent(pacient, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
								.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 556, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(118)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
					.addGap(1))
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
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
