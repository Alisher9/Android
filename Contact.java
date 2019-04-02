package com.example.empty.myapplication;

import java.util.Comparator;

public class Contact {
    private String name = "";
    private String phone_number = "";
    private int image = 0;

    public Contact(String name, String phone_number, int image) {
        this.name = name;
        this.phone_number = phone_number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return name;
    }
    public static Comparator<Contact> StuNameComparator = new Comparator<Contact>() {

        @Override
        public int compare(Contact o1, Contact o2) {
            String StudentName1 = o1.getName().toUpperCase();
            String StudentName2 = o2.getName().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);
        }


    };

}
