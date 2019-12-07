package kontroler;

public class Kontroler {
    private static Kontroler kont;
    /*DbBroker db;
    KolekcijaPredmeta kpred;
    KolekcijaPrijava kprij;*/
    private Kontroler() {
       /* db = new DbBroker();
        kpred = new KolekcijaPredmeta();
        kprij = new KolekcijaPrijava();*/
    }

    public static Kontroler getKontroler() {
        if (kont == null)
            kont = new Kontroler();
        return kont;
    }


}
