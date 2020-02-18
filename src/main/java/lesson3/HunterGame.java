package main.java.lesson3;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import com.google.common.collect.HashMultiset;
import javafx.util.Pair;
import main.java.lesson2.PointSort;

import javax.swing.*;

public class HunterGame  extends JFrame implements GameController {
    final static int filedArea=225*100;
    static int a= (int) (Math.sqrt(filedArea)/2);
    private static HashSet<main.java.lesson3.Point> points=new HashSet<>();
    JPanel panel=new JPanel();
    public static void main(String[] args) {
        init();
        long time=System.currentTimeMillis();
        checkByMyMethod();
        System.out.println("time :"+(System.currentTimeMillis()-time));
        time=System.currentTimeMillis();
        checkBySort();
        System.out.println("time :"+(System.currentTimeMillis()-time));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HunterGame();
            }
        });

    }
    private HunterGame(){
        this.setSize((int)Math.sqrt(filedArea),(int)Math.sqrt(filedArea));
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(new Canvas(this));
        this.setVisible(true);
    }
   static public void init(){
        Random random =new Random();
        int size = (int) Math.sqrt(filedArea);
        for (int i = 0; i <10 ; i++) {
            int x=random.nextInt(size);
            int y=random.nextInt(size);
            points.add(new main.java.lesson3.Point(x,y));
        }
    }
    static public void update(){
        main.java.lesson3.Point[] Points=new main.java.lesson3.Point[points.size()];
        points.toArray(Points);
        Arrays.sort(Points,new PointComparator());
        System.out.println(Arrays.toString(Points));
    }
    public static void checkByMyMethod(){
        HashMultiset<Pair<Double,Boolean>> multiset =new HashMultiset<>();
        for (main.java.lesson3.Point p:points){
            //multiset.add(new Pair<>(divide(p.getY(),p.getX()),p.getX()>0));
           // multiset.add(new Pair<>((float)))
            multiset.add(new Pair<>((double)p.getY()/p.getX(),p.getX()>0));
        }
        int max=1;
        System.out.println("Array size :"+multiset.size());
        int iterations=0;
        while (multiset.iterator().hasNext())
        {
            iterations++;
            max= Math.max(multiset.count(multiset.iterator().next()), max);
            multiset.remove(multiset.iterator().next());
        }
        System.out.println("Max:"+max);
        System.out.println("iterations:"+iterations);
        ///Вроде сложность должна быть n*log(n) если мультимножество как в с++

    }
    public static void checkBySort(){
        Point [] array=new Point[points.size()];
        points.toArray(array);
        PointSort sort=new PointSort();
        array=sort.ParallelMergeSort(array);
        Point previous =array[0];
        int max1=1;
        int max=1;
        for (Point p:array){
            if (previous.compareTo(p)==0){
                max++;
                previous=p;
            }
            else{
                max=1;
                previous=p;
            }
            max1=Math.max(max1,max);

        }
        System.out.println("max: "+max1);
    }
    public static float divide(int x,int y){
        if (y==0)return Float.MAX_VALUE;
        return divider(x,y,1,30,0);
    }
    static float divider(int x,int y,int degree,int MaxNumbers_after_0,int after){
        if (after>=MaxNumbers_after_0)return 0;
        float result=x/y;
        int left= (int) ((x%y)*Math.pow(10,degree));
        //Float.sum(result, (float) (divider(x%y,y,++degree,MaxNumbers_after_0,++after)*Math.pow(10,-degree)));
        return Float.sum(result, (float) (divider(left,y,degree+1,MaxNumbers_after_0,++after)*Math.pow(10,-degree)));
    }

    @Override
    public void onDrawFrame(Canvas canvas, Graphics g, Float delta) {
        int a= (int) (Math.sqrt(filedArea)/2);
        g.drawLine(0,a,a*2,a);
        g.drawLine(a,0,a,a*2);
        for (Point point:points){
            g.drawOval(point.getX(),point.getY(),4,4);
        }
    }
}
class PointComparator implements Comparator<main.java.lesson3.Point> {


    @Override
    public int compare(main.java.lesson3.Point o1, main.java.lesson3.Point o2) {
        /*if ((int)(o1.getY()/o1.getX())>
                (int)(o2.getY()/o2.getX())
        )return -1;
        else if ((int)(o1.getY()/o1.getX())<
                    (int)(o2.getY()/o2.getX()))return 1;
        else return 0;*/
        double m1=(double) o1.getY()/o1.getX();
        double m2=(double) o2.getY()/o2.getX();
        if (
                (m1==m2&&o1.getX()>0&&o2.getX()>0)||
                        (m1==m2&&o1.getX()<0&&o2.getX()<0)
        )return 0;
        else if (
                (m1>m2&&o1.getX()>0&&o2.getX()>0)||
                        (m1>m2&&o1.getX()<0&&o2.getX()<0)
        ) return 1;

        else if( (m1<m2&&o1.getX()>0&&o2.getX()>0)||
        (m1<m2&&o1.getX()<0&&o2.getX()<0))return -1;
        else return 3;
    }
}
