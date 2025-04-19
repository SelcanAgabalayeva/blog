package az.edu.itbrains.blog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    @Column(length = 10000)
    private String content;
    private String author;
    private LocalDate publishDate;


}
