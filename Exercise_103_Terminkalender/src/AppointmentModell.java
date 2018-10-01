
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class AppointmentModell extends AbstractListModel {

    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void add(Appointment a) {
        appointments.add(a);

        updateList();
    }

    public void delete(int idx) {
        appointments.remove(idx);

        updateList();

    }

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int i) {
        return appointments.get(i);
    }

    public void updateList() {
        fireContentsChanged(this, 0, appointments.size());
    }

}
