package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Igor", "Frolov", 30);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(person);

        Person restoredPerson = gson.fromJson(json, Person.class);

        System.out.println(json);
        System.out.println(restoredPerson);
    }
}
