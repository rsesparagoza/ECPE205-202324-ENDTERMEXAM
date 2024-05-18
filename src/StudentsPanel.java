import javax.swing.*;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public StudentsPanel() {
        init();
    }

    private void init(){
        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);
	studenIDLabel = new JLabel("Student ID: ");
	nameLabel = new JLabel("Name: ");
	studentIDField = new JTextField(15);
	nameField = new JTextField(15);
	addBtn = new JButton("Add");

	setLayout(new BorderLayout());

	JPanel userPanel = new JPanel();
	userPanel.setLayout(newGridBagLayout(3,3));
	userPanel.add(StudentIDLabel);
	userPanel.add(nameLabel);
	userPanel.add(StudentIDField);
	userPanel.add(nameField);
	userPanel.add(addBtn);


	add(userPanel, BorderLayout.NORTH);
	add(new JScrollPane(studentsTable), BorderLayout.CENTER);

	addBtn.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e) {
           String id  = studentIDField.getText();
           String name = nameField.getText();

           if(!id.isEmpty() && !name.isEmpty()) {
               studentsTableModel.addStudent(new Student(id, name));
               studentIDField.setText("");
               nameField.setText("");
           } else {
               JOptionPane.showMessageDialog(null, "No field should be empty.");
           }
       }
    });
    }


}
