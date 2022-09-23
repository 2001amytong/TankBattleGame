package com.chamifj.tankedz.Tankgme03;

import java.util.Vector;

public class Enemytanks extends Tank implements Runnable {
    Vector<Launch> bullet = new Vector<>();
    boolean issurvive = true;
    public Enemytanks(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {

        while (true){
            if (issurvive&&bullet.size() == 0){
                Launch launchone = null;
                switch (getDirection()){
                    case 0:
                        launchone = new Launch(getX() + 20,getY(),0);
                        break;
                    case 1:
                        launchone = new Launch(getX() + 20,getY() + 60,1);
                        break;
                    case 2://向左
                        launchone = new Launch(getX(),getY() + 20,1);
                        break;
                    case 3://向右
                        launchone = new Launch(getX() + 60,getY() + 20,1);
                        break;
                }
                bullet.add(launchone);
                try {
                    Thread .sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new Thread(launchone).start();
            }
            switch (getDirection()){
                case 0://向上移动
                    for (int i = 0; i < (int)(Math.random()*31); i++) {
                        if (getY() + 10 > 0){
                            moveup();
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 1://向下移动

                    for (int i = 0; i < (int)(Math.random()*31); i++) {
                        if (getY() + 60 < 750){
                            movedown();

                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向左移动

                    for (int i = 0; i < (int)(Math.random()*31); i++){
                        if (getX() + 10 > 0){
                            movelietf();

                    }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < (int)(Math.random()*50); i++){
                        if (getX() + 60 < 1000){
                            moveright();
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setDirection((int)(Math.random()*4));
        }

    }
}
