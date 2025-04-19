package az.edu.itbrains.blog.services.Impls;

import az.edu.itbrains.blog.dto.contact.*;
import az.edu.itbrains.blog.models.Contact;
import az.edu.itbrains.blog.repository.ContactRepository;
import az.edu.itbrains.blog.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setMessage(contactDto.getMessage());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contactRepository.save(contact);
    }

    @Override
    public List<ContactGetAll> getContactsAll() {
        List<ContactGetAll> results=contactRepository.findAll().stream().map(contacts->modelMapper.map(contacts, ContactGetAll.class)).collect(Collectors.toList());
        return results;
    }

    @Override
    public ContactGetIdDto contactGetIdDto(Long id) {
        Contact contact=contactRepository.findById(id).orElseThrow();
        ContactGetIdDto contactGetIdDto=modelMapper.map(contact,ContactGetIdDto.class);
        return contactGetIdDto;
    }

    @Override
    public void createContact(ContactCreateDto contactCreateDto) {
        Contact contact=new Contact();
        contact.setEmail(contactCreateDto.getEmail());
        contact.setName(contactCreateDto.getName());
        contact.setMessage(contactCreateDto.getMessage());
        contact.setPhoneNumber(contactCreateDto.getPhoneNumber());
        contactRepository.save(contact);
    }

    @Override
    public void updateContact(ContactUpdateDto contactUpdateDto, Long id) {
        Contact contact=new Contact();
        contact.setId(contactUpdateDto.getId());
        contact.setEmail(contactUpdateDto.getEmail());
        contact.setName(contactUpdateDto.getName());
        contact.setMessage(contactUpdateDto.getMessage());
        contact.setPhoneNumber(contactUpdateDto.getPhoneNumber());
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        Contact findContact=contactRepository.findById(id).orElseThrow();
        contactRepository.delete(findContact);
    }
}
