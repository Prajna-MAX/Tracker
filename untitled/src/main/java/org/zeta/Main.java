package org.zeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<String> names = new ArrayList<>();
        Consumer<String> addName = name -> names.add(name);

        addName.accept("Alice");
        addName.accept("Bob");

        System.out.println(names);  // [Alice, Bob]

    }
}