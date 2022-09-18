package com.chamifj.tankedz.Tankgme03;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Battlefield extends Panel implements KeyListener ,Runnable {
    private MyTank tb = null;
    private Vector<Enemytanks> enemytanks = new Vector<>();
    private int enemytanksize = 3;
    public Battlefield(){
        for (int i = 0; i < enemytanksize; i++) {
            enemytanks.add(new Enemytanks(100 * (i + 1),0));
        }
        tb = new MyTank(100,100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        Tankpa(tb.getX(),tb.getY(),g,tb.getDirection(),0);
        for (int i = 0; i < enemytanks.size(); i++) {
            Enemytanks enemytanks = this.enemytanks.get(i);
            Tankpa(enemytanks.getX(),enemytanks.getY(),g,enemytanks.getDirection(),1);
        }
        //子弹发射绘制
        if (tb.getLaunch() != null&& tb.getLaunch().issurvive == true){
            g.fill3DRect(tb.getLaunch().getX(),tb.getLaunch().getY(),2,2,false);
        }

    }
    public void Tankpa(int x,int y,Graphics g,int direction,int type){
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.pink);
                break;
        }
        //direction (0：向上，1：向下 ，2： 向左 3：向右）
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+ 10 ,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y,x+20,y+30);
                break;
            case 1:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+ 10 ,y + 10,20,40,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y + 30,x+20,y + 60);
               break;
            case 2:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+ 10 ,y + 10,40,20,false);
                g.fill3DRect(x ,y + 30,60,10,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y + 20,x - 10,y + 20);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x+ 10 ,y + 10,40,20,false);
                g.fill3DRect(x ,y + 30,60,10,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y + 20,x+60,y + 20);
                break;



        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //向上移动
        if (e.getKeyCode() == KeyEvent.VK_UP){
            tb.setDirection(0);
           tb.setY(tb.getY() - 10);
        }
        //向下移动
        else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            tb.setDirection(1);
            tb.setY(tb .getY() + 10);
        }
        //向左移动
        else if (e.getKeyCode() ==  KeyEvent.VK_LEFT){
            tb.setDirection(2);
            tb.setX(tb.getX() - 10);
        }
        //向右移动；
        else if (e.getKeyCode() == KeyEvent .VK_RIGHT){
            tb.setDirection(3);
            tb.setX(tb.getX() + 10);
        }
        //如果按下j 发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J){
            tb.Shotpress();
        }
        repaint();


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
