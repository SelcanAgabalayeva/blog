package az.edu.itbrains.blog.services;

import az.edu.itbrains.blog.dto.contact.*;

import java.util.List;

public interface ContactService {
    void addContact(ContactDto contactDto);
    List<ContactGetAll> getContactsAll();
    ContactGetIdDto contactGetIdDto(Long id);
    void createContact(ContactCreateDto contactCreateDto);
    void updateContact(ContactUpdateDto contactUpdateDto, Long id);
    void deleteContact(Long id);
}
