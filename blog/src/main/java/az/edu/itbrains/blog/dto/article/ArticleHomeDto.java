package az.edu.itbrains.blog.dto.article;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleHomeDto {

    private Long id;
    private String title;
    private String subtitle;
    private String author;
    private LocalDate publishDate;

}
