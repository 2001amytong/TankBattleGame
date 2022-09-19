package com.chamifj.tankedz.Tankgme03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyTank extends Tank  {
    boolean issurvive = true;
    private Launch launch = null;
    public MyTank(int x, int y) {
        super(x, y);
    }

    public Launch getLaunch() {
        return launch;
    }

    public void Shotpress(){//子弹方向控制
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
        new Thread(launch).start();
    }


}
