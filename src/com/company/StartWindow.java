package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class StartWindow extends JFrame {
    JFrame frame = new JFrame();
    JButton newRecord;
    JButton stats;
    JButton settings;
    JButton exit;

    public StartWindow(){
        final StartWindow frame = this;
        frame.setTitle("OW2 Record");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        newRecord = new JButton(new AbstractAction("New Record") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    NewRecordWindow newRecordWindow = new NewRecordWindow();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        newRecord.setBounds(150,100,300,100);

        stats = new JButton(new AbstractAction("Stats") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StatsWindow statsWindow = new StatsWindow();
            }
        });
        stats.setBounds(150,200,300,100);

        settings = new JButton(new AbstractAction("Settings") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SettingsWindow settingsWindow = new SettingsWindow();
            }
        });
        settings.setBounds(150,300,300,100);

        exit = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        exit.setBounds(150,400,300,100);


        frame.add(newRecord);
        frame.add(stats);
        frame.add(settings);
        frame.add(exit);


        frame.setVisible(true);

    }
}
