package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SettingsWindow extends JFrame {
    JFrame frame = new JFrame();

    JButton fixMapStat;
    JButton fixHeroStat;
    JButton addHero;
    JButton addMap;
    JButton back;


    public SettingsWindow(){
        final SettingsWindow frame = this;
        frame.setTitle("Settings");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        fixMapStat = new JButton(new AbstractAction("Fix Map Stat") {

            JComboBox mapType;
            JComboBox map;
            JLabel currWins;
            JLabel currLoss;
            JLabel currDraw;
            JLabel newWinsLabel;
            JLabel newLossLabel;
            JLabel newDrawLabel;
            JTextField newWins;
            JTextField newLoss;
            JTextField newDraw;

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fixMapStatWindow = new JFrame();
                JButton exit = new JButton(new AbstractAction("Exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fixMapStatWindow.dispose();
                    }
                });

                JButton done = new JButton(new AbstractAction("Done") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fixMapStatWindow.dispose();
                    }
                });


                fixMapStatWindow.setTitle("Fix Map Stat");
                fixMapStatWindow.setSize(400,400);
                fixMapStatWindow.setLocationRelativeTo(null);

                fixMapStatWindow.setResizable(false);
                fixMapStatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fixMapStatWindow.setLayout(null);

                String[] mapTypeList = {"None","Control","Escort", "Hybrid", "Push"};
                mapType = new JComboBox(mapTypeList);
                mapType.addActionListener(mapType);

                String[] mapList = {"None", "Map1","Map2","Map3"};
                map = new JComboBox(mapList);
                map.addActionListener(map);

                currWins = new JLabel("Current Map Wins: (maps wins)" );
                currLoss = new JLabel("Current Map Loss: (maps loss)");
                currDraw = new JLabel("Current Map Draw: (maps draws");
                newWinsLabel = new JLabel("New:");
                newLossLabel = new JLabel("New:");
                newDrawLabel = new JLabel("New:");
                newWins = new JFormattedTextField();
                newLoss = new JFormattedTextField();
                newDraw = new JFormattedTextField();


                mapType.setBounds(50,50,100,20);
                map.setBounds(170,50,100,20);
                currWins.setBounds(20, 80,200,20);
                newWinsLabel.setBounds(50,110,100,20);
                currLoss.setBounds(20,140,200,20);
                newLossLabel.setBounds(50,170,100,20);
                currDraw.setBounds(20,200,200,20);
                newDrawLabel.setBounds(50,230,100,20);
                newWins.setBounds(100,110,50,20);
                newLoss.setBounds(100,170,50,20);
                newDraw.setBounds(100,230,50,20);
                exit.setBounds(200,300,100,50);
                done.setBounds(100,300,100,50);

                fixMapStatWindow.add(mapType);
                fixMapStatWindow.add(map);
                fixMapStatWindow.add(currWins);
                fixMapStatWindow.add(currLoss);
                fixMapStatWindow.add(currDraw);
                fixMapStatWindow.add(newWinsLabel);
                fixMapStatWindow.add(newLossLabel);
                fixMapStatWindow.add(newDrawLabel);
                fixMapStatWindow.add(newWins);
                fixMapStatWindow.add(newLoss);
                fixMapStatWindow.add(newDraw);
                fixMapStatWindow.add(exit);
                fixMapStatWindow.add(done);


                fixMapStatWindow.setVisible(true);
            }
        });

        fixHeroStat = new JButton(new AbstractAction("Fix Hero Stat") {

            JComboBox role;
            JComboBox hero;
            JLabel currWins;
            JLabel currLoss;
            JLabel currDraw;
            JLabel newWinsLabel;
            JLabel newLossLabel;
            JLabel newDrawLabel;
            JTextField newWins;
            JTextField newLoss;
            JTextField newDraw;


            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fixHeroStatWindow = new JFrame();
                JButton exit = new JButton(new AbstractAction("Exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fixHeroStatWindow.dispose();
                    }
                });

                JButton done = new JButton(new AbstractAction("Done") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fixHeroStatWindow.dispose();
                    }
                });

                fixHeroStatWindow.setTitle("Fix Hero Stat");
                fixHeroStatWindow.setSize(400,400);
                fixHeroStatWindow.setLocationRelativeTo(null);

                fixHeroStatWindow.setResizable(false);
                fixHeroStatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fixHeroStatWindow.setLayout(null);

                String[] roleList = {"None","Tank", "DPS", "Support"};
                role = new JComboBox(roleList);
                role.addActionListener(role);

                String[] heroList = {"None","Hero1", "Hero2", "Hero3"};
                hero = new JComboBox(heroList);
                hero.addActionListener(hero);

                currWins = new JLabel("Current Hero Wins: (Hero wins)" );
                currLoss = new JLabel("Current Hero Loss: (Hero loss)");
                currDraw = new JLabel("Current Hero Draw: (Hero draws");
                newWinsLabel = new JLabel("New:");
                newLossLabel = new JLabel("New:");
                newDrawLabel = new JLabel("New:");
                newWins = new JFormattedTextField();
                newLoss = new JFormattedTextField();
                newDraw = new JFormattedTextField();

                role.setBounds(50,50,100,20);
                hero.setBounds(170,50,100,20);
                currWins.setBounds(20, 80,200,20);
                newWinsLabel.setBounds(50,110,100,20);
                currLoss.setBounds(20,140,200,20);
                newLossLabel.setBounds(50,170,100,20);
                currDraw.setBounds(20,200,200,20);
                newDrawLabel.setBounds(50,230,100,20);
                newWins.setBounds(100,110,50,20);
                newLoss.setBounds(100,170,50,20);
                newDraw.setBounds(100,230,50,20);
                exit.setBounds(200,300,100,50);
                done.setBounds(100,300,100,50);

                fixHeroStatWindow.add(role);
                fixHeroStatWindow.add(hero);
                fixHeroStatWindow.add(currWins);
                fixHeroStatWindow.add(currLoss);
                fixHeroStatWindow.add(currDraw);
                fixHeroStatWindow.add(newWinsLabel);
                fixHeroStatWindow.add(newLossLabel);
                fixHeroStatWindow.add(newDrawLabel);
                fixHeroStatWindow.add(newWins);
                fixHeroStatWindow.add(newLoss);
                fixHeroStatWindow.add(newDraw);
                fixHeroStatWindow.add(exit);
                fixHeroStatWindow.add(done);



                fixHeroStatWindow.setVisible(true);
            }
        });

        addHero = new JButton(new AbstractAction("Add Hero") {
            JLabel role;
            JLabel heroName;
            JTextField roleEntry;
            JTextField heroNameEntry;

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addHeroWindow = new JFrame();
                JButton exit = new JButton(new AbstractAction("Exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addHeroWindow.dispose();
                    }
                });

                JButton done = new JButton(new AbstractAction("Done") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addHeroWindow.dispose();
                    }
                });

                addHeroWindow.setTitle("Add Hero");
                addHeroWindow.setSize(300,300);
                addHeroWindow.setLocationRelativeTo(null);

                addHeroWindow.setResizable(false);
                addHeroWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addHeroWindow.setLayout(null);

                role = new JLabel("Role:");
                heroName = new JLabel("Hero Name:");
                roleEntry = new JFormattedTextField();
                heroNameEntry = new JFormattedTextField();

                role.setBounds(50,100,100,20);
                heroName.setBounds(50,130,100,20);
                roleEntry.setBounds(100,100,100,20);
                heroNameEntry.setBounds(140,130,100,20);
                exit.setBounds(150,200,70,50);
                done.setBounds(70,200,70,50);

                addHeroWindow.add(role);
                addHeroWindow.add(heroName);
                addHeroWindow.add(roleEntry);
                addHeroWindow.add(heroNameEntry);
                addHeroWindow.add(exit);
                addHeroWindow.add(done);



                addHeroWindow.setVisible(true);
            }
        });

        addMap = new JButton(new AbstractAction("Add Map") {
            JLabel mapType;
            JLabel mapName;
            JTextField mapTypeEntry;
            JTextField mapNameEntry;


            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addMapWindow = new JFrame();
                JButton exit = new JButton(new AbstractAction("Exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addMapWindow.dispose();
                    }
                });

                JButton done = new JButton(new AbstractAction("Done") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addMapWindow.dispose();
                    }
                });

                addMapWindow.setTitle("Add Map");
                addMapWindow.setSize(300,300);
                addMapWindow.setLocationRelativeTo(null);

                addMapWindow.setResizable(false);
                addMapWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addMapWindow.setLayout(null);

                mapType = new JLabel("Map Type:");
                mapName = new JLabel("Map Name:");
                mapTypeEntry = new JFormattedTextField();
                mapNameEntry = new JFormattedTextField();

                mapType.setBounds(50,100,100,20);
                mapName.setBounds(50,130,100,20);
                mapTypeEntry.setBounds(120,100,100,20);
                mapNameEntry.setBounds(120,130,100,20);
                exit.setBounds(150,200,70,50);
                done.setBounds(70,200,70,50);

                addMapWindow.add(mapType);
                addMapWindow.add(mapName);
                addMapWindow.add(mapTypeEntry);
                addMapWindow.add(mapNameEntry);
                addMapWindow.add(exit);
                addMapWindow.add(done);



                addMapWindow.setVisible(true);
            }
        });

        back = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartWindow startWindow = new StartWindow();
            }
        });

        fixMapStat.setBounds(150,100,150,100);
        fixHeroStat.setBounds(300,100,150,100);
        addHero.setBounds(150,200,300,100);
        addMap.setBounds(150,300,300,100);
        back.setBounds(150,400,300,100);

        frame.add(fixMapStat);
        frame.add(fixHeroStat);
        frame.add(addHero);
        frame.add(addMap);
        frame.add(back);

        frame.setVisible(true);
    }
}
