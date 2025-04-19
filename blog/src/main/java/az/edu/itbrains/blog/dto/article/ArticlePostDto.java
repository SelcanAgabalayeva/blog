package az.edu.itbrains.blog.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePostDto {
    private Long id;
    private String content;

}
