package az.edu.itbrains.blog.dto.article;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDto {
    private String title;
    private String subtitle;
    @Column(length = 10000)
    private String content;
    private String author;
    private LocalDate publishDate;
}
