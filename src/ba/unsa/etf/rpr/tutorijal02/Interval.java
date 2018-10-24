package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pocetnaPripada, krajnjaPripada;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada)
             throws IllegalArgumentException {
        if(pocetnaTacka>krajnjaTacka)
            throw IllegalArgumentException ("Pocetna tacka veca od krajnje!\n");
        this.pocetnaTacka=pocetnaTacka;
        this.krajnjaTacka=krajnjaTacka;
        this.pocetnaPripada=pocetnaPripada;
        this.krajnjaPripada=krajnjaPripada;
    }

    public Interval(){
        pocetnaTacka=0;
        krajnjaTacka=0;
        pocetnaPripada=false;
        krajnjaPripada=false;
    }

    public boolean isNull(){
        return this.equals(new Interval());   //?????
    }

    public boolean isIn(double vrijednostTacke){
        return (vrijednostTacke>=pocetnaTacka && vrijednostTacke<=krajnjaTacka);
    }

    public Interval intersect(Interval i){
        if(this.equals(i)) return this;
        else if(krajnjaTacka<i.pocetnaTacka || i.krajnjaTacka<pocetnaTacka)
            return new Interval();
        else if(pocetnaTacka=<i.pocetnaTacka && krajnjaTacka>=i.krajnjaTacka &&
               )
            return i;
        else if(pocetnaTacka>=i.pocetnaTacka && krajnjaTacka=<i.krajnjaTacka &&
        )
            return this;
        else if(){

        }

    }

    public static Interval intersect(Interval i1, Interval i2){

    }

    public void toString(){

    }

    public boolean equals(){

    }
}
