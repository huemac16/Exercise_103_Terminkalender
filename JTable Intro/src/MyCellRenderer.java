
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Student s = (Student) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(s.getHairColor());
        label.setForeground(Color.WHITE);

        switch (i1) {
            case 0:
                label.setText(s.getFirstname());
                break;
            case 1:
                label.setText(s.getLastname());
                break;
            case 2:
                label.setText(s.getBirthday().toString());
                break;
            case 3:
                label.setText("");
                break;
        }

        return label;
    }

}
