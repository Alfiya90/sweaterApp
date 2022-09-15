package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Component;
import java.sql.Connection;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    int counter = 0;
    private  static final String URL = "jdbc:mysql://localhost:3306/people";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@l1990fi";
    private static   Connection connection;


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





    public List<Person> index() {
        List <Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Persons";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        Person person = null;


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Persons WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*for (int i = 0; i < people.size(); i++) {
            if (id == people.get(i).getId()) {
                person = people.get(i);
            }
            *//*return people.stream().filter(person -> person.getId() == id).orElse(null);*//*
        }*/
        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person VALUES(1,?,?,?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*person.setId(++counter);
        people.add(person);*/
    }

    public void update(int id, Person updatePerson) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Persons SET name = ?, ag e= ?, email = ? WHERE id=?");
            preparedStatement.setString(1,updatePerson.getName());
            preparedStatement.setInt(2, updatePerson.getAge());
            preparedStatement.setString(3, updatePerson.getEmail());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());*/
    }

    public void delete(int id) {


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Persons WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*for (int i = 0; i < people.size(); i++) {
            if (id == people.get(i).getId()) {
                people.remove(id);
            }
        }*/
        // people.removeIf(person -> person.getID == id);
    }

}