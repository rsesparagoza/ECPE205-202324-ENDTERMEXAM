import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentsTableModel extends AbstractTableModel {

    public ArrayList<Student> list;

    public StudentsTableModel() {
        list = new ArrayList<>();
    }

    public void addStudent(Student student) {
        list.add(student);
	fireTableRowsInserted(list.size() -1, list.size() -1);
    }


    public void removeStudent( int index ) {
        list.remove(index);
	fireTableRowsDeleted(index, index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        String[] columns = new String[]{"ID","Name"};
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = list.get(rowIndex);
        if ( columnIndex == 0 ) {
            return student.getId();
        } else {
            return student.getName();
        }
    }
}
