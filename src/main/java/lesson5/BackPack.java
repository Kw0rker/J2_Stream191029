package main.java.lesson5;

public class BackPack {
    /**
     *
     * @param weight - массив значений веса предметов
     * @param val - массив значений ценности предметов
     * @param w - максимально допустимый вес вещей в рюкзаке
     * @param itemNum - элемент, который мы хотим положить на текущей итерации
     * @return максимально возможная ценность предметов, которые могут поместиться в рюкзаке
     */
    public static int recursive(int[] weight, int[] val, int w, int itemNum) {
        boolean [] possible=new boolean[weight.length];
        possible[0]=true;
        if (w == 0 || itemNum == weight.length) {
            return 0;
        }
       /* if (weight[itemNum] > w) {
            return recursive(weight, val, w,itemNum + 1);
        }*/
        for (int i = 1; i <=weight.length ; i++) {
            for (int j = w-weight[i]; j >=0; j--) {
                possible[j+weight[i]]|=possible[j];

            }

        }
        // TODO вычислить ценность для случаев, когда мы берем и не берем в рюкзак предмет
        // TODO вернуть ценность для случая с наибольшей ценностью
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MathPower.power(2,25));
    }
}
