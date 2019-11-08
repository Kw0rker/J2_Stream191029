package ru.gb.jtwo.lone.online.lesson3;

public class Person extends Object {
    private  String last_name,phone,email;

    public Person(String last_name, String phone, String email) {
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {

        if( (String)obj==this.getLast_name())System.out.println(this.getPhone());
        return false;
    }
}
