package com.practice.thymeleaf_tutorial.controller;

import com.practice.thymeleaf_tutorial.dto.response.BookResponse;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

  @GetMapping
  public String getBooks(Model model) {
    List<BookResponse> books = createSampleBooks();

    model.addAttribute("books", books);
    model.addAttribute("title", "도서 목록");

    return "books/list";
  }

  @GetMapping("/{id}")
  public String findBook(@PathVariable Long id, Model model) {

    BookResponse book = createSampleBooks().stream()
                                           .filter(b -> b.getId().equals(id))
                                           .findFirst()
                                           .orElse(null);

    if (book == null) {
      model.addAttribute("error", "해당 도서를 찾을 수 없습니다.");
      return "error/404";
    }

    model.addAttribute("book", book);
    model.addAttribute("title", book.getTitle());

    List<BookResponse> relatedBooks = createSampleBooks().stream()
                                                         .filter(
                                                             b -> !b.getId().equals(id)
                                                                 && b.getCategory()
                                                                     .equals(book.getCategory()))
                                                         .limit(3)
                                                         .toList();

    model.addAttribute("relatedBooks", relatedBooks);

    return "books/detail";
  }

  @GetMapping("/syntax-examples")
  public String syntaxExamples(Model model) {
    BookResponse sampleBook = createSampleBooks().get(0);

    List<String> categories = Arrays.asList(
        "프로그래밍", "웹개발", "데이터베이스", "알고리즘",
        "네트워크", "보안", "AI/ML", "모바일", "기타"
    );

    Map<String, String> categoryColors = new HashMap<>();
    categoryColors.put("프로그래밍", "#3498db");
    categoryColors.put("웹개발", "#e74c3c");
    categoryColors.put("데이터베이스", "#2ecc71");
    categoryColors.put("알고리즘", "#f39c12");
    categoryColors.put("네트워크", "#9b59b6");
    categoryColors.put("보안", "#e67e22");
    categoryColors.put("AI/ML", "#1abc9c");
    categoryColors.put("모바일", "#34495e");
    categoryColors.put("기타", "#95a5a6");

    // 다양한 데이터 타입으로 Thymeleaf 표현식 실습
    model.addAttribute("message", "Thymeleaf 문법 실습");
    model.addAttribute("book", sampleBook);
    model.addAttribute("books", createSampleBooks());
    model.addAttribute("today", LocalDate.now());
    model.addAttribute("htmlContent", "<strong>굵은 텍스트</strong>와 <em>기울임 텍스트</em>");
    model.addAttribute("isAdmin", true);
    model.addAttribute("nullValue", null);
    model.addAttribute("emptyString", "");
    model.addAttribute("userName", "관리자");
    model.addAttribute("numbers", Arrays.asList(1, 2, 3, 4, 5));
    model.addAttribute("categories", categories);
    model.addAttribute("categoryColors", categoryColors);

    return "books/syntax-examples";
  }

  private List<BookResponse> createSampleBooks() {

    return Arrays.asList(
        new BookResponse(1L, "클린 코드", "로버트 C. 마틴", "978-89-6626-877-1",
            "인사이트", LocalDate.of(2013, 12, 24), 584, "프로그래밍",
            33000.0, true,
            "애자일 소프트웨어 장인 정신의 창시자 로버트 C. 마틴이 제시하는 클린 코드의 원칙들과 실천 방법을 담은 책입니다.",
            "/images/clean-code.jpg"),

        new BookResponse(2L, "이펙티브 자바", "조슈아 블로크", "978-89-6626-284-7",
            "인사이트", LocalDate.of(2018, 11, 1), 416, "프로그래밍",
            36000.0, false,
            "자바 플랫폼 설계자가 알려주는 자바 프로그래밍 기법과 베스트 프랙티스를 다룬 필독서입니다.",
            "/images/effective-java.jpg"),

        new BookResponse(3L, "스프링 부트와 AWS로 혼자 구현하는 웹 서비스", "이동욱", "978-89-6626-269-4",
            "프리렉", LocalDate.of(2019, 12, 24), 648, "웹개발",
            27000.0, true,
            "스프링 부트와 AWS를 활용하여 웹 서비스를 처음부터 끝까지 혼자서 구현할 수 있도록 도와주는 실무 중심의 가이드북입니다.",
            "/images/spring-aws.jpg"),

        new BookResponse(4L, "자바의 정석", "남궁성", "978-89-94506-94-8",
            "도우출판", LocalDate.of(2022, 8, 10), 1022, "프로그래밍",
            45000.0, true,
            "자바 프로그래밍 언어를 체계적이고 자세하게 학습할 수 있는 자바 학습서의 바이블입니다.",
            "/images/java-jungsuk.jpg"),

        new BookResponse(5L, "토비의 스프링 3.1", "이일민", "978-89-6626-104-8",
            "에이콘출판", LocalDate.of(2012, 3, 30), 1544, "웹개발",
            48000.0, false,
            "스프링 프레임워크의 핵심 개념과 원리를 깊이 있게 다룬 스프링 개발자의 필독서입니다.",
            "/images/toby-spring.jpg")
    );
  }
}
