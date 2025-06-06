package az.edu.itbrains.blog.dto.article;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateDto {
    private Long id;
    private String title;
    private String subtitle;
    @Column(length = 10000)
    private String content;
    private String author;
    private LocalDate publishDate;
}
