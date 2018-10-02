
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractListModel;

public class AppointmentModell extends AbstractListModel {

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void add(Appointment a) {
        appointments.add(a);
        sort();
        updateList();
    }

    public void delete(int idx) {
        appointments.remove(idx);
        sort();
        updateList();

    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o;
        try {
            while ((o = ois.readObject()) != null) {
                appointments.add((Appointment) o);
            }

        } catch (Exception e) {
        }

        ois.close();

    }

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Appointment s : appointments) {
            oos.writeObject(s);

        }

        oos.flush();
        oos.close();
    }

    public void sort() {
        Collections.sort(appointments, new sortByDate());

        updateList();
    }

    public void change(Appointment a, int idx) {
        appointments.set(idx, a);
        sort();
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
