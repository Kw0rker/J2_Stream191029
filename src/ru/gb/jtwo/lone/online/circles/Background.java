package ru.gb.jtwo.lone.online.circles;

import java.awt.*;

public class Background {
   private static Color color;
 static   float x=1,y=1,z=1;

    public static void change_color(GameCanvas canvas,float nanos,float milis,float secs){
        x=fun(nanos*x);y=fun(milis*y);z=fun(secs*z);


        color=new Color(
                (int)(x*255),
                (int) (y * 255),
                (int)(z*255)
        );
        try {
            Thread.sleep(24);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                canvas.setBackground(color);
            }
        }).start();
    }
    static private float fun(float x){//Y E [0...1] function
     return (float)( Math.sqrt(Math.sin(x)+1)*Math.sqrt(-Math.sin(x)+1));
    }
}
