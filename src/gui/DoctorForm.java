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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class DoctorForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public DoctorForm(Menu menu) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeWindow();
			}
		});
		
		initComponents();
	}
	
	private void closeWindow() {
		this.dispose();
	}

	private void initComponents() {
		setTitle("Formulário - Doutor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
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
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 0;
		name.add(horizontalStrut, gbc_horizontalStrut);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtName.setColumns(15);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.anchor = GridBagConstraints.NORTH;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 0;
		name.add(txtName, gbc_txtName);
		
		JPanel phone = new JPanel();
		GridBagLayout gbl_phone = new GridBagLayout();
		gbl_phone.columnWidths = new int[]{98, 20, 300, 0};
		gbl_phone.rowHeights = new int[]{38, 0};
		gbl_phone.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_phone.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		phone.setLayout(gbl_phone);
		
		JLabel lblPhone = new JLabel("Telefone:");
		lblPhone.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 0;
		phone.add(lblPhone, gbc_lblPhone);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1.gridy = 0;
		phone.add(horizontalStrut_1_1_1, gbc_horizontalStrut_1_1_1);
		
		JFormattedTextField txtPhone = new JFormattedTextField((Object) null);
		txtPhone.setText("(  )      -    ");
		txtPhone.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtPhone.setColumns(14);
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.anchor = GridBagConstraints.NORTH;
		gbc_txtPhone.gridx = 2;
		gbc_txtPhone.gridy = 0;
		phone.add(txtPhone, gbc_txtPhone);
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JPanel crm = new JPanel();
		GridBagLayout gbl_crm = new GridBagLayout();
		gbl_crm.columnWidths = new int[]{98, 20, 300, 0};
		gbl_crm.rowHeights = new int[]{38, 0};
		gbl_crm.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_crm.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		crm.setLayout(gbl_crm);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setToolTipText("SP 123456");
		lblCrm.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCrm = new GridBagConstraints();
		gbc_lblCrm.anchor = GridBagConstraints.WEST;
		gbc_lblCrm.insets = new Insets(0, 0, 0, 5);
		gbc_lblCrm.gridx = 0;
		gbc_lblCrm.gridy = 0;
		crm.add(lblCrm, gbc_lblCrm);
		
		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1_1.gridy = 0;
		crm.add(horizontalStrut_1_1_1_1, gbc_horizontalStrut_1_1_1_1);
		
		JFormattedTextField txtCrm = new JFormattedTextField((Object) null);
		txtCrm.setText("  -       ");
		txtCrm.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtCrm.setColumns(14);
		GridBagConstraints gbc_txtCrm = new GridBagConstraints();
		gbc_txtCrm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCrm.anchor = GridBagConstraints.NORTH;
		gbc_txtCrm.gridx = 2;
		gbc_txtCrm.gridy = 0;
		crm.add(txtCrm, gbc_txtCrm);
		
		JPanel CPF = new JPanel();
		GridBagLayout gbl_CPF = new GridBagLayout();
		gbl_CPF.columnWidths = new int[]{98, 20, 643, 0};
		gbl_CPF.rowHeights = new int[]{38, 0};
		gbl_CPF.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_CPF.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		CPF.setLayout(gbl_CPF);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.WEST;
		gbc_lblCpf.insets = new Insets(0, 0, 0, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 0;
		CPF.add(lblCpf, gbc_lblCpf);
		
		Component horizontalStrut_1_1_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1_1_1.gridy = 0;
		CPF.add(horizontalStrut_1_1_1_1_1, gbc_horizontalStrut_1_1_1_1_1);
		
		JFormattedTextField txtPhone_1 = new JFormattedTextField((Object) null);
		txtPhone_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtPhone_1.setColumns(14);
		GridBagConstraints gbc_txtPhone_1 = new GridBagConstraints();
		gbc_txtPhone_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone_1.anchor = GridBagConstraints.NORTH;
		gbc_txtPhone_1.gridx = 2;
		gbc_txtPhone_1.gridy = 0;
		CPF.add(txtPhone_1, gbc_txtPhone_1);
		
		JPanel gender = new JPanel();
		gender.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gender.setLayout(new BorderLayout(0, 0));
		
		JPanel genderOptions = new JPanel();
		gender.add(genderOptions, BorderLayout.CENTER);
		genderOptions.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnMale = new JRadioButton("Masculino");
		rdbtnMale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMale.setFont(new Font("Dialog", Font.PLAIN, 24));
		genderOptions.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Feminino");
		rdbtnFemale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFemale.setFont(new Font("Dialog", Font.PLAIN, 24));
		genderOptions.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Outro");
		rdbtnOther.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOther.setFont(new Font("Dialog", Font.PLAIN, 24));
		genderOptions.add(rdbtnOther);
		
		JLabel lblGender = new JLabel("Gênero:");
		gender.add(lblGender, BorderLayout.NORTH);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Dialog", Font.PLAIN, 24));
		
		JPanel neighborhood = new JPanel();
		GridBagLayout gbl_neighborhood = new GridBagLayout();
		gbl_neighborhood.columnWidths = new int[]{110, 20, 426, 0};
		gbl_neighborhood.rowHeights = new int[]{38, 0};
		gbl_neighborhood.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_neighborhood.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		neighborhood.setLayout(gbl_neighborhood);
		
		JLabel lblNeighborhood = new JLabel("Bairro:");
		lblNeighborhood.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNeighborhood = new GridBagConstraints();
		gbc_lblNeighborhood.anchor = GridBagConstraints.WEST;
		gbc_lblNeighborhood.insets = new Insets(0, 0, 0, 5);
		gbc_lblNeighborhood.gridx = 0;
		gbc_lblNeighborhood.gridy = 0;
		neighborhood.add(lblNeighborhood, gbc_lblNeighborhood);
		
		Component horizontalStrut_1_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_4 = new GridBagConstraints();
		gbc_horizontalStrut_1_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_4.gridx = 1;
		gbc_horizontalStrut_1_4.gridy = 0;
		neighborhood.add(horizontalStrut_1_4, gbc_horizontalStrut_1_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		neighborhood.add(textField, gbc_textField);
		
		JPanel city = new JPanel();
		GridBagLayout gbl_city = new GridBagLayout();
		gbl_city.columnWidths = new int[]{110, 20, 426, 0};
		gbl_city.rowHeights = new int[]{38, 0};
		gbl_city.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_city.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		city.setLayout(gbl_city);
		
		JLabel lblCity = new JLabel("Cidade:");
		lblCity.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.WEST;
		gbc_lblCity.insets = new Insets(0, 0, 0, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 0;
		city.add(lblCity, gbc_lblCity);
		
		Component horizontalStrut_1_4_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_4_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_4_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_4_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_4_1.gridx = 1;
		gbc_horizontalStrut_1_4_1.gridy = 0;
		city.add(horizontalStrut_1_4_1, gbc_horizontalStrut_1_4_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField_1.setColumns(20);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 0;
		city.add(textField_1, gbc_textField_1);
		
		JPanel CEP = new JPanel();
		GridBagLayout gbl_CEP = new GridBagLayout();
		gbl_CEP.columnWidths = new int[]{110, 20, 426, 0};
		gbl_CEP.rowHeights = new int[]{38, 0};
		gbl_CEP.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_CEP.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		CEP.setLayout(gbl_CEP);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.anchor = GridBagConstraints.WEST;
		gbc_lblCep.insets = new Insets(0, 0, 0, 5);
		gbc_lblCep.gridx = 0;
		gbc_lblCep.gridy = 0;
		CEP.add(lblCep, gbc_lblCep);
		
		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_3 = new GridBagConstraints();
		gbc_horizontalStrut_1_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_3.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_3.gridx = 1;
		gbc_horizontalStrut_1_3.gridy = 0;
		CEP.add(horizontalStrut_1_3, gbc_horizontalStrut_1_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField_3.setColumns(20);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 0;
		CEP.add(textField_3, gbc_textField_3);
		
		JPanel address = new JPanel();
		GridBagLayout gbl_address = new GridBagLayout();
		gbl_address.columnWidths = new int[]{110, 20, 426, 0};
		gbl_address.rowHeights = new int[]{38, 0};
		gbl_address.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_address.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		address.setLayout(gbl_address);
		
		JLabel lblAddress = new JLabel("Endereço:");
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 0;
		address.add(lblAddress, gbc_lblAddress);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 0;
		address.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField_4.setColumns(20);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 0;
		address.add(textField_4, gbc_textField_4);
		
		JPanel uf = new JPanel();
		GridBagLayout gbl_uf = new GridBagLayout();
		gbl_uf.columnWidths = new int[]{110, 20, 426, 0};
		gbl_uf.rowHeights = new int[]{38, 0};
		gbl_uf.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_uf.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		uf.setLayout(gbl_uf);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.WEST;
		gbc_lblUf.insets = new Insets(0, 0, 0, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 0;
		uf.add(lblUf, gbc_lblUf);
		
		Component horizontalStrut_1_4_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_4_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_4_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_4_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_4_2.gridx = 1;
		gbc_horizontalStrut_1_4_2.gridy = 0;
		uf.add(horizontalStrut_1_4_2, gbc_horizontalStrut_1_4_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField_2.setColumns(20);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		uf.add(textField_2, gbc_textField_2);
		
		JPanel specialty = new JPanel();
		GridBagLayout gbl_specialty = new GridBagLayout();
		gbl_specialty.columnWidths = new int[]{110, 20, 426, 0};
		gbl_specialty.rowHeights = new int[]{38, 0};
		gbl_specialty.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_specialty.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		specialty.setLayout(gbl_specialty);
		
		JLabel lblSpecialty = new JLabel("Especialidade:");
		lblSpecialty.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblSpecialty = new GridBagConstraints();
		gbc_lblSpecialty.anchor = GridBagConstraints.WEST;
		gbc_lblSpecialty.insets = new Insets(0, 0, 0, 5);
		gbc_lblSpecialty.gridx = 0;
		gbc_lblSpecialty.gridy = 0;
		specialty.add(lblSpecialty, gbc_lblSpecialty);
		
		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_2.gridx = 1;
		gbc_horizontalStrut_1_2.gridy = 0;
		specialty.add(horizontalStrut_1_2, gbc_horizontalStrut_1_2);
		
		JComboBox cbbPaymentMethod = new JComboBox();
		cbbPaymentMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbPaymentMethod = new GridBagConstraints();
		gbc_cbbPaymentMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPaymentMethod.gridx = 2;
		gbc_cbbPaymentMethod.gridy = 0;
		specialty.add(cbbPaymentMethod, gbc_cbbPaymentMethod);
		
		JPanel dateOfBirth = new JPanel();
		GridBagLayout gbl_dateOfBirth = new GridBagLayout();
		gbl_dateOfBirth.columnWidths = new int[]{132, 20, 258, 0};
		gbl_dateOfBirth.rowHeights = new int[]{38, 0};
		gbl_dateOfBirth.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_dateOfBirth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dateOfBirth.setLayout(gbl_dateOfBirth);
		
		JLabel lblDateOfBirth_1 = new JLabel("Nascimento:");
		lblDateOfBirth_1.setFont(new Font("Dialog", Font.PLAIN, 24));
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
		txtDateOfBirth.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtDateOfBirth.setColumns(12);
		GridBagConstraints gbc_txtDateOfBirth = new GridBagConstraints();
		gbc_txtDateOfBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateOfBirth.anchor = GridBagConstraints.NORTH;
		gbc_txtDateOfBirth.gridx = 2;
		gbc_txtDateOfBirth.gridy = 0;
		dateOfBirth.add(txtDateOfBirth, gbc_txtDateOfBirth);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(name, GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
							.addGap(566))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(specialty, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(gender, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(CEP, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
										.addComponent(city, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
										.addComponent(neighborhood, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
										.addComponent(uf, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE))))
							.addGap(566))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(215)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1045, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(CPF, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 760, Short.MAX_VALUE)
						.addComponent(crm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
						.addComponent(dateOfBirth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(phone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
					.addGap(567))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(crm, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CPF, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(CEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(city, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(neighborhood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(uf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(specialty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
