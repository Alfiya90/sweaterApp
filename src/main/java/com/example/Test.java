/*
package com.example;

import com.example.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Person> people ;
        int counter = 0;

        {people = new ArrayList<>();
            people.add(new Person(++counter,"Tom"));
            people.add(new Person(++counter,"Ann"));
            people.add(new Person(++counter,"Billy"));
            people.add(new Person(++counter,"Sally"));
            people.add(new Person(++counter,"Bob"));

            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            Person person = null;
            */
/*for (int i = 0;i < people.size()-1; i++){
                if(id == people.get(i).getId()){
                    person = people.get(i);
                }
                *//*
*/
/*return people.stream().filter(person -> person.getId() == id).orElse(null);*//*
*/
/*
            }*//*

            for (int i = 0; i < people.size(); i++) {
                if (id == people.get(i).getId()) {
                    people.remove(id);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Person person1: people){
                sb.append(person1);
            }
            System.out.println(sb.toString());

        }


    }
}
*/
