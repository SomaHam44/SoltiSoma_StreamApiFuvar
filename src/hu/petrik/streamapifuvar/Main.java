package hu.petrik.streamapifuvar;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

        System.out.println(fuvarok);

        System.out.printf("1. feladat:  %d utazás került feljegyzésre az állományban!\n", fuvarok.getUtazasokSzama());
        System.out.println("2. feladat: ");
        System.out.printf("3. feladat: %f mérföldet tettek meg a taxisok!\n", fuvarok.getOsszesMerfold());
        System.out.println("4. feladat: Az időben leghosszabb fuvar adatai: " + fuvarok.getLeghosszabbFuvar());


    }
}
