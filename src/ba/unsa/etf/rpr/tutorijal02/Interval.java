package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetnaTacka, krajnjaTacka;
    private boolean pocetnaPripada, krajnjaPripada;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripada, boolean krajnjaPripada)
             throws IllegalArgumentException {
        if(pocetnaTacka>krajnjaTacka)
            throw new IllegalArgumentException ("Pocetna tacka veca od krajnje!\n");
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
        return ((vrijednostTacke>pocetnaTacka && vrijednostTacke<krajnjaTacka)
               || (vrijednostTacke==pocetnaTacka && pocetnaPripada)
               || (vrijednostTacke==krajnjaTacka && krajnjaPripada));
    }

    public Interval intersect(Interval i){
        if(this.equals(i)) return this;
        else if(krajnjaTacka<i.pocetnaTacka || i.krajnjaTacka<pocetnaTacka)
            return new Interval();
        else if(pocetnaTacka<=i.pocetnaTacka && krajnjaTacka>=i.krajnjaTacka ||
                (pocetnaTacka<=i.pocetnaTacka && krajnjaTacka>i.krajnjaTacka) ||
                (pocetnaTacka<i.pocetnaTacka && krajnjaTacka>=i.krajnjaTacka) ||
                (pocetnaTacka==i.pocetnaTacka && krajnjaTacka==i.krajnjaTacka &&
                 (i.krajnjaPripada || i.pocetnaPripada) && !(i.krajnjaPripada && i.pocetnaPripada)))
            return i;
        else if((pocetnaTacka>i.pocetnaTacka && krajnjaTacka<i.krajnjaTacka) ||
                (pocetnaTacka>=i.pocetnaTacka && krajnjaTacka<i.krajnjaTacka) ||
                (pocetnaTacka>i.pocetnaTacka && krajnjaTacka<=i.krajnjaTacka) ||
                (pocetnaTacka==i.pocetnaTacka && krajnjaTacka==i.krajnjaTacka &&
                 (krajnjaPripada || pocetnaPripada) && !(krajnjaPripada && pocetnaPripada)))
            return this;
        else if(pocetnaTacka<i.pocetnaTacka && krajnjaTacka<i.krajnjaTacka){
            if(krajnjaTacka==i.pocetnaTacka && krajnjaPripada && i.pocetnaPripada)
                return new Interval(krajnjaTacka, krajnjaTacka, true, true);
            else if(krajnjaTacka==i.pocetnaTacka && (!krajnjaPripada || !i.pocetnaPripada))
                return new Interval();
            else if(i.pocetnaPripada && krajnjaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, true, true);
            else if(i.pocetnaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, true, false);
            else if(krajnjaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, false, true);
            else
                return new Interval(i.pocetnaTacka, krajnjaTacka, false, false);
        }
        else if(pocetnaTacka>i.pocetnaTacka && krajnjaTacka>i.krajnjaTacka){
            if(i.krajnjaTacka==pocetnaTacka && i.krajnjaPripada && pocetnaPripada)
                return new Interval(krajnjaTacka, krajnjaTacka, true, true);
            else if(i.krajnjaTacka==pocetnaTacka && (!i.krajnjaPripada || !pocetnaPripada))
                return new Interval();
            else if(pocetnaPripada && i.krajnjaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, true, true);
            else if(pocetnaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, true, false);
            else if(i.krajnjaPripada)
                return new Interval(i.pocetnaTacka, krajnjaTacka, false, true);
            else
                return new Interval(i.pocetnaTacka, krajnjaTacka, false, false);
        }
        return new Interval();
    }

    public static Interval intersect(Interval i1, Interval i2){
        if(i1.equals(i2)) return i1;
        else if(i1.krajnjaTacka<i2.pocetnaTacka || i2.krajnjaTacka<i1.pocetnaTacka)
            return new Interval();
        else if(i1.pocetnaTacka<=i2.pocetnaTacka && i1.krajnjaTacka>=i2.krajnjaTacka ||
                (i1.pocetnaTacka<=i2.pocetnaTacka && i1.krajnjaTacka>i2.krajnjaTacka) ||
                (i1.pocetnaTacka<i2.pocetnaTacka && i1.krajnjaTacka>=i2.krajnjaTacka) ||
                (i1.pocetnaTacka==i2.pocetnaTacka && i1.krajnjaTacka==i2.krajnjaTacka &&
                        (i2.krajnjaPripada || i2.pocetnaPripada) && !(i2.krajnjaPripada && i2.pocetnaPripada)))
            return i2;
        else if((i1.pocetnaTacka>i2.pocetnaTacka && i1.krajnjaTacka<i2.krajnjaTacka) ||
                (i1.pocetnaTacka>=i2.pocetnaTacka && i1.krajnjaTacka<i2.krajnjaTacka) ||
                (i1.pocetnaTacka>i2.pocetnaTacka && i1.krajnjaTacka<=i2.krajnjaTacka) ||
                (i1.pocetnaTacka==i2.pocetnaTacka && i1.krajnjaTacka==i2.krajnjaTacka &&
                        (i1.krajnjaPripada || i1.pocetnaPripada) && !(i1.krajnjaPripada && i1.pocetnaPripada)))
            return i1;
        else if(i1.pocetnaTacka<i2.pocetnaTacka && i1.krajnjaTacka<i2.krajnjaTacka){
            if(i1.krajnjaTacka==i2.pocetnaTacka && i1.krajnjaPripada && i2.pocetnaPripada)
                return new Interval(i1.krajnjaTacka, i1.krajnjaTacka, true, true);
            else if(i1.krajnjaTacka==i2.pocetnaTacka && (!i1.krajnjaPripada || !i2.pocetnaPripada))
                return new Interval();
            else if(i2.pocetnaPripada && i1.krajnjaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, true, true);
            else if(i2.pocetnaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, true, false);
            else if(i1.krajnjaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, false, true);
            else
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, false, false);
        }
        else if(i1.pocetnaTacka>i2.pocetnaTacka && i1.krajnjaTacka>i2.krajnjaTacka){
            if(i2.krajnjaTacka==i1.pocetnaTacka && i2.krajnjaPripada && i1.pocetnaPripada)
                return new Interval(i1.krajnjaTacka, i1.krajnjaTacka, true, true);
            else if(i2.krajnjaTacka==i1.pocetnaTacka && (!i2.krajnjaPripada || !i1.pocetnaPripada))
                return new Interval();
            else if(i1.pocetnaPripada && i2.krajnjaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, true, true);
            else if(i1.pocetnaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, true, false);
            else if(i2.krajnjaPripada)
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, false, true);
            else
                return new Interval(i2.pocetnaTacka, i1.krajnjaTacka, false, false);
        }
        return new Interval();
    }

    public String toString(){
        String s;
        if(krajnjaPripada && pocetnaPripada)
            s = "[" + pocetnaTacka + "," + krajnjaTacka + "]";
        else if(pocetnaPripada)
            s = "[" + pocetnaTacka + "," + krajnjaTacka + ")";
        else if(krajnjaPripada)
            s = "(" + pocetnaTacka + "," + krajnjaTacka + "]";
        else if(this.isNull())
            s = "()";
        else
            s = "(" + pocetnaTacka + "," + krajnjaTacka + ")";
        return s;
    }

    public boolean equals(Interval i){
        return ((pocetnaTacka-i.pocetnaTacka)<0.0000001 && (krajnjaTacka-i.krajnjaTacka)<0.0000001
                && pocetnaPripada==i.pocetnaPripada && krajnjaPripada==i.krajnjaPripada);
    }
}
