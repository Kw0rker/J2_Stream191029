package ru.gb.jtwo.lone.online.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {

    /*
    * Полностью разобраться с кодом
	* Прочитать методичку к следующему уроку
	* Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
	*  * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
	*  ** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
    * */

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[1000];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }


    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setVisible(true);
        this.addMouseListener(get_game_mouse());
        }

    private void initApplication() {
        for (int i = 0; i < add_remove.auto_generated_balls; i++) {
            sprites[i] = new Ball();
            add_remove.priviousBall_id++;
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        Background.change_color(canvas,System.nanoTime(),System.currentTimeMillis(),System.currentTimeMillis()*0.0001f);
        update(canvas, deltaTime);

        render(canvas, g);
    }
    private MouseListener get_game_mouse(){
          return   new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton()==MouseEvent.BUTTON1)sprites[add_remove.priviousBall_id++]=new Ball(e.getX(),e.getY());
                    else if (e.getButton()==MouseEvent.BUTTON3){
                        System.out.println(e.getX()+" "+e.getY());
                        int id_of_sprite=add_remove.find_sprite_number(e.getX(),e.getY(),sprites);
                        if (id_of_sprite>=0)sprites[id_of_sprite]=null;

                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            };
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i]!=null)sprites[i].update(canvas, deltaTime); }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            if (sprites[i]!=null)sprites[i].render(canvas, g);
        }
    }
}
class add_remove{
 static    int priviousBall_id=0;
 public static final int auto_generated_balls=10;
 public static int find_sprite_number(int x,int y,Sprite sprites[]){
     int nuber=-1;
     for (Sprite sprite:sprites){
         ++nuber;
         if (sprite!=null){
         if (
                 Math.pow((double)(x-sprite.x),2)+Math.pow((double)(y-sprite.y),2)<=Math.pow(sprite.halfHeight,2)
         )return nuber;
     }}
     return nuber;
 }
}
