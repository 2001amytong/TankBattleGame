package com.chamifj.tankedz.Tankgme03;

import javax.swing.*;

public class game01 extends JFrame {
    private Battlefield gm = null;
    public static void main(String[] args) {
        game01 game01 = new game01();

    }
    public game01(){
        gm = new Battlefield();
        this.add(gm);
        new Thread(gm).start();
        this.addKeyListener(gm);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
