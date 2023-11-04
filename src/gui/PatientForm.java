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
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PatientForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientForm frame = new PatientForm();
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
	public PatientForm() {
		setTitle("Formulário - Paciente");
		setResizable(false);
		setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(10, 0, 756, 180);
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
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(10)
					.addComponent(pictureBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(name, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
						.addComponent(phone, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
						.addComponent(dateOfBirth, GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(pictureBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(dateOfBirth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		header.setLayout(gl_header);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 190, 606, 10);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 190, 756, 223);
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(gender, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(address, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
								.addComponent(paymentMethod, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(203))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(paymentMethod, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
