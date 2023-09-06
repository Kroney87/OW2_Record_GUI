package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StatsWindow extends JFrame {
    JFrame frame = new JFrame();

    JButton dailyStats;
    JButton mapStats;
    JButton heroStats;
    JButton back;

    public StatsWindow(){
        final StatsWindow frame = this;
        frame.setTitle("Stats");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        dailyStats = new JButton(new AbstractAction("Daily Stats") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DailyStatsWindow dailyStatsWindow = new DailyStatsWindow();
            }
        });

        mapStats = new JButton(new AbstractAction("Map Stats") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    MapStatsWindow mapStatsWindow = new MapStatsWindow();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        heroStats = new JButton(new AbstractAction("Hero Stats") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    HeroStatsWindow heroStatsWindow = new HeroStatsWindow();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        back = new JButton(new AbstractAction("Done") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StartWindow startWindow = new StartWindow();
            }
        });


        dailyStats.setBounds(150,100,300,100);
        mapStats.setBounds(150,200,300,100);
        heroStats.setBounds(150,300,300,100);
        back.setBounds(150,400,300,100);

        frame.add(dailyStats);
        frame.add(mapStats);
        frame.add(heroStats);
        frame.add(back);


        frame.setVisible(true);
    }
}
