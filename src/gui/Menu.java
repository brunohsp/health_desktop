package gui;

import javax.swing.*;

import entities.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
    private CardLayout cardLayout;
    
    private User user;
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

    public Menu() {
    	user = new User("", "", "", true, true); // TODO: remove when receiving User after the login
        setTitle("Menu");
        setSize(1280, 720);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        setJMenuBar(menuBar);

        JMenu doctorsMenu = new JMenu("Médicos");
        doctorsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem doctorsItem = new JMenuItem("Lista");
        doctorsMenu.add(doctorsItem);
        menuBar.add(doctorsMenu);

        JMenu patientsMenu = new JMenu("Pacientes");
        patientsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem patientsItem = new JMenuItem("Lista");
        patientsMenu.add(patientsItem);
        menuBar.add(patientsMenu);
        
        JMenu medicalTestsMenu = new JMenu("Exames");
        medicalTestsMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem MedicalTestsItem = new JMenuItem("Lista");
        medicalTestsMenu.add(MedicalTestsItem);
        menuBar.add(medicalTestsMenu);
        
        JMenu medicalTestOrdersMenu = new JMenu("Pedidos de Exames");
        medicalTestOrdersMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem MedicalTestOrdersItem = new JMenuItem("Lista");
        medicalTestOrdersMenu.add(MedicalTestOrdersItem);
        menuBar.add(medicalTestOrdersMenu);
        
        JMenu specialtiesMenu = new JMenu("Especialidades");
        specialtiesMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        JMenuItem SpecialtiesItem = new JMenuItem("Lista");
        specialtiesMenu.add(SpecialtiesItem);
        menuBar.add(specialtiesMenu);
        
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);

        if (user.isAdmin() == true) {
        	JMenu usersMenu = new JMenu("Usuários");
        	usersMenu.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
        	JMenuItem UsersItem = new JMenuItem("Lista");
        	usersMenu.add(UsersItem);
        	menuBar.add(usersMenu);
        	
        	JPanel usersPanel = new JPanel();
            JLabel usersLabel = new JLabel("Conteúdo de users");
            usersPanel.add(usersLabel);
            
            contentPanel.add(usersPanel, "Users");
        }

        JPanel doctorsPanel = new JPanel();

        JPanel patientsPanel = new JPanel();
        
        JPanel medicalTestsPanel = new JPanel();
        
        JPanel medicalTestOrdersPanel = new JPanel();
        
        JPanel specialtiesPanel = new JPanel();

        contentPanel.add(doctorsPanel, "Doctors");
        
        doctorTable = new JTable();
        doctorTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
        doctorTable.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Nome", "CRM", "Especialidade", "Endere\u00E7o", "Telefone", "A\u00E7\u00F5es"},
        	},
        	new String[] {
        		"fullName", "crmNumber", "specialty", "address", "phoneNumber", "actions"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class, String.class, String.class, Object.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        
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
        	gl_patientsPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, gl_patientsPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(patientsPhone, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(gl_patientsPanel.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(gl_patientsPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(patientsTable, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(patientsName, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(patientsGender, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE)
        				.addComponent(patientsPayMethod, GroupLayout.PREFERRED_SIZE, 1246, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_patientsPanel.setVerticalGroup(
        	gl_patientsPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_patientsPanel.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			.addComponent(patientsName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(patientsGender, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(patientsPayMethod, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(patientsPhone, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(patientsTable, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
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
        contentPanel.add(medicalTestsPanel, "Patients");
        
        mtTable = new JTable();
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
        contentPanel.add(medicalTestOrdersPanel, "Patients");
        
        mtoTable = new JTable();
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
        contentPanel.add(specialtiesPanel, "Patients");        
        
        specialtiesTable = new JTable();
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
        doctorsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Doctors");
            }
        });

        patientsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Patients");
            }
        });

        getContentPane().add(contentPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }
}