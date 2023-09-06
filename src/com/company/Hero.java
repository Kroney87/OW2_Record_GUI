package com.company;

import java.io.IOException;
import java.util.Comparator;

import static com.company.HeroReader.*;

public class Hero {
    public String role;
    public String name;
    public int wins;
    public int loss;
    public int draw;
    public int totalGames;
    public double win_loss_ratio;

    public Hero(){}


    public Hero(String role,String name, int wins, int loss, int draw){
        this.role = role;
        this.name = name;
        this.wins = wins;
        this.loss = loss;
        this.draw = draw;
        this.totalGames = wins + loss + draw;
        if (totalGames == 0){
            this.win_loss_ratio = 0;
        }
        else{
            this.win_loss_ratio = wins/(double)totalGames;
        }
    }

    public String toString(){
        return String.format("%s - W:%d/L:%d/D:%d", name,wins,loss,draw);
    }

    static class HeroNameCompare implements Comparator<Hero> {
        public int compare(Hero hero1, Hero hero2){
            return hero1.name.compareTo(hero2.name);
        }
    }

    static class HeroWinCompare implements Comparator<Hero>{
        public int compare(Hero hero1,Hero hero2){
            if (hero1.wins > hero2.wins){
                return -1;
            }
            else if (hero1.wins < hero2.wins){
                return 1;
            }
            else{
                return hero1.name.compareTo(hero2.name);
            }
        }
    }
    static class HeroLossCompare implements Comparator<Hero>{
        public int compare(Hero hero1, Hero hero2){
            if (hero1.loss > hero2.loss){
                return -1;
            }
            else if (hero1.loss < hero2.loss){
                return 1;
            }
            else{
                return hero1.name.compareTo(hero2.name);
            }
        }
    }

    static class w_l_ratioCompare implements Comparator<Hero>{
        public int compare(Hero hero1, Hero hero2){
            if (hero1.win_loss_ratio > hero2.win_loss_ratio){
                return -1;
            }
            else if (hero1.win_loss_ratio < hero2.win_loss_ratio){
                return 1;
            }
            else{
                return hero1.name.compareTo(hero2.name);
            }
        }
    }

    static  class roleCompare implements Comparator<Hero>{
        public int compare(Hero o1, Hero o2) {
            return o1.role.compareTo(o2.role);
        }
    }

    public String printWinLossRatio(){
        double percent = (100 * win_loss_ratio);
        return String.format("%s - %.1f%%\n", name, percent);
    }
    public String displayHero(){
        return name + " -  W:" + wins + "  /  L:" + loss + "  /  D:" + draw + "\n";
    }

    public static void addHeroWin(String name) throws IOException {
        for (Hero hero : getHeroList()){
            if (hero.name.equals(name)){
                hero.wins++;
                System.out.println( readHeroesFile(name));
            }
        }
    }
    public void addHeroLoss(){
        this.loss++;
    }
    public void addHeroTie(){
        this.draw++;
    }

    public String getRole(){
        return this.role;
    }
}


