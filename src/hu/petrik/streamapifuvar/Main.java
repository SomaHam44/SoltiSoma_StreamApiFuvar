package hu.petrik.streamapifuvar;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

        System.out.println(fuvarok);

        System.out.printf("1. feladat:  %d utazás került feljegyzésre az állományban!", fuvarok.getUtazasokSzama());


    }
}
