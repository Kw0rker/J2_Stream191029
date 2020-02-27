package main.java.lesson5;

public class MathPower {
    public static long power(int a,int power){
        if (power==0)return 1;
        else if (power ==1)return a;

        if (power%2!=0){
            return power(a,power/2+1)*power(a,power/2);
        }
        else {
            power/=2;
        return power(a,power)*power(a,power);
        }
    }
}
