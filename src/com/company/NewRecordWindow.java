package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.company.Hero.addHeroWin;
import static com.company.HeroReader.getHeroList;
import static com.company.HeroReader.readHeroes;
import static com.company.MapReader.getMapList;
import static com.company.MapReader.readMaps;

public class NewRecordWindow extends JFrame implements ActionListener {
    JFrame frame = new JFrame();

    JRadioButton win;
    JRadioButton loss;
    JComboBox mapType;
    JComboBox map;
    JComboBox role;
    JComboBox hero;
    JComboBox hero2;
    JComboBox hero3;
    JButton done;
    JButton cancel;
    JButton addHero;

    int pressCount;

    public NewRecordWindow() throws IOException {
        final NewRecordWindow frame = this;
        frame.setTitle("New Record");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        win = new JRadioButton("Win");
        loss = new JRadioButton("Loss");
        ButtonGroup group = new ButtonGroup();
        group.add(win);
        group.add(loss);

        done = new JButton(new AbstractAction("Done") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(win.isSelected()){
                    String heroName = hero.getSelectedItem().toString();
                    System.out.println("Im am" + heroName + ".");
                    try {
                        addHeroWin(heroName);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();
                    StartWindow startWindow = new StartWindow();
                }
            }
        });

        cancel = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartWindow startWindow = new StartWindow();
            }
        });

        pressCount = 0;
        addHero = new JButton(new AbstractAction("Add Hero") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pressCount == 0){
                    hero2.setVisible(true);
                    pressCount++;
                }
                else if  (pressCount == 1){
                    hero3.setVisible(true);
                    pressCount++;
                }
                else{
                    JOptionPane.showMessageDialog(null,"Only 3 hero entries aloud!");
                }
            }
        });

        String[] mapTypeList = {"None","Control","Escort", "Hybrid", "Push"};
        mapType = new JComboBox(mapTypeList);
        mapType.addActionListener(this);

        String[] roleList = {"None","Tank", "DPS", "Support"};
        role = new JComboBox(roleList);
        role.addActionListener(this);

        String[] emptyRole = {"Select role!"};
        hero = new JComboBox(emptyRole);
        hero.addActionListener(this);

        hero2 = new JComboBox(emptyRole);
        hero2.addActionListener(this);

        hero3 = new JComboBox(emptyRole);
        hero3.addActionListener(this);

        hero2.setVisible(false);
        hero3.setVisible(false);

        String[] emptyMap = {"Select map type!"};
        map = new JComboBox(emptyMap);
        map.setVisible(true);
        map.addActionListener(this);

        win.setBounds(150, 100, 150,50);
        loss.setBounds(300,100,150,50);
        done.setBounds(150,500,150,50);
        cancel.setBounds(300,500,150,50);
        addHero.setBounds(150,300,100,20);
        mapType.setBounds(150, 200,100,20);
        map.setBounds(270,200,100,20);
        role.setBounds(150, 250,100,20);
        hero.setBounds(270,250,100,20);
        hero2.setBounds(270,300,100,20);
        hero3.setBounds(270,350,100,20);

        frame.add(win);
        frame.add(loss);
        frame.add(done);
        frame.add(cancel);
        frame.add(addHero);
        frame.add(mapType);
        frame.add(role);
        frame.add(hero);
        frame.add(hero2);
        frame.add(hero3);
        frame.add(map);

        frame.setVisible(true);

        Collections.sort(getMapList(), new Map.MapTypeCompare());
        try {
            readMaps();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Collections.sort(getHeroList(),new Hero.roleCompare());
        try {
            readHeroes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mapType){
            System.out.println(mapType.getSelectedItem());
            ArrayList<String> controlMaps = new ArrayList<>();
            ArrayList<String> escortMaps = new ArrayList<>();
            ArrayList<String> hybridMaps = new ArrayList<>();
            ArrayList<String> pushMaps = new ArrayList<>();

            if (mapType.getSelectedItem().equals("Control")){
                System.out.println("In Control");
                controlMaps.clear();
                for (Map maps : getMapList()){
                    if (maps.getMapType().equals("Control")){
                        controlMaps.add(maps.name);
                    }
                }
                map.removeAllItems();
                for (String controlMap : controlMaps){
                    System.out.println(controlMap);
                    map.addItem(controlMap);
                }
            }
            else if (mapType.getSelectedItem().equals("Escort")){
                System.out.println("In Escort");
                escortMaps.clear();
                for (Map maps : getMapList()){
                    if (maps.getMapType().equals("Escort")){
                        escortMaps.add(maps.name);
                    }
                }
                map.removeAllItems();
                for (String escortMap : escortMaps){
                    System.out.println(escortMap);
                    map.addItem(escortMap);
                }
            }
            else if (mapType.getSelectedItem().equals("Hybrid")){
                System.out.println("In Hybrid");
                hybridMaps.clear();
                for (Map maps : getMapList()){
                    if (maps.getMapType().equals("Hybrid")){
                        hybridMaps.add(maps.name);
                    }
                }
                map.removeAllItems();
                for (String hybridMap : hybridMaps){
                    System.out.println(hybridMap);
                    map.addItem(hybridMap);
                }
            }
            else if (mapType.getSelectedItem().equals("Push")){
                System.out.println("In Push");
                pushMaps.clear();
                for (Map maps : getMapList()){
                    if (maps.getMapType().equals("Push")){
                        pushMaps.add(maps.name);
                    }
                }
                map.removeAllItems();
                for (String pushMap : pushMaps){
                    System.out.println(pushMap);
                    map.addItem(pushMap);
                }
            }else{
                System.out.println("None Map");
                map.removeAllItems();
                map.addItem("Select map Type!");
            }
        }
        if (e.getSource() == role) {
            System.out.println(role.getSelectedItem());
            ArrayList<String> tanksList = new ArrayList<>();
            ArrayList<String> dpsList = new ArrayList<>();
            ArrayList<String> suppsList = new ArrayList<>();

            if (role.getSelectedItem().equals("Tank")) {
                System.out.println("In Tank");
                tanksList.clear();
                for (Hero heroes : getHeroList()) {
                    if (heroes.getRole().equals("Tank")) {
                        tanksList.add(heroes.name);
                    }
                }
                hero.removeAllItems();
                for (String heroName : tanksList) {
                    System.out.println(heroName);
                    hero.addItem(heroName);
                }
            } else if (role.getSelectedItem().equals("DPS")) {
                System.out.println("In DPS");
                dpsList.clear();
                for (Hero heroes : getHeroList()) {
                    if (heroes.getRole().equals("DPS")) {
                        dpsList.add(heroes.name);
                    }
                }
                hero.removeAllItems();
                for (String heroName : dpsList) {
                    System.out.println(heroName);
                    hero.addItem(heroName);
                }
            } else if (role.getSelectedItem().equals("Support")) {
                System.out.println("In Support");
                suppsList.clear();
                for (Hero heroes : getHeroList()) {
                    if (heroes.getRole().equals("Support")) {
                        suppsList.add(heroes.name);
                    }
                }
                hero.removeAllItems();
                for (String heroName : suppsList) {
                    System.out.println(heroName);
                    hero.addItem(heroName);
                }

            } else {
                System.out.println("None Hero");
                hero.removeAllItems();
                hero.addItem("Select role!");
            }
        }
    }
}
