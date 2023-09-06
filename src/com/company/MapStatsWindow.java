package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;

import static com.company.MapReader.getMapList;
import static com.company.MapReader.readMaps;

public class MapStatsWindow extends JFrame {
    JFrame frame = new JFrame();
    JTextArea area = new JTextArea(30,50);
    JScrollPane scrollPane = new JScrollPane(area);
    JButton back;
    JButton done;

    public MapStatsWindow() throws IOException {
        area.setText("");
        final MapStatsWindow frame = this;
        frame.setTitle("Map Stats");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        readMaps();

        area.append("=====================================\n");
        area.append("Maps Ranked by Win/Loss ratio\n");
        area.append("=====================================\n");
        Collections.sort(getMapList(), new Map.win_loss_ratioCompare());
        for (Map map : getMapList()){
            area.append(map.printMapWinLossRatio());
        }

        done = new JButton(new AbstractAction("Done") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        back = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("");
                frame.dispose();
                StatsWindow statsWindow = new StatsWindow();
            }
        });

        area.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        area.setCaretPosition(0);
        this.getContentPane().add(scrollPane);

        frame.add(done);
        frame.add(back);


        frame.setVisible(true);
    }




}
