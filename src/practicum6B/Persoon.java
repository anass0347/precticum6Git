package practicum6B;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> gameLijst;



    public Persoon(String nm, double bud){
        gameLijst = new ArrayList<Game>();
        naam = nm;
        budget = bud;
    }

    public double getBudget(){
        return budget;

    }

    public boolean koop(Game g){
        if (gameLijst.contains(g)) {
            return false;
        }

        if (budget <= g.huidigeWaarde()) {
            return false;
        }

        budget = getBudget() - g.huidigeWaarde();
        this.gameLijst.add(g);
        return true;
    }

    public boolean verkoop(Game g, Persoon koper){
        if(koper.budget >= g.huidigeWaarde() && !koper.gameLijst.contains(g) && gameLijst.contains(g)){
            koper.gameLijst.add(g);

            gameLijst.remove(g);

            koper.budget = koper.getBudget() - g.huidigeWaarde();
            budget = getBudget() + g.huidigeWaarde();
            return true;

        }else{
            koper.gameLijst.remove(g);
            return false;
        }

    }

    public Game zoekGameOpNaam(String g){
        for(Game game : gameLijst){
            if(game.getNaam().equals(g)){
                return game;
            }
        }
        return null;


    }



    public String toString(){
        String res = naam + " heeft een budget van €" + String.format("%.2f", getBudget()) + " en bezit de volgende games:";
        for(int i = 0; i< gameLijst.size(); i++){
            res += "\n";
            res += gameLijst.get(i);


        }
        return res;
    }
}
