package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;

import entities.Address;
import entities.Patient;
import entities.Specialty;
import services.PatientService;
import services.SpecialtyService;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpecialtyForm extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private Menu menu;
    private SpecialtyService specialtyService;

    public SpecialtyForm(Menu menu) {
    	this.menu = menu;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				closeWindow();
			}
			
		});
		
		initComponents();
	}
	
	private void closeWindow() {
		menu.refreshTables();
		this.dispose();
	}
	
	private void insertSpecialty() {
		try {
			if( txtName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Há campos vazios no formulário.", "Cadastro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			//System.out.println(txtName.getText());
			specialtyService = new SpecialtyService();
			
			Specialty specialty = new Specialty( txtName.getName());
			
			System.out.println(specialty);
			
			this.specialtyService.insert(specialty);
			
			closeWindow();

		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um nova Especialidade." + e, "Cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}

    private void initComponents() {
    	setResizable(false);
    	setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        setTitle("Formulário - Especialidade");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 220);

        JPanel panel = new JPanel();
        try {
            MaskFormatter codeFormatter = new MaskFormatter("##.##.###-#");

            JButton btnRegister = new JButton("Cadastrar");
            btnRegister.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		insertSpecialty();
            	}
            });
            btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));

            getContentPane().add(panel);
            
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
            
            Component horizontalStrut_1 = Box.createHorizontalStrut(20);
            GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
            gbc_horizontalStrut_1.fill = GridBagConstraints.HORIZONTAL;
            gbc_horizontalStrut_1.insets = new Insets(0, 0, 0, 5);
            gbc_horizontalStrut_1.gridx = 1;
            gbc_horizontalStrut_1.gridy = 0;
            name.add(horizontalStrut_1, gbc_horizontalStrut_1);
            
            txtName = new JTextField();
            txtName.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
            txtName.setColumns(15);
            GridBagConstraints gbc_txtName = new GridBagConstraints();
            gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtName.anchor = GridBagConstraints.NORTH;
            gbc_txtName.gridx = 2;
            gbc_txtName.gridy = 0;
            name.add(txtName, gbc_txtName);
            
            JButton btnCancel = new JButton("Cancelar");
            btnCancel.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		closeWindow();
            	}
            });
            btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
            GroupLayout gl_panel = new GroupLayout(panel);
            gl_panel.setHorizontalGroup(
            	gl_panel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel.createSequentialGroup()
            			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_panel.createSequentialGroup()
            					.addContainerGap()
            					.addComponent(name, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
            				.addGroup(gl_panel.createSequentialGroup()
            					.addGap(27)
            					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
            					.addGap(18)
            					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
            			.addContainerGap())
            );
            gl_panel.setVerticalGroup(
            	gl_panel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel.createSequentialGroup()
            			.addGap(67)
            			.addComponent(name, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
            			.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
            			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
            				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
            				.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
            			.addContainerGap())
            );
            panel.setLayout(gl_panel);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
