package school;

import java.util.ArrayList;
import java.util.Objects;

public class Persoon {
    private String naam;
    private Double budget;
    private ArrayList<Game> games;
    private Game gameObj;

    public Persoon(String nm, double bud){
        naam = nm;
        budget = Double.valueOf(bud);
        games = new ArrayList<Game>();
    }

    public String getNaam() { return naam; }
    public Double getBudget() { return budget; }
    public ArrayList<Game> getGames() { return games; }
    public Game getGameObj() { return gameObj; }

    public void setBudget(Double budget) { this.budget = budget; }
    public void setNaam(String naam) { this.naam = naam; }
    public void setGameObj(Game gameObj) { this.gameObj = gameObj; }
    public void setGames(ArrayList<Game> games) { this.games = games; }

    public boolean koop(Game game){
        Double huidigeWaarde = game.huidigeWaarde();
        if (budget >= huidigeWaarde && !games.contains(game)){
            budget = budget - huidigeWaarde;
            games.add(game);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean verkoop(Game g, Persoon koper){
        Double huidigeWaarde = g.huidigeWaarde();
        if(!koper.games.contains(g)) {
            if(games.contains(g)){
                if (koper.budget >= huidigeWaarde) {
                    koper.budget = koper.budget - huidigeWaarde ;
                    budget = budget + huidigeWaarde;
                    koper.games.add(g);
                    games.remove(g);
                    return true;
                }
            }
        }
        return false;
    }
    public int hashCode() {
        return Objects.hash(naam, budget, gameObj, games);
    }

    public String toString(){
        String out = naam + " heeft een budget van €" +  String.format("%.2f", budget) + " en bezit de volgende games:";
        for (Game g: games){
            out += "\n"+ g;
        }
        return out;
    }



    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> teKoop) {
        for (Game tekoop : teKoop) {
            if (games.contains(tekoop)) {
                teKoop.remove(tekoop);
            }
        }
        return teKoop;
    }
    //test 333
}
