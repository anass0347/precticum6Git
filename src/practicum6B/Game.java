package practicum6B;

import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){
        if(releaseJaar== LocalDate.now().getYear()){

            return nieuwprijs;

        }

        if(releaseJaar == LocalDate.now().getYear()-5){
            return (nieuwprijs* (0.7)*(0.7)*(0.7)*(0.7)*(0.7));
        }
        return nieuwprijs * 0.7;
    }

    public boolean equals(Object andereObject){
        boolean gelijkeObjecten = false;
        if (andereObject instanceof Game) {
            Game anderegame = (Game) andereObject;

            if (this.naam.equals(anderegame.naam)&&(this.releaseJaar == anderegame.releaseJaar)) {

                gelijkeObjecten = true;

            }

        }
        return gelijkeObjecten;
    }

    public String toString(){

        return naam + ", uitgegeven in "+ releaseJaar +"; nieuwprijs: €" + String.format("%.2f",nieuwprijs) +" nu voor: €"+ String.format("%.2f",huidigeWaarde());

    }
}
