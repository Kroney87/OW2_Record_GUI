package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapReader {
    private static final ArrayList<Map> mapList = new ArrayList<Map>();

    public static void readMaps() throws IOException {
        File mapFile = new File("Map.txt");
        Scanner readFile = new Scanner(mapFile);
        StringTokenizer token = null;

        String mapType = "";
        String mapName = "";
        int wins = 0;
        int loss = 0;
        int draws = 0;

        while(readFile.hasNextLine()) {
            token = new StringTokenizer(readFile.nextLine(), ",");
            mapType = token.nextToken();
            mapName = token.nextToken();
            wins = Integer.parseInt(token.nextToken());
            loss = Integer.parseInt(token.nextToken());
            draws = Integer.parseInt(token.nextToken());

            Map map = new Map(mapType,mapName,wins,loss,draws);
            mapList.add(map);
        }
    }
    public static ArrayList<Map> getMapList(){
        return mapList;
    }
}
