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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MedicalTestOrderForm() {
		setTitle("Formulário - Agendamento de Exames");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 335);
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
		txtDateOfBirth.setHorizontalAlignment(SwingConstants.LEFT);
		txtDateOfBirth.setText("  /  /    ");
		txtDateOfBirth.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtDateOfBirth.setColumns(12);
		GridBagConstraints gbc_txtDateOfBirth = new GridBagConstraints();
		gbc_txtDateOfBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateOfBirth.anchor = GridBagConstraints.NORTH;
		gbc_txtDateOfBirth.gridx = 2;
		gbc_txtDateOfBirth.gridy = 0;
		dateOfBirth.add(txtDateOfBirth, gbc_txtDateOfBirth);
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPacient, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(doctor, 0, 0, Short.MAX_VALUE)
						.addComponent(value, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(code, 0, 0, Short.MAX_VALUE))
					.addGap(1))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(value, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
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

}
