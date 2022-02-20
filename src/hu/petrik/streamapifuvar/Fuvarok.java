package hu.petrik.streamapifuvar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fuvarok {
    private List<Fuvar> fuvarok;

    public Fuvarok(String fajlNev) {
        fuvarok = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //fejléc
            String sor = br.readLine();
            while (sor != null) {
                fuvarok.add(new Fuvar(sor));
                sor = br.readLine();
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }


    }

    public long getUtazasokSzama() {
        return fuvarok.stream().count();
    }

    @Override
    public String toString() {
        String s = "";
        for (Fuvar fuvar: this.fuvarok) {
            s += fuvar + "\n";
        }
        return s;
    }
}
