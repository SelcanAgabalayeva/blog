package az.edu.itbrains.blog.dto.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String message;
}
