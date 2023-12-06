package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.Address;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;
import entities.Specialty;
import services.DoctorService;
import services.MedicalTestOrderService;
import services.MedicalTestService;
import services.PatientService;
import services.SpecialtyService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicalTestOrderForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField txtValue;
	private JFormattedTextField txtTime;
	private JFormattedTextField txtDate;
	private JComboBox<Doctor> cbbDoctor;
	private JComboBox<MedicalTest> cbbMedicalTest;
	private JComboBox<Patient> cbbPatient;
	private MaskFormatter dateMask;
	private MaskFormatter hourMask;
	private Menu menu;
	private DoctorService doctorService;
	private PatientService patientService;
	private MedicalTestService medicalTestService;
	private MedicalTestOrderService medicalTestOrderService;

	public MedicalTestOrderForm(Menu menu) {
		this.menu = menu;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeWindow();
			}
			
		});
		
		setMasks();
		initComponents();
		getMedicalTests();
		getDoctors();
		getPatients();
	}
	
	private void getMedicalTests() {
		try {
			this.medicalTestService = new MedicalTestService();
	    	List<MedicalTest> medicalTests = this.medicalTestService.listMedicalTests();
	    	
	    	for(MedicalTest medicalTest: medicalTests) {
	    		cbbMedicalTest.addItem(medicalTest);
	    	}
		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void getDoctors() {
		try {
			this.doctorService = new DoctorService();
	    	List<Doctor> doctors = this.doctorService.listDoctors();
	    	
	    	for(Doctor doctor: doctors) {
	    		cbbDoctor.addItem(doctor);
	    	}
		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void getPatients() {
		try {
			this.patientService = new PatientService();
	    	List<Patient> patients = this.patientService.listPatients();
	    	
	    	for(Patient patient: patients) {
	    		cbbPatient.addItem(patient);
	    	}
		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void setMasks() {

		try {
			this.dateMask = new MaskFormatter("##/##/####");
			this.hourMask = new MaskFormatter("##:##");
		} catch (ParseException e) {

			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	private void closeWindow() {
		menu.refreshTables();
		this.dispose();
	}
	
	private void insertMedicalTestOrder() {
		try {
			if( txtDate.getText().equals("") || txtTime.getText().equals("") || txtValue.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Há campos vazios no formulário.", "Cadastro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			MedicalTestOrder mto = new MedicalTestOrder(-1, txtDate.getText(), txtTime.getText(), Double.parseDouble(txtValue.getText()), (MedicalTest) cbbMedicalTest.getSelectedItem(), (Patient) cbbPatient.getSelectedItem(), (Doctor) cbbDoctor.getSelectedItem());
			
			this.medicalTestOrderService.insert(mto);
			
			closeWindow();

		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo Pedido de Exame." + e, "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void initComponents(){
		setTitle("Formulário - Agendamento de Exames");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 389);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 349, Short.MAX_VALUE)
		);
		
		JPanel patient = new JPanel();
		GridBagLayout gbl_patient = new GridBagLayout();
		gbl_patient.columnWidths = new int[]{71, 20, 321, 0};
		gbl_patient.rowHeights = new int[]{38, 0};
		gbl_patient.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_patient.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		patient.setLayout(gbl_patient);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.anchor = GridBagConstraints.WEST;
		gbc_lblPaciente.insets = new Insets(0, 0, 0, 5);
		gbc_lblPaciente.gridx = 0;
		gbc_lblPaciente.gridy = 0;
		patient.add(lblPaciente, gbc_lblPaciente);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 0;
		patient.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		cbbPatient = new JComboBox<Patient>();
		cbbPatient.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbPatient = new GridBagConstraints();
		gbc_cbbPatient.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPatient.gridx = 2;
		gbc_cbbPatient.gridy = 0;
		patient.add(cbbPatient, gbc_cbbPatient);
		
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
		
		cbbMedicalTest = new JComboBox<MedicalTest>();
		cbbMedicalTest.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbMedicalTest = new GridBagConstraints();
		gbc_cbbMedicalTest.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbMedicalTest.gridx = 2;
		gbc_cbbMedicalTest.gridy = 0;
		code.add(cbbMedicalTest, gbc_cbbMedicalTest);
		
		JPanel doctor = new JPanel();
		GridBagLayout gbl_doctor = new GridBagLayout();
		gbl_doctor.columnWidths = new int[]{110, 20, 482, 0};
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
		
		cbbDoctor = new JComboBox<Doctor>();
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
		
		txtDate = new JFormattedTextField(dateMask);
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
		
		JPanel pacient = new JPanel();
		GridBagLayout gbl_pacient = new GridBagLayout();
		gbl_pacient.columnWidths = new int[]{71, 20, 321, 0};
		gbl_pacient.rowHeights = new int[]{38, 0};
		gbl_pacient.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pacient.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pacient.setLayout(gbl_pacient);
		
		JLabel lblHour = new JLabel("Horário:");
		lblHour.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblHour = new GridBagConstraints();
		gbc_lblHour.anchor = GridBagConstraints.WEST;
		gbc_lblHour.insets = new Insets(0, 0, 0, 5);
		gbc_lblHour.gridx = 0;
		gbc_lblHour.gridy = 0;
		pacient.add(lblHour, gbc_lblHour);
		
		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1_1.gridy = 0;
		pacient.add(horizontalStrut_1_1_1_1, gbc_horizontalStrut_1_1_1_1);
		
		txtTime = new JFormattedTextField(hourMask);
		txtTime.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtTime.setColumns(15);
		GridBagConstraints gbc_txtTime = new GridBagConstraints();
		gbc_txtTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTime.anchor = GridBagConstraints.NORTH;
		gbc_txtTime.gridx = 2;
		gbc_txtTime.gridy = 0;
		pacient.add(txtTime, gbc_txtTime);
		
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
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMedicalTestOrder();
			}
		});
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(160)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(patient, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addGap(185))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(code, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addGap(185))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(value, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(pacient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(dateOfBirth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
						.addComponent(doctor, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
					.addGap(185))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(patient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(code, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(doctor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pacient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
	}
}
