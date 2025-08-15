package com.practice.thymeleaf_tutorial.dto.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookResponse {

  private Long id;
  private String title;
  private String author;
  private String isbn;
  private String publisher;
  private LocalDate publishDate;
  private Integer pages;
  private String category;
  private Double price;
  private boolean available;
  private String description;
  private String coverImageUrl;

  public String getAvailabilityStatus() {
    return available ? "대출 가능" : "대출 중";
  }

  public String getShortDescription() {
    if (description == null || description.length() <= 100) {
      return description;
    }

    return description.substring(0, 100) + "...";
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", isbn='" + isbn + '\'' +
        ", available=" + available +
        '}';
  }
}
