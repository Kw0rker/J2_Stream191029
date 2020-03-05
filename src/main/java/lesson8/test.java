package main.java.lesson8;

public class test {
    public static void main(String[] args) {
        HashTable<String >table=new HashTable<>(10000);
        table.add("Petya");
        table.add("Fedor");
        System.out.println(table);
        System.out.println(table.contains("Petya"));
        table.remove("Petya");
        System.out.println(table.contains("Petya"));
    }
}
