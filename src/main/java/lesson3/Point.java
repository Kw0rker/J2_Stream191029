package main.java.lesson3;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public String toString() {
        if (x==0) return "M behavior is infinite\n";
        float m=Math.floorDiv(y,x);
        return x+","+y+"    M behavior:"+m+"\n";
    }

    @Override
    public int compareTo(Point o2) {
        /*if ((int)(o1.getY()/o1.getX())>
                (int)(o2.getY()/o2.getX())
        )return -1;
        else if ((int)(o1.getY()/o1.getX())<
                    (int)(o2.getY()/o2.getX()))return 1;
        else return 0;*/
            double m1=(double) this.getY()/this.getX();
            double m2=(double) o2.getY()/o2.getX();
            if (
                    (m1==m2&&this.getX()>0&&o2.getX()>0)||
                            (m1==m2&&this.getX()<0&&o2.getX()<0)
            )return 0;
            else if (
                    (m1>m2&&this.getX()>0&&o2.getX()>0)||
                            (m1>m2&&this.getX()<0&&o2.getX()<0)
            ) return 1;

            else if( (m1<m2&&this.getX()>0&&o2.getX()>0)||
                    (m1<m2&&this.getX()<0&&o2.getX()<0))return -1;
            else return Integer.MAX_VALUE;
        }

}
