package gui;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SpecialtyForm extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField txtCode;
    private JTextField txtName;

    public SpecialtyForm() {
    	setResizable(false);
    	setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
        setTitle("Formulário - Especialidade");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 220);

        JPanel panel = new JPanel();
        try {
            MaskFormatter codeFormatter = new MaskFormatter("##.##.###-#");

            JButton btnRegister = new JButton("Cadastrar");
            btnRegister.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
            btnRegister.addActionListener(e -> submitForm());

            getContentPane().add(panel);
            
            JPanel code = new JPanel();
            GridBagLayout gbl_code = new GridBagLayout();
            gbl_code.columnWidths = new int[]{71, 20, 321, 0};
            gbl_code.rowHeights = new int[]{38, 0};
            gbl_code.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
            gbl_code.rowWeights = new double[]{0.0, Double.MIN_VALUE};
            code.setLayout(gbl_code);
            
            JLabel lblCode = new JLabel("Código:");
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
            
            txtCode = new JTextField();
            txtCode.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
            txtCode.setColumns(15);
            GridBagConstraints gbc_txtCode = new GridBagConstraints();
            gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
            gbc_txtCode.anchor = GridBagConstraints.NORTH;
            gbc_txtCode.gridx = 2;
            gbc_txtCode.gridy = 0;
            code.add(txtCode, gbc_txtCode);
            
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
            btnCancel.setFont(new Font("Segoe UI Variable", Font.PLAIN, 24));
            GroupLayout gl_panel = new GroupLayout(panel);
            gl_panel.setHorizontalGroup(
            	gl_panel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel.createSequentialGroup()
            			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
            				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
            					.addContainerGap()
            					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
            						.addComponent(code, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
            						.addComponent(name, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)))
            				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
            					.addGap(27)
            					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
            					.addGap(18)
            					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
            			.addContainerGap())
            );
            gl_panel.setVerticalGroup(
            	gl_panel.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panel.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(code, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
            			.addGap(18)
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

    private void submitForm() {
        String code = txtCode.getText();
        String name = txtName.getText();

        // Perform further actions with the submitted data, e.g., save it to a database.

        JOptionPane.showMessageDialog(this, "Specialty Code: " + code + "\nSpecialty Name: " + name + "\nForm submitted successfully.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SpecialtyForm form = new SpecialtyForm();
            form.setVisible(true);
        });
    }
}
