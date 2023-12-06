package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import entities.Address;
import entities.Appointment;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;
import entities.PatientReport;
import entities.Specialty;
import services.AppointmentService;
import services.DoctorService;
import services.MedicalTestOrderService;
import services.MedicalTestService;
import services.PatientReportService;
import services.PatientService;
import services.SpecialtyService;

import java.util.List;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
    private CardLayout cardLayout;
    
    private JTable doctorTable;
    private JTextField txtSpecialty;
    private JTextField txtName;
    private JTextField txtCrm;
    private JTable patientsTable;
    private JTextField textField;
    private JTextField textField_1;
    private JTable mtTable;
    private JTextField txtMtName;
    private JTextField txtMtCode;
    private JTextField txtMtValue;
    private JTable mtoTable;
    private JTextField txtMtoPatientName;
    private JTextField txtMtoDoctor;
    private JTextField txtMtoMedicalTest;
    private JTable specialtiesTable;
    private JTextField txtSpecialtiesName;
    private JTextField txtSpecialtiesCode;
    private JTextField txtPhoneNumber;
    private JTextField txtAppointmentDoctor;
    private JTable appointmentTable;
    private JComboBox<Doctor> cbbDoctor;
    private JComboBox<Patient> cbbPatient ;
    private JComboBox<MedicalTest> cbbMedicalTest;
    private AppointmentService appointmentService;
    private DoctorService doctorService;
    private MedicalTestOrderService medicalTestOrderService;
    private MedicalTestService medicalTestService;
    private PatientService patientService;
    private SpecialtyService specialtyService;
    private PatientReportService patientReportService;
    private JTable doctorReportTable;
    private JTable patientReportTable;
    private JTable medicalTestReportTable;
    private JButton btnSaveDoctorReport;
    private JButton btnSavePatientReport;
    private JButton btnSaveMedicalTestReport;

    public Menu() {
    	initComponents();
    	appointmentService = new AppointmentService();
    	doctorService = new DoctorService();
    	medicalTestOrderService = new MedicalTestOrderService();
    	medicalTestService = new MedicalTestService(); 
    	patientService = new PatientService();
    	specialtyService = new SpecialtyService();
    	patientReportService = new PatientReportService();
    	refreshTables();
    }
    
     
    public void refreshTables() {
    	try {
    		searchAppointments();
    		searchDoctors();
    		searchMedicalTestOrders();
    		searchMedicalTests();
    		searchPatients();
    		searchSpecialties();
    	}  catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    private void searchAppointments() throws SQLException, IOException{
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) appointmentTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Id", "Data", "Paciente", "Doutor" });
    	
    	List<Appointment> appointments = this.appointmentService.listAppointments("", "", "");
    	
    	for(Appointment appointment : appointments) {
    		String date = appointment.getAppointmentDate() + appointment.getTime();
    		Patient patient = appointment.getPatient();
    		Doctor doctor = appointment.getDoctor();
    		
    		model.addRow(new Object[] {
    			appointment.getId(),
    			date, // format.format(date)
    			patient.getName(),
    			doctor.getName(),
    		});
    	}
    }
    
    private void searchDoctors() throws SQLException, IOException{
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) doctorTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Id", "Nome", "CRM", "Especialidade", "Endereço", "Telefone"});
    	
    	List<Doctor> doctors = this.doctorService.listDoctors("", null, "");
    	
    	for(Doctor doctor : doctors) {
    		cbbDoctor.addItem(doctor);
    		
    		Specialty specialty = doctor.getSpecialty();
    		Address address = doctor.getAddress();
    		
    		model.addRow(new Object[] {
    			doctor.getId(),
    			doctor.getName(),
    			doctor.getCrmNumber(),
    			specialty.getSpecialtyName(),
    			address.getLocation(),
    			doctor.getPhoneNumber()
    		});
    	}
    }
    
    private void searchMedicalTestOrders() throws SQLException, IOException{
    	    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) mtoTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Id", "Paciente", "Doutor", "Exame", "Data", "Valor Pago" });
    	
    	List<MedicalTestOrder> medicalTestOrders = this.medicalTestOrderService.listMedicalTestOrders("", "", "");
    	
    	for(MedicalTestOrder mto : medicalTestOrders) {
    		String date = mto.getTestDate();
    		Patient patient = mto.getPatient();
    		Doctor doctor = mto.getDoctor();
    		MedicalTest mt = mto.getTest();
    		
    		model.addRow(new Object[] {
    			mto.getId(),
    			patient.getName(),
    			doctor.getName(),
    			mt.getName(),
    			date,
    			mto.getValuePaid()
    		});
    	}
    }
    
    private void searchMedicalTests() throws SQLException, IOException{
    	//"code", "name", "value", "instructions"
    	
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) mtTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Código", "Nome", "Valor", "Instruções" });
    	
    	List<MedicalTest> medicalTests = this.medicalTestService.listMedicalTests("", "", 0);
    	
    	for(MedicalTest mt : medicalTests) {
    		cbbMedicalTest.addItem(mt);
    		model.addRow(new Object[] {
    			mt.getId(),
    			mt.getName(),
    			mt.getValue(),
    			mt.getInstructions()
    		});
    	}
    }
    
    private void searchPatients() throws SQLException, IOException{
   
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Id", "Nome", "CPF", "Gênero", "Telefone", "Data de nascimento", "Método de pagamento" });
    	
    	List<Patient> patients = this.patientService.listPatients("", "", "", "");
    	
    	for(Patient patient : patients) {
    		cbbPatient.addItem(patient);
    		
    		model.addRow(new Object[] {
    			patient.getId(),
    			patient.getName(),
    			patient.getCpf(),
    			patient.getGender(),
    			patient.getPhoneNumber(),
    			patient.getDateOfBirth(),
    			patient.getPaymentMethod()
    		});
    	}
    }
    
    private void searchSpecialties() throws SQLException, IOException{
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    	DefaultTableModel model = (DefaultTableModel) specialtiesTable.getModel();
    	model.fireTableDataChanged();
    	model.setRowCount(0);
    	
    	model.addRow(new Object[] { "Código", "Nome" });
    	
    	List<Specialty> specialties= this.specialtyService.listSpecialties("", "");
    	
    	for(Specialty specialty: specialties) {
    		model.addRow(new Object[] {
    			specialty.getId(),
    			specialty.getSpecialtyName(),
    		});
    	}
    }
    
    private void openDoctorInsert() {
    	DoctorForm df = new DoctorForm(this);
    	df.setVisible(true);
    }
    
    private void openPatientInsert() {
    	PatientForm pf = new PatientForm(this);
    	pf.setVisible(true);
    }
    
    private void openAppointmentInsert() {
    	AppointmentForm af = new AppointmentForm(this);
    	af.setVisible(true);
    }
    
    private void openMedicalTestInsert() {
    	MedicalTestForm mtf = new MedicalTestForm(this);
    	mtf.setVisible(true);
    }
    
    private void openMedicalTestOrderInsert() {
    	MedicalTestOrderForm mtof = new MedicalTestOrderForm(this);
    	mtof.setVisible(true);
    }
    
    private void openSpecialtyInsert() {
    	SpecialtyForm sf = new SpecialtyForm(this);
    	sf.setVisible(true);
    }
    
    private void generatePatientReport() {
    	try {
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	
    		DefaultTableModel model = (DefaultTableModel) patientReportTable.getModel();
    		model.fireTableDataChanged();
    		model.setRowCount(0);
    	
    		model.addRow(new Object[] { "Tipo", "Data", "Informação" });
    	
    		List<PatientReport> reports= this.patientReportService.listPatientReports((Patient) cbbPatient.getSelectedItem());
    	
    		for(PatientReport report: reports) {
    			model.addRow(new Object[] {
    					report.getType(),
    					report.getInfos(),
    					report.getDate(),
    			});
    		}
    		
    		btnSavePatientReport.setEnabled(true);
    		
    	}  catch (SQLException | IOException e) {
    		JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private void generateDoctorReport() {
    	try {
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        	
        	DefaultTableModel model = (DefaultTableModel) doctorReportTable.getModel();
        	model.fireTableDataChanged();
        	model.setRowCount(0);
        	
        	model.addRow(new Object[] { "Paciente", "Especialidade", "Data" });
        	
        	List<Appointment> appointments = this.appointmentService.getDoctorReport((Doctor) cbbDoctor.getSelectedItem());
        	
        	for(Appointment appointment : appointments) {
        		String date = appointment.getAppointmentDate() + appointment.getTime();
        		Patient patient = appointment.getPatient();
        		Doctor doctor = appointment.getDoctor();
        		
        		model.addRow(new Object[] {
        			patient.getName(),
        			doctor.getSpecialty(),
        			date, // format.format(date)
        		});
        	}
        	
        	btnSaveDoctorReport.setEnabled(true);
        	
    	} catch (SQLException | IOException e) {
    		JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
    	} 	
    }
    
    private void generateMedicalTestReport() {
    	try {
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        	
        	DefaultTableModel model = (DefaultTableModel) medicalTestReportTable.getModel();
        	model.fireTableDataChanged();
        	model.setRowCount(0);
        	
        	model.addRow(new Object[] { "Médico", "Paciente", "Data" });
        	
        	List<MedicalTestOrder> medicalTestOrders = this.medicalTestOrderService.listMedicalTestReport((MedicalTest)cbbMedicalTest.getSelectedItem());
        	
        	for(MedicalTestOrder mto : medicalTestOrders) {
        		String date = mto.getTestDate();
        		Patient patient = mto.getPatient();
        		Doctor doctor = mto.getDoctor();
        		
        		model.addRow(new Object[] {
        			doctor.getName(),
        			patient.getName(),
        			date,
        		});
        	}
        	
        	btnSaveMedicalTestReport.setEnabled(true);
        	
    	} catch (SQLException | IOException e) {
    		JOptionPane.showMessageDialog(null, "Erro ao carregar dados", "Busca", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private void savePatientReport() {
    	//TODO: PEGAR INFOS DE patientReportTable e escrever o arquivo
    }
    
    private void saveDoctorReport() {
    	//TODO: PEGAR INFOS DE doctorReportTable e escrever o arquivo
    }
    
    private void saveMedicalTestReport() {
    	//TODO: PEGAR INFOS DE medicalTestReportTable e escrever o arquivo
    }
    
    
    private void initComponents() {
    	setTitle("Menu");
        setSize(1280, 720);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        setJMenuBar(menuBar);

        JMenu doctorsMenu = new JMenu("Médicos");
        doctorsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem doctorsList = new JMenuItem("Lista");
        doctorsMenu.add(doctorsList);
        menuBar.add(doctorsMenu);

        JMenu patientsMenu = new JMenu("Pacientes");
        patientsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem patientsList = new JMenuItem("Lista");
        patientsMenu.add(patientsList);
        menuBar.add(patientsMenu);
        
        JMenuItem patientsInsert = new JMenuItem("Inserir");
        patientsMenu.add(patientsInsert);
        patientsInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openPatientInsert();
        	}
        });
        
        JMenu appointmentsMenu = new JMenu("Consultas");
        appointmentsMenu.setFont(new Font("Dialog", Font.PLAIN, 18));
        doctorsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        
        JMenuItem doctorsInsert = new JMenuItem("Inserir");
        doctorsInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openDoctorInsert();
        	}
        });
        doctorsMenu.add(doctorsInsert);
        menuBar.add(appointmentsMenu);
        JMenuItem appointmentsList = new JMenuItem("Lista");
        appointmentsMenu.add(appointmentsList);
        
        JMenuItem appointmentsInsert = new JMenuItem("Inserir");
        appointmentsMenu.add(appointmentsInsert);
        
        appointmentsInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openAppointmentInsert();
        	}
        });
        
        appointmentsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Appointments");
            }
        });

        JMenu medicalTestsMenu = new JMenu("Exames");
        medicalTestsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem medicalTestsList = new JMenuItem("Lista");
        medicalTestsMenu.add(medicalTestsList);
        menuBar.add(medicalTestsMenu);
        
        JMenuItem medicalTestsInsert = new JMenuItem("Inserir");
        medicalTestsMenu.add(medicalTestsInsert);
        medicalTestsInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openMedicalTestInsert();
        	}
        });
        
        JMenu medicalTestOrdersMenu = new JMenu("Pedidos de Exames");
        medicalTestOrdersMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem medicalTestOrdersList = new JMenuItem("Lista");
        medicalTestOrdersMenu.add(medicalTestOrdersList);
        menuBar.add(medicalTestOrdersMenu);
        
        JMenuItem medicalTestOrdersInsert = new JMenuItem("Inserir");
        medicalTestOrdersMenu.add(medicalTestOrdersInsert);
        medicalTestOrdersInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openMedicalTestOrderInsert();
        	}
        });
        
        JMenu specialtiesMenu = new JMenu("Especialidades");
        specialtiesMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem specialtiesLIst = new JMenuItem("Lista");
        specialtiesMenu.add(specialtiesLIst);
        menuBar.add(specialtiesMenu);
        
        JMenuItem specialtiesInsert = new JMenuItem("Inserir");
        specialtiesMenu.add(specialtiesInsert);
        
        JMenu reportsMenu = new JMenu("Relatórios");
        reportsMenu.setFont(new Font("Dialog", Font.PLAIN, 18));
        menuBar.add(reportsMenu);
        
        JMenuItem reportsDoctor = new JMenuItem("Médico");
        reportsDoctor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPanel, "doctorReport");
        	}
        });
        reportsMenu.add(reportsDoctor);
        
        JMenuItem reportsPacient = new JMenuItem("Paciente");
        reportsPacient.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPanel, "patientReport");
        	}
        });
        reportsMenu.add(reportsPacient);
        
        JMenuItem reportsMedicalTest = new JMenuItem("Exame");
        reportsMedicalTest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPanel, "medicalTestReport");
        	}
        });
        reportsMenu.add(reportsMedicalTest);
        specialtiesInsert.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		openSpecialtyInsert();
        	}
        });
        
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        JPanel doctorsPanel = new JPanel();

        JPanel patientsPanel = new JPanel();
        
        JPanel medicalTestsPanel = new JPanel();
        
        JPanel medicalTestOrdersPanel = new JPanel();
        
        JPanel specialtiesPanel = new JPanel();
        
        JPanel appointmentPanel = new JPanel();

        contentPanel.add(appointmentPanel, "Appointments");
        
        JPanel appointmentDoctor = new JPanel();
        GridBagLayout gbl_appointmentDoctor = new GridBagLayout();
        gbl_appointmentDoctor.columnWidths = new int[]{71, 20, 321, 0};
        gbl_appointmentDoctor.rowHeights = new int[]{38, 0};
        gbl_appointmentDoctor.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_appointmentDoctor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        appointmentDoctor.setLayout(gbl_appointmentDoctor);
        
        JLabel lblMdico = new JLabel("Médico:");
        lblMdico.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMdico = new GridBagConstraints();
        gbc_lblMdico.anchor = GridBagConstraints.WEST;
        gbc_lblMdico.insets = new Insets(0, 0, 0, 5);
        gbc_lblMdico.gridx = 0;
        gbc_lblMdico.gridy = 0;
        appointmentDoctor.add(lblMdico, gbc_lblMdico);
        
        Component horizontalStrut_1_5 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_5 = new GridBagConstraints();
        gbc_horizontalStrut_1_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_5.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_5.gridx = 1;
        gbc_horizontalStrut_1_5.gridy = 0;
        appointmentDoctor.add(horizontalStrut_1_5, gbc_horizontalStrut_1_5);
        
        txtAppointmentDoctor = new JTextField();
        txtAppointmentDoctor.setFont(new Font("Dialog", Font.PLAIN, 24));
        txtAppointmentDoctor.setColumns(15);
        GridBagConstraints gbc_txtAppointmentDoctor = new GridBagConstraints();
        gbc_txtAppointmentDoctor.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAppointmentDoctor.anchor = GridBagConstraints.NORTH;
        gbc_txtAppointmentDoctor.gridx = 2;
        gbc_txtAppointmentDoctor.gridy = 0;
        appointmentDoctor.add(txtAppointmentDoctor, gbc_txtAppointmentDoctor);
        
        appointmentTable = new JTable();
        appointmentTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"id", "date", "pacient", "doctor"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        appointmentTable.getColumnModel().getColumn(0).setResizable(false);
        appointmentTable.getColumnModel().getColumn(1).setResizable(false);
        appointmentTable.getColumnModel().getColumn(2).setResizable(false);
        appointmentTable.getColumnModel().getColumn(3).setResizable(false);
        
        JPanel appointmentPhone = new JPanel();
        GridBagLayout gbl_appointmentPhone = new GridBagLayout();
        gbl_appointmentPhone.columnWidths = new int[]{98, 20, 300, 0};
        gbl_appointmentPhone.rowHeights = new int[]{38, 0};
        gbl_appointmentPhone.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_appointmentPhone.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        appointmentPhone.setLayout(gbl_appointmentPhone);
        
        JLabel lblDia = new JLabel("Dia:");
        lblDia.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblDia = new GridBagConstraints();
        gbc_lblDia.anchor = GridBagConstraints.WEST;
        gbc_lblDia.insets = new Insets(0, 0, 0, 5);
        gbc_lblDia.gridx = 0;
        gbc_lblDia.gridy = 0;
        appointmentPhone.add(lblDia, gbc_lblDia);
        
        Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_1_1 = new GridBagConstraints();
        gbc_horizontalStrut_1_1_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_1_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_1_1.gridx = 1;
        gbc_horizontalStrut_1_1_1.gridy = 0;
        appointmentPhone.add(horizontalStrut_1_1_1, gbc_horizontalStrut_1_1_1);
        
        JFormattedTextField txtAppointmentDate = new JFormattedTextField((Object) null);
        txtAppointmentDate.setFont(new Font("Dialog", Font.PLAIN, 24));
        txtAppointmentDate.setColumns(14);
        GridBagConstraints gbc_txtAppointmentDate = new GridBagConstraints();
        gbc_txtAppointmentDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAppointmentDate.anchor = GridBagConstraints.NORTH;
        gbc_txtAppointmentDate.gridx = 2;
        gbc_txtAppointmentDate.gridy = 0;
        appointmentPhone.add(txtAppointmentDate, gbc_txtAppointmentDate);
        
        JPanel appointmentPacient = new JPanel();
        GridBagLayout gbl_appointmentPacient = new GridBagLayout();
        gbl_appointmentPacient.columnWidths = new int[]{98, 20, 300, 0};
        gbl_appointmentPacient.rowHeights = new int[]{38, 0};
        gbl_appointmentPacient.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_appointmentPacient.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        appointmentPacient.setLayout(gbl_appointmentPacient);
        
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
        gbc_lblPaciente.anchor = GridBagConstraints.WEST;
        gbc_lblPaciente.insets = new Insets(0, 0, 0, 5);
        gbc_lblPaciente.gridx = 0;
        gbc_lblPaciente.gridy = 0;
        appointmentPacient.add(lblPaciente, gbc_lblPaciente);
        
        Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_1_1_1 = new GridBagConstraints();
        gbc_horizontalStrut_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_1_1_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_1_1_1.gridx = 1;
        gbc_horizontalStrut_1_1_1_1.gridy = 0;
        appointmentPacient.add(horizontalStrut_1_1_1_1, gbc_horizontalStrut_1_1_1_1);
        
        JFormattedTextField txtAppointmentPacient = new JFormattedTextField((Object) null);
        txtAppointmentPacient.setFont(new Font("Dialog", Font.PLAIN, 24));
        txtAppointmentPacient.setColumns(14);
        GridBagConstraints gbc_txtAppointmentPacient = new GridBagConstraints();
        gbc_txtAppointmentPacient.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAppointmentPacient.anchor = GridBagConstraints.NORTH;
        gbc_txtAppointmentPacient.gridx = 2;
        gbc_txtAppointmentPacient.gridy = 0;
        appointmentPacient.add(txtAppointmentPacient, gbc_txtAppointmentPacient);
        GroupLayout gl_appointmentPanel = new GroupLayout(appointmentPanel);
        gl_appointmentPanel.setHorizontalGroup(
        	gl_appointmentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_appointmentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_appointmentPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(appointmentTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(appointmentDoctor, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(appointmentPhone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(appointmentPacient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_appointmentPanel.setVerticalGroup(
        	gl_appointmentPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_appointmentPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(appointmentDoctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(appointmentPacient, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addComponent(appointmentPhone, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(appointmentTable, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        			.addContainerGap())
        );
        appointmentPanel.setLayout(gl_appointmentPanel);
        
        contentPanel.add(doctorsPanel, "Doctors");
        
        doctorTable = new JTable();
        doctorTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        doctorTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"id", "fullName", "crmNumber", "specialty", "address", "phoneNumber"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		Object.class, String.class, String.class, String.class, String.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        doctorTable.getColumnModel().getColumn(1).setResizable(false);
        doctorTable.getColumnModel().getColumn(2).setResizable(false);
        doctorTable.getColumnModel().getColumn(3).setResizable(false);
        doctorTable.getColumnModel().getColumn(4).setResizable(false);
        doctorTable.getColumnModel().getColumn(5).setResizable(false);
        
        JPanel doctorSpecialty = new JPanel();
        GridBagLayout gbl_doctorSpecialty = new GridBagLayout();
        gbl_doctorSpecialty.columnWidths = new int[]{71, 20, 321, 0};
        gbl_doctorSpecialty.rowHeights = new int[]{38, 0};
        gbl_doctorSpecialty.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_doctorSpecialty.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        doctorSpecialty.setLayout(gbl_doctorSpecialty);
        
        JLabel lblSpecialty = new JLabel("Especialidade:");
        lblSpecialty.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblSpecialty = new GridBagConstraints();
        gbc_lblSpecialty.anchor = GridBagConstraints.WEST;
        gbc_lblSpecialty.insets = new Insets(0, 0, 0, 5);
        gbc_lblSpecialty.gridx = 0;
        gbc_lblSpecialty.gridy = 0;
        doctorSpecialty.add(lblSpecialty, gbc_lblSpecialty);
        
        Component horizontalStrut = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
        gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut.gridx = 1;
        gbc_horizontalStrut.gridy = 0;
        doctorSpecialty.add(horizontalStrut, gbc_horizontalStrut);
        
        txtSpecialty = new JTextField();
        txtSpecialty.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtSpecialty.setColumns(15);
        GridBagConstraints gbc_txtSpecialty = new GridBagConstraints();
        gbc_txtSpecialty.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSpecialty.anchor = GridBagConstraints.NORTH;
        gbc_txtSpecialty.gridx = 2;
        gbc_txtSpecialty.gridy = 0;
        doctorSpecialty.add(txtSpecialty, gbc_txtSpecialty);
        
        JPanel doctorName = new JPanel();
        GridBagLayout gbl_doctorName = new GridBagLayout();
        gbl_doctorName.columnWidths = new int[]{71, 20, 321, 0};
        gbl_doctorName.rowHeights = new int[]{38, 0};
        gbl_doctorName.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_doctorName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        doctorName.setLayout(gbl_doctorName);
        
        JLabel lblName = new JLabel("Nome:");
        lblName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 0, 0, 5);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 0;
        doctorName.add(lblName, gbc_lblName);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
        gbc_horizontalStrut_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1.gridx = 1;
        gbc_horizontalStrut_1.gridy = 0;
        doctorName.add(horizontalStrut_1, gbc_horizontalStrut_1);
        
        txtName = new JTextField();
        txtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtName.setColumns(15);
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.anchor = GridBagConstraints.NORTH;
        gbc_txtName.gridx = 2;
        gbc_txtName.gridy = 0;
        doctorName.add(txtName, gbc_txtName);
        
        JPanel doctorCrm = new JPanel();
        GridBagLayout gbl_doctorCrm = new GridBagLayout();
        gbl_doctorCrm.columnWidths = new int[]{71, 20, 321, 0};
        gbl_doctorCrm.rowHeights = new int[]{38, 0};
        gbl_doctorCrm.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_doctorCrm.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        doctorCrm.setLayout(gbl_doctorCrm);
        
        JLabel lblCrm = new JLabel("CRM:");
        lblCrm.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblCrm = new GridBagConstraints();
        gbc_lblCrm.anchor = GridBagConstraints.WEST;
        gbc_lblCrm.insets = new Insets(0, 0, 0, 5);
        gbc_lblCrm.gridx = 0;
        gbc_lblCrm.gridy = 0;
        doctorCrm.add(lblCrm, gbc_lblCrm);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
        gbc_horizontalStrut_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_2.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_2.gridx = 1;
        gbc_horizontalStrut_2.gridy = 0;
        doctorCrm.add(horizontalStrut_2, gbc_horizontalStrut_2);
        
        txtCrm = new JTextField();
        txtCrm.setText("CRM/");
        txtCrm.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtCrm.setColumns(15);
        GridBagConstraints gbc_txtCrm = new GridBagConstraints();
        gbc_txtCrm.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCrm.anchor = GridBagConstraints.NORTH;
        gbc_txtCrm.gridx = 2;
        gbc_txtCrm.gridy = 0;
        doctorCrm.add(txtCrm, gbc_txtCrm);
        GroupLayout gl_doctorsPanel = new GroupLayout(doctorsPanel);
        gl_doctorsPanel.setHorizontalGroup(
        	gl_doctorsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_doctorsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_doctorsPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(doctorTable, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(doctorName, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(doctorSpecialty, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(doctorCrm, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_doctorsPanel.setVerticalGroup(
        	gl_doctorsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_doctorsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(doctorName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(doctorSpecialty, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(doctorCrm, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(doctorTable, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        			.addContainerGap())
        );
        doctorsPanel.setLayout(gl_doctorsPanel);
        
        contentPanel.add(patientsPanel, "Patients");
        
        patientsTable = new JTable();
        patientsTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"id", "name", "cpf", "genre", "phone", "dateOfBirth", "paymentMethod"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		true, false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        patientsTable.getColumnModel().getColumn(1).setResizable(false);
        patientsTable.getColumnModel().getColumn(2).setResizable(false);
        patientsTable.getColumnModel().getColumn(2).setPreferredWidth(193);
        patientsTable.getColumnModel().getColumn(3).setResizable(false);
        patientsTable.getColumnModel().getColumn(4).setResizable(false);
        patientsTable.getColumnModel().getColumn(5).setResizable(false);
        patientsTable.getColumnModel().getColumn(5).setPreferredWidth(155);
        patientsTable.getColumnModel().getColumn(6).setResizable(false);
        patientsTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        
        JPanel patientsName = new JPanel();
        GridBagLayout gbl_patientsName = new GridBagLayout();
        gbl_patientsName.columnWidths = new int[]{71, 20, 321, 0};
        gbl_patientsName.rowHeights = new int[]{38, 0};
        gbl_patientsName.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_patientsName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        patientsName.setLayout(gbl_patientsName);
        
        JLabel lblName_1 = new JLabel("Nome:");
        lblName_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblName_1 = new GridBagConstraints();
        gbc_lblName_1.anchor = GridBagConstraints.WEST;
        gbc_lblName_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblName_1.gridx = 0;
        gbc_lblName_1.gridy = 0;
        patientsName.add(lblName_1, gbc_lblName_1);
        
        Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_1 = new GridBagConstraints();
        gbc_horizontalStrut_1_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_1.gridx = 1;
        gbc_horizontalStrut_1_1.gridy = 0;
        patientsName.add(horizontalStrut_1_1, gbc_horizontalStrut_1_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        textField.setColumns(15);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.anchor = GridBagConstraints.NORTH;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 0;
        patientsName.add(textField, gbc_textField);
        
        JPanel patientsGender = new JPanel();
        GridBagLayout gbl_patientsGender = new GridBagLayout();
        gbl_patientsGender.columnWidths = new int[]{71, 20, 321, 0};
        gbl_patientsGender.rowHeights = new int[]{38, 0};
        gbl_patientsGender.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_patientsGender.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        patientsGender.setLayout(gbl_patientsGender);
        
        JLabel lblGender = new JLabel("Gênero:");
        lblGender.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblGender = new GridBagConstraints();
        gbc_lblGender.anchor = GridBagConstraints.WEST;
        gbc_lblGender.insets = new Insets(0, 0, 0, 5);
        gbc_lblGender.gridx = 0;
        gbc_lblGender.gridy = 0;
        patientsGender.add(lblGender, gbc_lblGender);
        
        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
        gbc_horizontalStrut_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_3.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_3.gridx = 1;
        gbc_horizontalStrut_3.gridy = 0;
        patientsGender.add(horizontalStrut_3, gbc_horizontalStrut_3);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        textField_1.setColumns(15);
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.anchor = GridBagConstraints.NORTH;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 0;
        patientsGender.add(textField_1, gbc_textField_1);
        
        JPanel patientsPayMethod = new JPanel();
        GridBagLayout gbl_patientsPayMethod = new GridBagLayout();
        gbl_patientsPayMethod.columnWidths = new int[]{71, 20, 321, 0};
        gbl_patientsPayMethod.rowHeights = new int[]{38, 0};
        gbl_patientsPayMethod.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_patientsPayMethod.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        patientsPayMethod.setLayout(gbl_patientsPayMethod);
        
        JLabel lblPayMethod = new JLabel("Método de pagamento:");
        lblPayMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblPayMethod = new GridBagConstraints();
        gbc_lblPayMethod.anchor = GridBagConstraints.WEST;
        gbc_lblPayMethod.insets = new Insets(0, 0, 0, 5);
        gbc_lblPayMethod.gridx = 0;
        gbc_lblPayMethod.gridy = 0;
        patientsPayMethod.add(lblPayMethod, gbc_lblPayMethod);
        
        Component horizontalStrut_2_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_2_1 = new GridBagConstraints();
        gbc_horizontalStrut_2_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_2_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_2_1.gridx = 1;
        gbc_horizontalStrut_2_1.gridy = 0;
        patientsPayMethod.add(horizontalStrut_2_1, gbc_horizontalStrut_2_1);
        
        JPanel patientsPhone = new JPanel();
        GridBagLayout gbl_patientsPhone = new GridBagLayout();
        gbl_patientsPhone.columnWidths = new int[]{71, 20, 321, 0};
        gbl_patientsPhone.rowHeights = new int[]{38, 0};
        gbl_patientsPhone.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_patientsPhone.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        patientsPhone.setLayout(gbl_patientsPhone);
        
        JLabel lblPhone = new JLabel("Telefone:");
        lblPhone.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblPhone = new GridBagConstraints();
        gbc_lblPhone.anchor = GridBagConstraints.WEST;
        gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
        gbc_lblPhone.gridx = 0;
        gbc_lblPhone.gridy = 0;
        patientsPhone.add(lblPhone, gbc_lblPhone);
        
        Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_3_1 = new GridBagConstraints();
        gbc_horizontalStrut_3_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_3_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_3_1.gridx = 1;
        gbc_horizontalStrut_3_1.gridy = 0;
        patientsPhone.add(horizontalStrut_3_1, gbc_horizontalStrut_3_1);
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtPhoneNumber.setColumns(15);
        GridBagConstraints gbc_txtPhoneNumber = new GridBagConstraints();
        gbc_txtPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPhoneNumber.anchor = GridBagConstraints.NORTH;
        gbc_txtPhoneNumber.gridx = 2;
        gbc_txtPhoneNumber.gridy = 0;
        patientsPhone.add(txtPhoneNumber, gbc_txtPhoneNumber);
        GroupLayout gl_patientsPanel = new GroupLayout(patientsPanel);
        gl_patientsPanel.setHorizontalGroup(
        	gl_patientsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_patientsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_patientsPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(patientsTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(patientsPhone, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(patientsName, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(patientsGender, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(patientsPayMethod, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE))
        			.addContainerGap())
        );
        gl_patientsPanel.setVerticalGroup(
        	gl_patientsPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_patientsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(patientsName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(patientsGender, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(patientsPayMethod, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(patientsPhone, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(patientsTable, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );
        
        JComboBox cbbPaymentMethod = new JComboBox();
        cbbPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Crédito", "Débito", "Boleto", "Pix"}));
        cbbPaymentMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_cbbPaymentMethod = new GridBagConstraints();
        gbc_cbbPaymentMethod.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbbPaymentMethod.gridx = 2;
        gbc_cbbPaymentMethod.gridy = 0;
        patientsPayMethod.add(cbbPaymentMethod, gbc_cbbPaymentMethod);
        patientsPanel.setLayout(gl_patientsPanel);
        contentPanel.add(medicalTestsPanel, "MedicalTests");
        
        mtTable = new JTable();
        mtTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"code", "name", "value", "instructions"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        mtTable.getColumnModel().getColumn(0).setResizable(false);
        mtTable.getColumnModel().getColumn(1).setResizable(false);
        mtTable.getColumnModel().getColumn(2).setResizable(false);
        mtTable.getColumnModel().getColumn(3).setResizable(false);
        mtTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        
        JPanel mtName = new JPanel();
        GridBagLayout gbl_mtName = new GridBagLayout();
        gbl_mtName.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtName.rowHeights = new int[]{38, 0};
        gbl_mtName.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtName.setLayout(gbl_mtName);
        
        JLabel lblMtName = new JLabel("Nome:");
        lblMtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtName = new GridBagConstraints();
        gbc_lblMtName.anchor = GridBagConstraints.WEST;
        gbc_lblMtName.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtName.gridx = 0;
        gbc_lblMtName.gridy = 0;
        mtName.add(lblMtName, gbc_lblMtName);
        
        Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_2 = new GridBagConstraints();
        gbc_horizontalStrut_1_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_2.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_2.gridx = 1;
        gbc_horizontalStrut_1_2.gridy = 0;
        mtName.add(horizontalStrut_1_2, gbc_horizontalStrut_1_2);
        
        txtMtName = new JTextField();
        txtMtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtName.setColumns(15);
        GridBagConstraints gbc_txtMtName = new GridBagConstraints();
        gbc_txtMtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtName.anchor = GridBagConstraints.NORTH;
        gbc_txtMtName.gridx = 2;
        gbc_txtMtName.gridy = 0;
        mtName.add(txtMtName, gbc_txtMtName);
        
        JPanel mtCode = new JPanel();
        GridBagLayout gbl_mtCode = new GridBagLayout();
        gbl_mtCode.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtCode.rowHeights = new int[]{38, 0};
        gbl_mtCode.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtCode.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtCode.setLayout(gbl_mtCode);
        
        JLabel lblMtCode = new JLabel("Código:");
        lblMtCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtCode = new GridBagConstraints();
        gbc_lblMtCode.anchor = GridBagConstraints.WEST;
        gbc_lblMtCode.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtCode.gridx = 0;
        gbc_lblMtCode.gridy = 0;
        mtCode.add(lblMtCode, gbc_lblMtCode);
        
        Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
        gbc_horizontalStrut_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_4.gridx = 1;
        gbc_horizontalStrut_4.gridy = 0;
        mtCode.add(horizontalStrut_4, gbc_horizontalStrut_4);
        
        txtMtCode = new JTextField();
        txtMtCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtCode.setColumns(15);
        GridBagConstraints gbc_txtMtCode = new GridBagConstraints();
        gbc_txtMtCode.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtCode.anchor = GridBagConstraints.NORTH;
        gbc_txtMtCode.gridx = 2;
        gbc_txtMtCode.gridy = 0;
        mtCode.add(txtMtCode, gbc_txtMtCode);
        
        JPanel mtValue = new JPanel();
        GridBagLayout gbl_mtValue = new GridBagLayout();
        gbl_mtValue.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtValue.rowHeights = new int[]{38, 0};
        gbl_mtValue.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtValue.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtValue.setLayout(gbl_mtValue);
        
        JLabel lblMtValue = new JLabel("Valor:");
        lblMtValue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtValue = new GridBagConstraints();
        gbc_lblMtValue.anchor = GridBagConstraints.WEST;
        gbc_lblMtValue.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtValue.gridx = 0;
        gbc_lblMtValue.gridy = 0;
        mtValue.add(lblMtValue, gbc_lblMtValue);
        
        Component horizontalStrut_2_2 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_2_2 = new GridBagConstraints();
        gbc_horizontalStrut_2_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_2_2.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_2_2.gridx = 1;
        gbc_horizontalStrut_2_2.gridy = 0;
        mtValue.add(horizontalStrut_2_2, gbc_horizontalStrut_2_2);
        
        txtMtValue = new JTextField();
        txtMtValue.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtValue.setColumns(15);
        GridBagConstraints gbc_txtMtValue = new GridBagConstraints();
        gbc_txtMtValue.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtValue.anchor = GridBagConstraints.NORTH;
        gbc_txtMtValue.gridx = 2;
        gbc_txtMtValue.gridy = 0;
        mtValue.add(txtMtValue, gbc_txtMtValue);
        GroupLayout gl_medicalTestsPanel = new GroupLayout(medicalTestsPanel);
        gl_medicalTestsPanel.setHorizontalGroup(
        	gl_medicalTestsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_medicalTestsPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(mtName, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtCode, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtValue, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_medicalTestsPanel.setVerticalGroup(
        	gl_medicalTestsPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(mtName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(mtCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(mtValue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(mtTable, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        medicalTestsPanel.setLayout(gl_medicalTestsPanel);
        contentPanel.add(medicalTestOrdersPanel, "MedicalTestOrders");
        
        mtoTable = new JTable();
        mtoTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"id", "pacient", "doctor", "medicalTest", "date", "valuePaid"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		true, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        mtoTable.getColumnModel().getColumn(1).setResizable(false);
        mtoTable.getColumnModel().getColumn(2).setResizable(false);
        mtoTable.getColumnModel().getColumn(3).setResizable(false);
        mtoTable.getColumnModel().getColumn(4).setResizable(false);
        mtoTable.getColumnModel().getColumn(5).setResizable(false);
        mtoTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        
        JPanel mtoPatientName = new JPanel();
        GridBagLayout gbl_mtoPatientName = new GridBagLayout();
        gbl_mtoPatientName.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtoPatientName.rowHeights = new int[]{38, 0};
        gbl_mtoPatientName.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtoPatientName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtoPatientName.setLayout(gbl_mtoPatientName);
        
        JLabel lblMtoPatientName = new JLabel("Nome do Paciente:");
        lblMtoPatientName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtoPatientName = new GridBagConstraints();
        gbc_lblMtoPatientName.anchor = GridBagConstraints.WEST;
        gbc_lblMtoPatientName.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtoPatientName.gridx = 0;
        gbc_lblMtoPatientName.gridy = 0;
        mtoPatientName.add(lblMtoPatientName, gbc_lblMtoPatientName);
        
        Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_3 = new GridBagConstraints();
        gbc_horizontalStrut_1_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_3.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_3.gridx = 1;
        gbc_horizontalStrut_1_3.gridy = 0;
        mtoPatientName.add(horizontalStrut_1_3, gbc_horizontalStrut_1_3);
        
        txtMtoPatientName = new JTextField();
        txtMtoPatientName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtoPatientName.setColumns(15);
        GridBagConstraints gbc_txtMtoPatientName = new GridBagConstraints();
        gbc_txtMtoPatientName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtoPatientName.anchor = GridBagConstraints.NORTH;
        gbc_txtMtoPatientName.gridx = 2;
        gbc_txtMtoPatientName.gridy = 0;
        mtoPatientName.add(txtMtoPatientName, gbc_txtMtoPatientName);
        
        JPanel mtoDoctor = new JPanel();
        GridBagLayout gbl_mtoDoctor = new GridBagLayout();
        gbl_mtoDoctor.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtoDoctor.rowHeights = new int[]{38, 0};
        gbl_mtoDoctor.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtoDoctor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtoDoctor.setLayout(gbl_mtoDoctor);
        
        JLabel lblMtoDoctor = new JLabel("Médico:");
        lblMtoDoctor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtoDoctor = new GridBagConstraints();
        gbc_lblMtoDoctor.anchor = GridBagConstraints.WEST;
        gbc_lblMtoDoctor.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtoDoctor.gridx = 0;
        gbc_lblMtoDoctor.gridy = 0;
        mtoDoctor.add(lblMtoDoctor, gbc_lblMtoDoctor);
        
        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_5 = new GridBagConstraints();
        gbc_horizontalStrut_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_5.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_5.gridx = 1;
        gbc_horizontalStrut_5.gridy = 0;
        mtoDoctor.add(horizontalStrut_5, gbc_horizontalStrut_5);
        
        txtMtoDoctor = new JTextField();
        txtMtoDoctor.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtoDoctor.setColumns(15);
        GridBagConstraints gbc_txtMtoDoctor = new GridBagConstraints();
        gbc_txtMtoDoctor.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtoDoctor.anchor = GridBagConstraints.NORTH;
        gbc_txtMtoDoctor.gridx = 2;
        gbc_txtMtoDoctor.gridy = 0;
        mtoDoctor.add(txtMtoDoctor, gbc_txtMtoDoctor);
        
        JPanel mtoMedicalTest = new JPanel();
        GridBagLayout gbl_mtoMedicalTest = new GridBagLayout();
        gbl_mtoMedicalTest.columnWidths = new int[]{71, 20, 321, 0};
        gbl_mtoMedicalTest.rowHeights = new int[]{38, 0};
        gbl_mtoMedicalTest.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_mtoMedicalTest.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        mtoMedicalTest.setLayout(gbl_mtoMedicalTest);
        
        JLabel lblMtoMedicalTest = new JLabel("Exame:");
        lblMtoMedicalTest.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblMtoMedicalTest = new GridBagConstraints();
        gbc_lblMtoMedicalTest.anchor = GridBagConstraints.WEST;
        gbc_lblMtoMedicalTest.insets = new Insets(0, 0, 0, 5);
        gbc_lblMtoMedicalTest.gridx = 0;
        gbc_lblMtoMedicalTest.gridy = 0;
        mtoMedicalTest.add(lblMtoMedicalTest, gbc_lblMtoMedicalTest);
        
        Component horizontalStrut_2_3 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_2_3 = new GridBagConstraints();
        gbc_horizontalStrut_2_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_2_3.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_2_3.gridx = 1;
        gbc_horizontalStrut_2_3.gridy = 0;
        mtoMedicalTest.add(horizontalStrut_2_3, gbc_horizontalStrut_2_3);
        
        txtMtoMedicalTest = new JTextField();
        txtMtoMedicalTest.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtMtoMedicalTest.setColumns(15);
        GridBagConstraints gbc_txtMtoMedicalTest = new GridBagConstraints();
        gbc_txtMtoMedicalTest.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMtoMedicalTest.anchor = GridBagConstraints.NORTH;
        gbc_txtMtoMedicalTest.gridx = 2;
        gbc_txtMtoMedicalTest.gridy = 0;
        mtoMedicalTest.add(txtMtoMedicalTest, gbc_txtMtoMedicalTest);
        GroupLayout gl_medicalTestOrdersPanel = new GroupLayout(medicalTestOrdersPanel);
        gl_medicalTestOrdersPanel.setHorizontalGroup(
        	gl_medicalTestOrdersPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestOrdersPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_medicalTestOrdersPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(mtoPatientName, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtoDoctor, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtoMedicalTest, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mtoTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_medicalTestOrdersPanel.setVerticalGroup(
        	gl_medicalTestOrdersPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestOrdersPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(mtoPatientName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(mtoDoctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(mtoMedicalTest, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(mtoTable, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        medicalTestOrdersPanel.setLayout(gl_medicalTestOrdersPanel);
        contentPanel.add(specialtiesPanel, "Specialties");        
        
        specialtiesTable = new JTable();
        specialtiesTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"code", "name"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        specialtiesTable.getColumnModel().getColumn(0).setResizable(false);
        specialtiesTable.getColumnModel().getColumn(1).setResizable(false);
        specialtiesTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        
        JPanel specialtiesName = new JPanel();
        GridBagLayout gbl_specialtiesName = new GridBagLayout();
        gbl_specialtiesName.columnWidths = new int[]{71, 20, 321, 0};
        gbl_specialtiesName.rowHeights = new int[]{38, 0};
        gbl_specialtiesName.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_specialtiesName.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        specialtiesName.setLayout(gbl_specialtiesName);
        
        JLabel lblSpecialtiesName = new JLabel("Nome:");
        lblSpecialtiesName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblSpecialtiesName = new GridBagConstraints();
        gbc_lblSpecialtiesName.anchor = GridBagConstraints.WEST;
        gbc_lblSpecialtiesName.insets = new Insets(0, 0, 0, 5);
        gbc_lblSpecialtiesName.gridx = 0;
        gbc_lblSpecialtiesName.gridy = 0;
        specialtiesName.add(lblSpecialtiesName, gbc_lblSpecialtiesName);
        
        Component horizontalStrut_1_4 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_4 = new GridBagConstraints();
        gbc_horizontalStrut_1_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_4.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_4.gridx = 1;
        gbc_horizontalStrut_1_4.gridy = 0;
        specialtiesName.add(horizontalStrut_1_4, gbc_horizontalStrut_1_4);
        
        txtSpecialtiesName = new JTextField();
        txtSpecialtiesName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtSpecialtiesName.setColumns(15);
        GridBagConstraints gbc_txtSpecialtiesName = new GridBagConstraints();
        gbc_txtSpecialtiesName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSpecialtiesName.anchor = GridBagConstraints.NORTH;
        gbc_txtSpecialtiesName.gridx = 2;
        gbc_txtSpecialtiesName.gridy = 0;
        specialtiesName.add(txtSpecialtiesName, gbc_txtSpecialtiesName);
        
        JPanel specialtiesCode = new JPanel();
        GridBagLayout gbl_specialtiesCode = new GridBagLayout();
        gbl_specialtiesCode.columnWidths = new int[]{71, 20, 321, 0};
        gbl_specialtiesCode.rowHeights = new int[]{38, 0};
        gbl_specialtiesCode.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_specialtiesCode.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        specialtiesCode.setLayout(gbl_specialtiesCode);
        
        JLabel lblSpecialtyCode = new JLabel("Código:");
        lblSpecialtyCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        GridBagConstraints gbc_lblSpecialtyCode = new GridBagConstraints();
        gbc_lblSpecialtyCode.anchor = GridBagConstraints.WEST;
        gbc_lblSpecialtyCode.insets = new Insets(0, 0, 0, 5);
        gbc_lblSpecialtyCode.gridx = 0;
        gbc_lblSpecialtyCode.gridy = 0;
        specialtiesCode.add(lblSpecialtyCode, gbc_lblSpecialtyCode);
        
        Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_6 = new GridBagConstraints();
        gbc_horizontalStrut_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_6.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_6.gridx = 1;
        gbc_horizontalStrut_6.gridy = 0;
        specialtiesCode.add(horizontalStrut_6, gbc_horizontalStrut_6);
        
        txtSpecialtiesCode = new JTextField();
        txtSpecialtiesCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        txtSpecialtiesCode.setColumns(15);
        GridBagConstraints gbc_txtSpecialtiesCode = new GridBagConstraints();
        gbc_txtSpecialtiesCode.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtSpecialtiesCode.anchor = GridBagConstraints.NORTH;
        gbc_txtSpecialtiesCode.gridx = 2;
        gbc_txtSpecialtiesCode.gridy = 0;
        specialtiesCode.add(txtSpecialtiesCode, gbc_txtSpecialtiesCode);
        GroupLayout gl_specialtiesPanel = new GroupLayout(specialtiesPanel);
        gl_specialtiesPanel.setHorizontalGroup(
        	gl_specialtiesPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_specialtiesPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_specialtiesPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(specialtiesTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(specialtiesName, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(specialtiesCode, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_specialtiesPanel.setVerticalGroup(
        	gl_specialtiesPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_specialtiesPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(specialtiesName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(specialtiesCode, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(specialtiesTable, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialtiesPanel.setLayout(gl_specialtiesPanel);

        // events
        doctorsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Doctors");
            }
        });

        patientsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Patients");
            }
        });
        
        medicalTestOrdersList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "MedicalTestOrders");
            }
        });
        
        medicalTestsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "MedicalTests");
            }
        });
        
        specialtiesLIst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Specialties");
            }
        });
        
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        JPanel Main = new JPanel();
        contentPanel.add(Main, "Main");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        cardLayout.show(contentPanel, "Main");
        
        JPanel doctorReport = new JPanel();
        contentPanel.add(doctorReport, "doctorReport");
        
        JPanel doctor = new JPanel();
        GridBagLayout gbl_doctor = new GridBagLayout();
        gbl_doctor.columnWidths = new int[]{110, 20, 482, 0};
        gbl_doctor.rowHeights = new int[]{38, 0};
        gbl_doctor.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_doctor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        doctor.setLayout(gbl_doctor);
        
        JLabel lblSpecialty_1 = new JLabel("Doutor:");
        lblSpecialty_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblSpecialty_1 = new GridBagConstraints();
        gbc_lblSpecialty_1.anchor = GridBagConstraints.WEST;
        gbc_lblSpecialty_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblSpecialty_1.gridx = 0;
        gbc_lblSpecialty_1.gridy = 0;
        doctor.add(lblSpecialty_1, gbc_lblSpecialty_1);
        
        Component horizontalStrut_1_2_1 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_2_1 = new GridBagConstraints();
        gbc_horizontalStrut_1_2_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_2_1.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_2_1.gridx = 1;
        gbc_horizontalStrut_1_2_1.gridy = 0;
        doctor.add(horizontalStrut_1_2_1, gbc_horizontalStrut_1_2_1);
        
        cbbDoctor = new JComboBox<Doctor>();
        cbbDoctor.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_cbbDoctor = new GridBagConstraints();
        gbc_cbbDoctor.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbbDoctor.gridx = 2;
        gbc_cbbDoctor.gridy = 0;
        doctor.add(cbbDoctor, gbc_cbbDoctor);
        
        JButton btnGenerateDoctorReport = new JButton("Gerar Relatório");
        btnGenerateDoctorReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		generateDoctorReport();
        	}
        });
        btnGenerateDoctorReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        
        doctorReportTable = new JTable();
        doctorReportTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"patient", "specialty", "date"
        	}
        ));
        
        btnSaveDoctorReport = new JButton("Salvar Relatório");
        btnSaveDoctorReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSaveDoctorReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        btnSaveDoctorReport.setEnabled(false);
        GroupLayout gl_doctorReport = new GroupLayout(doctorReport);
        gl_doctorReport.setHorizontalGroup(
        	gl_doctorReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_doctorReport.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_doctorReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(doctor, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(doctorReportTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_doctorReport.createSequentialGroup()
        					.addComponent(btnGenerateDoctorReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnSaveDoctorReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_doctorReport.setVerticalGroup(
        	gl_doctorReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_doctorReport.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(doctor, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_doctorReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnGenerateDoctorReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnSaveDoctorReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(doctorReportTable, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        			.addContainerGap())
        );
        doctorReport.setLayout(gl_doctorReport);
        
        JPanel patientReport = new JPanel();
        contentPanel.add(patientReport, "patientReport");
        
        JPanel patient = new JPanel();
        GridBagLayout gbl_patient = new GridBagLayout();
        gbl_patient.columnWidths = new int[]{71, 20, 321, 0};
        gbl_patient.rowHeights = new int[]{38, 0};
        gbl_patient.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_patient.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        patient.setLayout(gbl_patient);
        
        JLabel lblPaciente_1 = new JLabel("Paciente:");
        lblPaciente_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblPaciente_1 = new GridBagConstraints();
        gbc_lblPaciente_1.anchor = GridBagConstraints.WEST;
        gbc_lblPaciente_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblPaciente_1.gridx = 0;
        gbc_lblPaciente_1.gridy = 0;
        patient.add(lblPaciente_1, gbc_lblPaciente_1);
        
        Component horizontalStrut_1_6 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_1_6 = new GridBagConstraints();
        gbc_horizontalStrut_1_6.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_1_6.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_1_6.gridx = 1;
        gbc_horizontalStrut_1_6.gridy = 0;
        patient.add(horizontalStrut_1_6, gbc_horizontalStrut_1_6);
        
        cbbPatient = new JComboBox<Patient>();
        cbbPatient.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_cbbPatient = new GridBagConstraints();
        gbc_cbbPatient.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbbPatient.gridx = 2;
        gbc_cbbPatient.gridy = 0;
        patient.add(cbbPatient, gbc_cbbPatient);
        
        JButton btnGeneratePatientReport = new JButton("Gerar Relatório");
        btnGeneratePatientReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		generatePatientReport();
        	}
        });
        btnGeneratePatientReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        
        patientReportTable = new JTable();
        patientReportTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"type", "date", "infos"
        	}
        ));
        
        btnSavePatientReport = new JButton("Salvar Relatório");
        btnSavePatientReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        btnSavePatientReport.setEnabled(false);
        GroupLayout gl_patientReport = new GroupLayout(patientReport);
        gl_patientReport.setHorizontalGroup(
        	gl_patientReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_patientReport.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_patientReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(patient, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(patientReportTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_patientReport.createSequentialGroup()
        					.addComponent(btnGeneratePatientReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnSavePatientReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_patientReport.setVerticalGroup(
        	gl_patientReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_patientReport.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(patient, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_patientReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnGeneratePatientReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnSavePatientReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(patientReportTable, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(41, Short.MAX_VALUE))
        );
        patientReport.setLayout(gl_patientReport);
        
        JPanel medicalTestReport = new JPanel();
        contentPanel.add(medicalTestReport, "medicalTestReport");
        
        JPanel medicalTest = new JPanel();
        GridBagLayout gbl_medicalTest = new GridBagLayout();
        gbl_medicalTest.columnWidths = new int[]{71, 20, 321, 0};
        gbl_medicalTest.rowHeights = new int[]{38, 0};
        gbl_medicalTest.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_medicalTest.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        medicalTest.setLayout(gbl_medicalTest);
        
        JLabel lblCode = new JLabel("Exame:");
        lblCode.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_lblCode = new GridBagConstraints();
        gbc_lblCode.anchor = GridBagConstraints.WEST;
        gbc_lblCode.insets = new Insets(0, 0, 0, 5);
        gbc_lblCode.gridx = 0;
        gbc_lblCode.gridy = 0;
        medicalTest.add(lblCode, gbc_lblCode);
        
        Component horizontalStrut_7 = Box.createHorizontalStrut(20);
        GridBagConstraints gbc_horizontalStrut_7 = new GridBagConstraints();
        gbc_horizontalStrut_7.fill = GridBagConstraints.HORIZONTAL;
        gbc_horizontalStrut_7.insets = new Insets(0, 0, 0, 5);
        gbc_horizontalStrut_7.gridx = 1;
        gbc_horizontalStrut_7.gridy = 0;
        medicalTest.add(horizontalStrut_7, gbc_horizontalStrut_7);
        
        cbbMedicalTest = new JComboBox<MedicalTest>();
        cbbMedicalTest.setFont(new Font("Dialog", Font.PLAIN, 24));
        GridBagConstraints gbc_cbbMedicalTest = new GridBagConstraints();
        gbc_cbbMedicalTest.fill = GridBagConstraints.HORIZONTAL;
        gbc_cbbMedicalTest.gridx = 2;
        gbc_cbbMedicalTest.gridy = 0;
        medicalTest.add(cbbMedicalTest, gbc_cbbMedicalTest);
        
        JButton btnGenerateMedicalTestReport = new JButton("Gerar Relatório");
        btnGenerateMedicalTestReport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		generateMedicalTestReport();
        	}
        });
        btnGenerateMedicalTestReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        
        medicalTestReportTable = new JTable();
        medicalTestReportTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"doctor", "patient", "date"
        	}
        ));
        
        btnSaveMedicalTestReport = new JButton("Salvar Relatório");
        btnSaveMedicalTestReport.setEnabled(false);
        btnSaveMedicalTestReport.setFont(new Font("Dialog", Font.PLAIN, 24));
        GroupLayout gl_medicalTestReport = new GroupLayout(medicalTestReport);
        gl_medicalTestReport.setHorizontalGroup(
        	gl_medicalTestReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestReport.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_medicalTestReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(medicalTest, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
        				.addComponent(medicalTestReportTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_medicalTestReport.createSequentialGroup()
        					.addComponent(btnGenerateMedicalTestReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnSaveMedicalTestReport, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_medicalTestReport.setVerticalGroup(
        	gl_medicalTestReport.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_medicalTestReport.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(medicalTest, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_medicalTestReport.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnGenerateMedicalTestReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnSaveMedicalTestReport, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(medicalTestReportTable, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(35, Short.MAX_VALUE))
        );
        medicalTestReport.setLayout(gl_medicalTestReport);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
}