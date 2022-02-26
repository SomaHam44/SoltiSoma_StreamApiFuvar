package hu.petrik.streamapifuvar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return this.fuvarok.stream().count();
    }

    public long fuvarokSzamaIdAlapjan(int id) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getTaxiId() == id).count();
    }

    public double getBevetelekSzamaIdAlapjan(int id) {
        return this.fuvarok.stream().
                filter(fuvar -> fuvar.getTaxiId() == id)
                .mapToDouble(F -> F.getBevetel())
                .sum();
    }

    public double getOsszesMerfold() {
        return this.fuvarok.stream()
                .mapToDouble(F -> F.getTavolsag())
                .sum();
    }

    public Fuvar getLeghosszabbFuvar() {
        return this.fuvarok.stream()
                .max(Comparator.comparing(fuvar -> fuvar.getIdotartam()))
                .get();
    }

    public Fuvar getLegbokezubbFuvar() {
        return this.fuvarok.stream()
                .max(Comparator.comparingDouble(fuvar -> fuvar.getBokezuseg()))
                .get();
    }

    public double getKilometerekSzamaIdAlapjan(int id) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getTaxiId() == id)
                .mapToDouble(F -> F.getKilometerekSzama())
                .sum();

    }

    public Stream<Fuvar> getHiba() {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0 && fuvar.getViteldij() > 0.0 && fuvar.getTavolsag() == 0);
    }

    public long getHibasakSzama() {
        return this.getHiba().count();
    }

    public long getHibasakOsszesIdotartama() {
        return this.getHiba().
                mapToInt(F -> F.getIdotartam())
                .sum();
    }
    public double getHibasakTeljesBevetele() {
        return this.getHiba().
                mapToDouble(F -> F.getBevetel())
                .sum();
    }

    public boolean szerepelE(int id) {
        return this.fuvarok.stream()
                .anyMatch(fuvar -> fuvar.getTaxiId() == id);
    }

    public List<Fuvar> getIdobenLegrovidebbUtazasok(int szam) {
        return this.fuvarok.stream()
                .filter(fuvar -> fuvar.getIdotartam() > 0)
                .sorted(Comparator.comparingInt(fuvar -> fuvar.getIdotartam()))
                .limit(szam)
                .collect(Collectors.toList());
    }

    public long getFuvarokSzamaHonapNapStringSzerint(String honap,String nap) {
        return this.fuvarok.stream()
                .filter(fuvar ->  fuvar.getIndulas().contains(honap) &&fuvar.getIndulas().contains(nap))
                .count();
    }

    public double getBorravaloAranyaHonapNapStringSzerint(String honap, String nap) {
        return this.fuvarok.stream()
                .filter(fuvar ->  fuvar.getIndulas().contains(honap) &&fuvar.getIndulas().contains(nap))
                .mapToDouble(F -> F.getBokezuseg())
                .sum();

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
