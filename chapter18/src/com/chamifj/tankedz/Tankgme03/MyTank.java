package com.chamifj.tankedz.Tankgme03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyTank extends Tank  {
//    private int count = 0;
    boolean issurvive = true;
    private Launch launch = null;
    Vector<Launch> launches = new Vector<>();
    public MyTank(int x, int y) {
        super(x, y);
    }

    public Launch getLaunch() {
        return launch;
    }

    public void Shotpress(){//子弹方向控制
        if (launches.size() > 5){
            return;
        }
        switch (getDirection()){
            case 0://向上
                launch = new Launch(getX() + 20,getY(),0);
                break;
            case 1:
                launch = new Launch(getX() + 20,getY() + 60,1);
                break;
            case 2://向左
                launch = new Launch(getX(),getY() + 20,2);
                break;
            case 3://向右
                launch = new Launch(getX() + 60,getY() + 20,3);
        }
//        if (count < 5){
            launches.add(launch);
//            count ++;
//        }

        new Thread(launch).start();
    }


}
