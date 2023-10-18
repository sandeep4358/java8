package com.stingray.stream;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String name;
    private int releaseYear;
    private String isbn;
}
