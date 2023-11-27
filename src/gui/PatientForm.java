package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PatientForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField textField;
	private JTextField txtNeighborhood;
	private JTextField txtCity;
	private JTextField txtUf;

	public PatientForm(Menu menu) {
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
		setTitle("Formulário - Paciente");
		setResizable(false);
		setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 0, 768, 228);
		contentPane.add(header);
		
		JPanel pictureBox = new JPanel();
		pictureBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
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
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.anchor = GridBagConstraints.NORTH;
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 0;
		name.add(txtName, gbc_txtName);
		txtName.setColumns(15);
		
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
		gbc_txtDateOfBirth.anchor = GridBagConstraints.NORTH;
		gbc_txtDateOfBirth.gridx = 2;
		gbc_txtDateOfBirth.gridy = 0;
		dateOfBirth.add(txtDateOfBirth, gbc_txtDateOfBirth);
		
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
		
		JFormattedTextField txtPhone = new JFormattedTextField("(##) #####-####");
		txtPhone.setText("(  )      -    ");
		txtPhone.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtPhone.setColumns(14);
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.anchor = GridBagConstraints.NORTH;
		gbc_txtPhone.gridx = 2;
		gbc_txtPhone.gridy = 0;
		phone.add(txtPhone, gbc_txtPhone);
		
		JPanel CPF = new JPanel();
		GridBagLayout gbl_CPF = new GridBagLayout();
		gbl_CPF.columnWidths = new int[]{98, 20, 300, 0};
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
		
		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_1_1_1 = new GridBagConstraints();
		gbc_horizontalStrut_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_1_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_1_1_1.gridx = 1;
		gbc_horizontalStrut_1_1_1_1.gridy = 0;
		CPF.add(horizontalStrut_1_1_1_1, gbc_horizontalStrut_1_1_1_1);
		
		JFormattedTextField txtPhone_1 = new JFormattedTextField((Object) null);
		txtPhone_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtPhone_1.setColumns(14);
		GridBagConstraints gbc_txtPhone_1 = new GridBagConstraints();
		gbc_txtPhone_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone_1.anchor = GridBagConstraints.NORTH;
		gbc_txtPhone_1.gridx = 2;
		gbc_txtPhone_1.gridy = 0;
		CPF.add(txtPhone_1, gbc_txtPhone_1);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(10)
					.addComponent(pictureBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(CPF, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
						.addComponent(name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(phone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
						.addComponent(dateOfBirth, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(pictureBox, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CPF, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		header.setLayout(gl_header);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(13, 240, 756, 10);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 240, 768, 318);
		contentPane.add(panel);
		
		JPanel address = new JPanel();
		GridBagLayout gbl_address = new GridBagLayout();
		gbl_address.columnWidths = new int[]{110, 20, 426, 0};
		gbl_address.rowHeights = new int[]{38, 0};
		gbl_address.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_address.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		address.setLayout(gbl_address);
		
		JLabel lblAddress = new JLabel("Endereço:");
		lblAddress.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
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
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		txtAddress.setColumns(20);
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.anchor = GridBagConstraints.NORTH;
		gbc_txtAddress.gridx = 2;
		gbc_txtAddress.gridy = 0;
		address.add(txtAddress, gbc_txtAddress);
		
		JPanel gender = new JPanel();
		gender.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gender.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGender = new JLabel("Gênero:");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		gender.add(lblGender, BorderLayout.NORTH);
		
		JPanel paymentMethod = new JPanel();
		GridBagLayout gbl_paymentMethod = new GridBagLayout();
		gbl_paymentMethod.columnWidths = new int[]{110, 20, 426, 0};
		gbl_paymentMethod.rowHeights = new int[]{38, 0};
		gbl_paymentMethod.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_paymentMethod.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		paymentMethod.setLayout(gbl_paymentMethod);
		
		JLabel lblPaymentMethod = new JLabel("Método de Pagamento:");
		lblPaymentMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblPaymentMethod = new GridBagConstraints();
		gbc_lblPaymentMethod.anchor = GridBagConstraints.WEST;
		gbc_lblPaymentMethod.insets = new Insets(0, 0, 0, 5);
		gbc_lblPaymentMethod.gridx = 0;
		gbc_lblPaymentMethod.gridy = 0;
		paymentMethod.add(lblPaymentMethod, gbc_lblPaymentMethod);
		
		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_2.gridx = 1;
		gbc_horizontalStrut_1_2.gridy = 0;
		paymentMethod.add(horizontalStrut_1_2, gbc_horizontalStrut_1_2);
		
		JButton btnRegister = new JButton("Cadastrar");
		btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 24));
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		CEP.add(textField, gbc_textField);
		
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
		
		txtNeighborhood = new JTextField();
		txtNeighborhood.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtNeighborhood.setColumns(20);
		GridBagConstraints gbc_txtNeighborhood = new GridBagConstraints();
		gbc_txtNeighborhood.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNeighborhood.anchor = GridBagConstraints.NORTH;
		gbc_txtNeighborhood.gridx = 2;
		gbc_txtNeighborhood.gridy = 0;
		neighborhood.add(txtNeighborhood, gbc_txtNeighborhood);
		
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
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtCity.setColumns(20);
		GridBagConstraints gbc_txtCity = new GridBagConstraints();
		gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCity.anchor = GridBagConstraints.NORTH;
		gbc_txtCity.gridx = 2;
		gbc_txtCity.gridy = 0;
		city.add(txtCity, gbc_txtCity);
		
		JPanel neighborhood_1 = new JPanel();
		GridBagLayout gbl_neighborhood_1 = new GridBagLayout();
		gbl_neighborhood_1.columnWidths = new int[]{110, 20, 426, 0};
		gbl_neighborhood_1.rowHeights = new int[]{38, 0};
		gbl_neighborhood_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_neighborhood_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		neighborhood_1.setLayout(gbl_neighborhood_1);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.PLAIN, 24));
		GridBagConstraints gbc_lblUf = new GridBagConstraints();
		gbc_lblUf.anchor = GridBagConstraints.WEST;
		gbc_lblUf.insets = new Insets(0, 0, 0, 5);
		gbc_lblUf.gridx = 0;
		gbc_lblUf.gridy = 0;
		neighborhood_1.add(lblUf, gbc_lblUf);
		
		Component horizontalStrut_1_4_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_4_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_4_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_4_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_4_2.gridx = 1;
		gbc_horizontalStrut_1_4_2.gridy = 0;
		neighborhood_1.add(horizontalStrut_1_4_2, gbc_horizontalStrut_1_4_2);
		
		txtUf = new JTextField();
		txtUf.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtUf.setColumns(20);
		GridBagConstraints gbc_txtUf = new GridBagConstraints();
		gbc_txtUf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUf.anchor = GridBagConstraints.NORTH;
		gbc_txtUf.gridx = 2;
		gbc_txtUf.gridy = 0;
		neighborhood_1.add(txtUf, gbc_txtUf);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(188)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(gender, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(neighborhood, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
								.addComponent(city, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
								.addComponent(CEP, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(address, GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
								.addComponent(neighborhood_1, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(paymentMethod, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(CEP, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(city, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(neighborhood, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(neighborhood_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addComponent(gender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(paymentMethod, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JComboBox cbbPaymentMethod = new JComboBox();
		cbbPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"Dinheiro", "Crédito", "Débito", "Boleto", "Pix"}));
		cbbPaymentMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbPaymentMethod = new GridBagConstraints();
		gbc_cbbPaymentMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPaymentMethod.gridx = 2;
		gbc_cbbPaymentMethod.gridy = 0;
		paymentMethod.add(cbbPaymentMethod, gbc_cbbPaymentMethod);
		
		JPanel genderOptions = new JPanel();
		gender.add(genderOptions, BorderLayout.CENTER);
		genderOptions.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton rdbtnMale = new JRadioButton("Masculino");
		genderOptions.add(rdbtnMale);
		rdbtnMale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMale.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JRadioButton rdbtnFemale = new JRadioButton("Feminino");
		genderOptions.add(rdbtnFemale);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFemale.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		
		JRadioButton rdbtnOther = new JRadioButton("Outro");
		genderOptions.add(rdbtnOther);
		rdbtnOther.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnOther.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		panel.setLayout(gl_panel);
	}
	
}
