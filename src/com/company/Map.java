package com.company;

import java.util.Comparator;

public class Map {
    public String mapType;
    public String name;
    public int wins;
    public int loss;
    public int draw;
    public int totalGames;
    public double win_loss_ratio;

    public Map(String mapType, String name, int wins, int loss, int draw){
        this.mapType = mapType;
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

    public static class MapTypeCompare implements Comparator<Map> {
        public int compare(Map map1, Map map2){
            return map1.mapType.compareTo(map2.mapType);
        }
    }

    public static class MapNameCompare implements Comparator<Map>{
        public int compare(Map map1, Map map2){
            return map1.name.compareTo(map2.name);
        }
    }
    public static class MapWinCompare implements Comparator<Map>{
        public int compare(Map map1, Map map2){
            if (map1.wins > map2.wins){
                return -1;
            }
            else if (map1.wins < map2.wins){
                return 1;
            }
            else{
                if (map1.loss > map2.loss){
                    return 1;
                }
                else if (map1.loss < map2.loss){
                    return -1;
                }
                else{
                    return map1.name.compareTo(map2.name);
                }
            }
        }
    }
    public static class MapLossCompare implements Comparator<Map>{
        public int compare(Map map1, Map map2){
            if (map1.loss > map2.loss){
                return -1;
            }
            else if (map1.loss < map2.loss){
                return 1;
            }
            else{
                return map1.name.compareTo(map2.name);
            }
        }
    }
    public static class win_loss_ratioCompare implements Comparator<Map>{
        public int compare(Map map1, Map map2){
            if (map1.win_loss_ratio > map2.win_loss_ratio){
                return -1;
            }
            else if (map1.win_loss_ratio < map2.win_loss_ratio){
                return 1;
            }
            else{
                return map1.name.compareTo(map2.name);
            }
        }
    }

    public String printMapWinLossRatio(){
        double percent = (100 * win_loss_ratio);
        return String.format("%s - %.1f%%\n", name, percent);
    }


    public String printNames(){
        return String.format("%s - %s - W:%d/L:%d/D:%d", mapType, name, wins, loss, draw);
    }
    public String printMaps(){
        return String.format("%s: W:%d/L:%d/D:%d", name, wins, loss, draw);
    }
    public String printMapWins(){
        return String.format("%s - %d", name, wins);
    }
    public String getMapType(){
        return this.mapType;
    }
}
