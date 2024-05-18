import javax.swing.*;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JTable courseTable;
    public CourseTableModel courseTableModel;


    public CoursePanel() {
        init();
    }
    private void init(){
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

	courseNameLabel = new JLabel("Course Name: ");
	courseCodeLabel = new JLabel("Course Code: ");
	courseNameField = new JTextField(15);
	courseCodeField = new JTextField(15);
	addBtn = new JButton("ADD");

	setLayout(new BorderLayout());

	JPanel coursePanel = new JPanel();
	coursePanel.setLayout(new GridBagLayout(5,5));
	coursePanel.add(courseNameLabel);
	coursePanel.add(courseCodeLabel);
	coursePanel.add(courseCodeField);
	coursePanel.add(courseNameField);
	coursePanel.add(addBtn);

	add(coursePanel, BorderLayout.NORTH)
	add(new JScrollPane(courseTable, BorderLayout.CENTER);

    }
        addBtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = courseCodeField.getText();
            String name = courseNameField.getText();

            if(!code.isEmpty() && !name.isEmpty()) {
                courseTableModel.addCourse(new Course(courseCode, name));
                courseCodeField.setText("");
                courseNameField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No field should be empty.");
            }
        }
    });
}
