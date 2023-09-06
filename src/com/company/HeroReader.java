package com.company;

import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HeroReader {
    private static final ArrayList<Hero> heroList = new ArrayList<Hero>();

    public static void readHeroes() throws IOException {
        File heroFile = new File("Hero.txt");
        Scanner readFile = new Scanner(heroFile);
        StringTokenizer token = null;

        String role = "";
        String name = "";
        int wins = 0;
        int loss = 0;
        int draws = 0;

        while (readFile.hasNextLine()) {

            token = new StringTokenizer(readFile.nextLine(), ",");
            role = token.nextToken();
            name = token.nextToken();
            wins = Integer.parseInt(token.nextToken());
            loss = Integer.parseInt(token.nextToken());
            draws = Integer.parseInt(token.nextToken());

            Hero hero = new Hero(role, name, wins, loss, draws);
            heroList.add(hero);
        }
    }

    public static String readHeroesFile(String heroName) throws IOException {
        String filePath = "Hero.txt";
        String tempFile = "Temp.txt";
        File oldHeroFile = new File(filePath);
        File newHeroFile = new File(tempFile);

        int line = 0;
        String currentLine;
        String[] values = new String[6];
        String newInfo = null;

        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){
                line++;
                values = currentLine.split(",");
                if (!(values[1].equals(heroName))){
                    pw.println(currentLine);
                    System.out.println("HERE");
                }
            }
            int wins = Integer.parseInt(values[2]);
            wins++;
            values[2] = String.valueOf(wins);
            newInfo = values[0] + "," + values[1] + "," + values[2] + "," + values[3] + "," +
                    values[4];

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldHeroFile.delete();
            File dump = new File(filePath);
            newHeroFile.renameTo(dump);
        }
        catch(Exception e){
            System.out.println(e + "HeroReader;Line74");
        }
        return newInfo;
    }

    public static ArrayList<Hero> getHeroList(){
        return heroList;
    }
}
