
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private ArrayList<Student> students = new ArrayList<>();
    private static String[] colNames = {"Firstname", "Lastname", "Birthday", "Haircolor"};

    public void add(Student s) {
        students.add(s);
        fireTableRowsInserted(students.size() - 1, students.size() - 1);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIdx, int colIdx) {
        Student s = students.get(rowIdx);
//        switch (colIdx) {
//            case 0:
//                return s.getFirstname();
//            case 1:
//                return s.getLastname();
//            case 2:
//                return s.getBirthday().toString();
//            case 3:
//                return s.getHairColor().toString();
//            default:
//                return "???";
//        }

        return s;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

}
