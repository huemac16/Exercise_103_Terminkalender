
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class AppointmentModell extends AbstractListModel {

    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void add(Appointment a) {
        appointments.add(a);

        fireContentsChanged(this, 0, appointments.size());
    }

    public void delete(int idx) {
        
    }

    @Override
    public int getSize() {
        return appointments.size();
    }

    @Override
    public Object getElementAt(int i) {
        return appointments.get(i);
    }

}
