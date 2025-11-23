import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchKeywordTest {
  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();
    articles.add(new Article(1, "안녕하세요.", "반갑습니다."));
    articles.add(new Article(2, "제목ㅎㅎㅎ", "코딩을 말이야.."));
    articles.add(new Article(3, "자바 입니까?", "반가워"));

    String q = "ㅎㅎㅎ";

    // contains() : 문자열 포함 여부 확인
    List<Article> filteredArticles = articles.stream()
        .filter(article -> article.getTitle().contains(q))
        .collect(Collectors.toList());

    System.out.println(filteredArticles);
  }
}

@AllArgsConstructor
@Getter
@ToString
class Article {
  int id;
  String title;
  String content;
}
