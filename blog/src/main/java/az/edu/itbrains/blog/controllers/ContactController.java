package az.edu.itbrains.blog.controllers;

import az.edu.itbrains.blog.dto.contact.*;
import az.edu.itbrains.blog.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @PostMapping("/contact")
    public String addContact(@ModelAttribute("contact")ContactDto contactDto){
        contactService.addContact(contactDto);
        return "redirect:/";
    }
    @GetMapping("/admin/contact")
    public String getContactAll(Model model){
        List<ContactGetAll> allContact=contactService.getContactsAll();
        model.addAttribute("contacts",allContact);
        return "/dashboard/contact/index.html";
    }
    @GetMapping("/admin/contact/create")
    public String getContactCreate(Model model){
        return "/dashboard/contact/create.html";
    }
    @PostMapping("/admin/contact/create")
    public String getContactCreate(@ModelAttribute("contact") ContactCreateDto contactCreateDto) {
        contactService.createContact(contactCreateDto);
        return "redirect:/admin/contact";

    }
    @GetMapping("/admin/contact/update/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model) {
        ContactGetIdDto contactGetIdDto = contactService.contactGetIdDto(id);
        model.addAttribute("contact", contactGetIdDto);
        return "/dashboard/contact/update";
    }

    @PostMapping("/admin/contact/update/{id}")
    public String updateContact(@ModelAttribute ContactUpdateDto contactUpdateDto, @PathVariable("id") Long id) {
        contactService.updateContact(contactUpdateDto,id);
        return "redirect:/admin/contact";

    }
    @GetMapping("/admin/contact/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        return "/dashboard/contact/delete";
    }
    @PostMapping("/admin/contact/delete/{id}")
    public String removeContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/admin/contact";

    }
}
