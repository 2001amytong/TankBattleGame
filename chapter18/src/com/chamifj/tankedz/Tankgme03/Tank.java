package com.chamifj.tankedz.Tankgme03;

public class Tank {
    private int x;
    private int y;
    private int direction = 0;
    private int speed = 10;

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void moveup(){//向上移动
       y -= speed;
    }
    public void  movedown(){//向下移动
        y += speed;
    }
    public void movelietf(){
        x -= speed;
    }
    public void moveright(){
        x += speed;
    }
}
