package az.edu.itbrains.blog.dto.article;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleGetIdDto {
    private Long id;
    private String title;
    private String subtitle;
    @Column(length = 10000)
    private String content;
    private String author;
    private LocalDate publishDate;
}
