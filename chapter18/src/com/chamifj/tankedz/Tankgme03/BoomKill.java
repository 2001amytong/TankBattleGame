package com.chamifj.tankedz.Tankgme03;

public class BoomKill {
    int x,y;
    boolean issurvive = true;
    int life;

    public BoomKill(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void Lifeprocesses(){
        while (true){
            if (life <= 0){
                issurvive = false;
                break;
            }
            life--;
        }

    }
}
