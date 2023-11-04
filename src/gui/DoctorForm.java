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
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class DoctorForm extends JFrame {

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
					DoctorForm frame = new DoctorForm();
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
	public DoctorForm() {
		setTitle("Formulário - Doutor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
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
		
		JPanel paymentMethod = new JPanel();
		GridBagLayout gbl_paymentMethod = new GridBagLayout();
		gbl_paymentMethod.columnWidths = new int[]{110, 20, 426, 0};
		gbl_paymentMethod.rowHeights = new int[]{38, 0};
		gbl_paymentMethod.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_paymentMethod.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		paymentMethod.setLayout(gbl_paymentMethod);
		
		JLabel lblSpecialty = new JLabel("Especialidade:");
		lblSpecialty.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_lblSpecialty = new GridBagConstraints();
		gbc_lblSpecialty.anchor = GridBagConstraints.WEST;
		gbc_lblSpecialty.insets = new Insets(0, 0, 0, 5);
		gbc_lblSpecialty.gridx = 0;
		gbc_lblSpecialty.gridy = 0;
		paymentMethod.add(lblSpecialty, gbc_lblSpecialty);
		
		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1_2 = new GridBagConstraints();
		gbc_horizontalStrut_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalStrut_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_1_2.gridx = 1;
		gbc_horizontalStrut_1_2.gridy = 0;
		paymentMethod.add(horizontalStrut_1_2, gbc_horizontalStrut_1_2);
		
		JComboBox cbbPaymentMethod = new JComboBox();
		cbbPaymentMethod.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
		GridBagConstraints gbc_cbbPaymentMethod = new GridBagConstraints();
		gbc_cbbPaymentMethod.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbPaymentMethod.gridx = 2;
		gbc_cbbPaymentMethod.gridy = 0;
		paymentMethod.add(cbbPaymentMethod, gbc_cbbPaymentMethod);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(name, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
								.addComponent(phone, 0, 0, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(address, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(crm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(paymentMethod, 0, 0, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(53)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(crm, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(address, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(paymentMethod, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

}
