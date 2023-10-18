package com.stingray.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class java8_map_to_list {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));

//        Map<String,String> map =  listToMapWithDupKeyError(bookList);
//
//        map.forEach((s, s2) -> System.out.println(s+ " :: "+ s2));

 // check the dublicacy of the key


        Map<Integer, Book> bookMap =  listToMapWithDupKeyError(bookList);

        bookMap.forEach((integer, book) -> System.out.println(integer + " :: "+book));

    }

    public static Map<String, String> listToMap(List<Book> books) {
        return books.stream().collect(Collectors.toMap(Book::getIsbn,Book::getName));
    }

    /**
     * The  above example above worked well, but what would happen with a duplicate key?
     *  Let’s imagine that we keyed our Map by each Book‘s release year:
     */
    public static Map<Integer, Book> listToMapWithDupKeyError(List<Book> books) {
        return books.stream().collect(
                Collectors.toMap(Book::getReleaseYear, Function.identity(),(existingValue,newValue)->existingValue));
    }
}
