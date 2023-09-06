package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Collections;

import static com.company.HeroReader.getHeroList;
import static com.company.HeroReader.readHeroes;

public class HeroStatsWindow extends JFrame {
    JFrame frame = new JFrame();
    JTextArea area = new JTextArea(30,50);
    JScrollPane scrollPane = new JScrollPane(area);
    JButton back;
    JButton done;

    public HeroStatsWindow() throws IOException {
        area.setText("");
        final HeroStatsWindow frame = this;
        frame.setTitle("Hero Stats");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        readHeroes();

        area.append("=====================================\n");
        area.append("Heroes Ranked by Win/Loss ratio\n");
        area.append("=====================================\n");
        Collections.sort(getHeroList(),new Hero.w_l_ratioCompare());
        for (Hero hero : getHeroList()){
            area.append(hero.printWinLossRatio());
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
