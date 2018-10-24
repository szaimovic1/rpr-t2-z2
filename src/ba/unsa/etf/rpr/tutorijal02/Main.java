package ba.unsa.etf.rpr.tutorijal02;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Nema ništa u mainu, pokrenite testove!");

        Interval i = new Interval(1.1, 2.5, true, false);
        Interval i2 = new Interval(1.1, 2.5, true, false);
        if(i.equals(i2))
            System.out.println("TOOO");
        System.out.println("TUGY");

    }
}
