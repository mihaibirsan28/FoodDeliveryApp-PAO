package inout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Audit {

    private static Audit instance;

    Audit() {}

    public static Audit getInstance() {
        if (instance == null) {
            instance = new Audit();
        }
        return instance;
    }

    public void scrieAudit(String actiune) {
        try(BufferedWriter fout = new BufferedWriter(new FileWriter("data/audit.csv", true))) {
            String line = actiune + ", " + Calendar.getInstance().getTime() + '\n';
            fout.write(line);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
