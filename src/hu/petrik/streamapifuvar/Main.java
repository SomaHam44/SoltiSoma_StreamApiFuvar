package hu.petrik.streamapifuvar;

public class Main {

    public static void main(String[] args) {
        Fuvarok fuvarok = new Fuvarok("fuvar.csv");

        System.out.println(fuvarok);

        System.out.printf("1. feladat: %d utazás került feljegyzésre az állományban!\n", fuvarok.getUtazasokSzama());
        System.out.printf("2. feladat: A 6185-ös azonosítójú taxis fuvarainak száma: %d és bevételeinek száma %f !\n",fuvarok.fuvarokSzamaIdAlapjan(6185),
                fuvarok.getBevetelekSzamaIdAlapjan(6185));
        System.out.printf("3. feladat: %f mérföldet tettek meg a taxisok!\n", fuvarok.getOsszesMerfold());
        System.out.println("4. feladat: Az időben leghosszabb fuvar adatai: " + fuvarok.getLeghosszabbFuvar());
        System.out.println("5. feladat: A legbőkezűbb fuvar adatai: " + fuvarok.getLegbokezubbFuvar());
        System.out.println("6. feladat: A 4261-es azonosítójú taxis megtett kilométereinek száma: " + fuvarok.getKilometerekSzamaIdAlapjan(4261));
        System.out.printf("7. feladat: Hibás adatok száma: %d, összes időtartama: %d , teljes bevétele: %f \n",fuvarok.getHibasakSzama(),
                fuvarok.getHibasakOsszesIdotartama(),fuvarok.getHibasakTeljesBevetele());
        System.out.println("8. feladat: 1452-es azonosítójú taxi szerepel az adatok között:  " + (fuvarok.szerepelE(1452)? "Igen" : "Nem") );
        System.out.println("9. feladat: A 3 időben legrövidebb utazás adatai: ");
        for (Fuvar fuvar: fuvarok.getIdobenLegrovidebbUtazasok(3)) {
            System.out.println(fuvar);
        }


    }
}
