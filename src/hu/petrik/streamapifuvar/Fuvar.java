package hu.petrik.streamapifuvar;

import java.time.LocalDateTime;

public class Fuvar {
    private int taxiId;
    private LocalDateTime indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesModja;

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public LocalDateTime getIndulas() {
        return indulas;
    }

    public void setIndulas(LocalDateTime indulas) {
        this.indulas = indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    public void setFizetesModja(String fizetesModja) {
        this.fizetesModja = fizetesModja;
    }

    public Fuvar(String s) {
        String[] adatok = s.split(";");
        this.taxiId = Integer.parseInt(adatok[0]);
        this.indulas = LocalDateTime.parse(adatok[1]);
        this.idotartam = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble(adatok[3]);
        this.viteldij = Double.parseDouble(adatok[4]);
        this.borravalo = Double.parseDouble(adatok[5]);
        this.fizetesModja = adatok[6];
    }

    @Override
    public String toString() {
        return String.format("%44s %-10d %9d %10f %10f %10f %20s", this.idotartam, this.taxiId,
                this.idotartam, this.tavolsag, this.viteldij, this.borravalo, this.fizetesModja);
    }

}
