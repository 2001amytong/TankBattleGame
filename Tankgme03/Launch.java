package com.chamifj.tankedz.Tankgme03;

public class Launch implements Runnable{
    private int x;
    private int y;
    private int direction;
    private int speed = 2;
  boolean issurvive = true;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Launch(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {

        while (true){
            if (!(x >= 0&&x<=1000&&y>=0&&y<=750)){
                issurvive = false;
                break;
        }
            switch (direction){
                case 0://向上发射
                    y -= speed;
                    break;
                case 1://向下发射
                    y += speed;
                    break;
                case 2://向左
                    x -= speed;
                    break;
                case 3://香油
                    x += speed;
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子弹 x 坐标：" + x + " y 坐标：" + y);
        }

    }
}
