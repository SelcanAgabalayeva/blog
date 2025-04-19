package az.edu.itbrains.blog.repository;

import az.edu.itbrains.blog.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {


}
