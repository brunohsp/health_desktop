package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

import entities.Appointment;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;
import services.AppointmentService;
import services.DoctorService;
import services.PatientService;

public class AppointmentForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Doctor> cbbDoctor;
	private JComboBox<Patient> cbbPatient;
	private JFormattedTextField txtDate;
	private JFormattedTextField txtTime;
	private MaskFormatter dateMask;
	private MaskFormatter hourMask;
	private Menu menu;
	private DoctorService doctorService;
	private PatientService patientService;
	private AppointmentService appointmentService;

	public AppointmentForm(Menu menu) {
		this.menu = menu;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeWindow();
			}
			
		});
		
		setMasks();
		initComponents();
		getDoctors();
		getPatients();
	}
	
	private void closeWindow() {
		menu.refreshTables();
		this.dispose();
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
	
	private void insertAppointment() {
		try {
			if( txtDate.getText().equals("") || txtTime.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Há campos vazios no formulário.", "Cadastro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Appointment appointment= new Appointment(-1, txtDate.getText(), txtTime.getText(),(Patient) cbbPatient.getSelectedItem(), (Doctor) cbbDoctor.getSelectedItem());
			
			this.appointmentService.insert(appointment);
			
			closeWindow();

		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um nova Consulta." + e, "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	private void initComponents() {
		setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		setTitle("Formulário - Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
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
		
		txtDate = new JFormattedTextField(dateMask);
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
		
		cbbDoctor = new JComboBox<Doctor>();
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
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertAppointment();
			}
		});
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
		
		txtTime = new JFormattedTextField(hourMask);
		txtTime.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtTime.setColumns(15);
		GridBagConstraints gbc_txtTime = new GridBagConstraints();
		gbc_txtTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTime.anchor = GridBagConstraints.NORTH;
		gbc_txtTime.gridx = 2;
		gbc_txtTime.gridy = 0;
		value_1.add(txtTime, gbc_txtTime);
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(value_1, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(doctor, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(patient, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(patient, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(value_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
