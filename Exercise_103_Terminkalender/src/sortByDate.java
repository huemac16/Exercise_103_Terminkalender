
import java.util.Comparator;

public class sortByDate implements Comparator<Appointment> {

    @Override
    public int compare(Appointment t, Appointment t1) {
        if (t.getDate().isAfter(t1.getDate())) {
            return 1;
        }

        if (t.getDate().isBefore(t1.getDate())) {
            return -1;
        }

        return 0;
    }

}
