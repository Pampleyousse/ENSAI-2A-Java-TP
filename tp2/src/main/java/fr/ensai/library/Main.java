package fr.ensai.library;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        Magazine magazine1 = new Magazine("Tech Today", 2025, 101, "1234-5678", 50);

        System.out.println(fellowshipOfTheRing.toString());
        System.out.println(magazine1.toString());

        Library yuz_library = new Library("yuz_library", new ArrayList<Item>());
        yuz_library.loadBooksFromCSV("books.csv");
        yuz_library.addItem(magazine1);
        yuz_library.displayItems();

    }
}