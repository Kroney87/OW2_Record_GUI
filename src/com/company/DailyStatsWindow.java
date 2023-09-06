package com.company;

import javax.swing.*;

public class DailyStatsWindow extends JFrame {
    JFrame frame = new JFrame();

    public DailyStatsWindow(){
        final DailyStatsWindow frame = this;
        frame.setTitle("Daily Stats");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.setVisible(true);
    }





}
