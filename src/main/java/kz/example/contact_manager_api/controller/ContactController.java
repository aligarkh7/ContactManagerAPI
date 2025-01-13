package kz.example.contact_manager_api.controller;

import jakarta.validation.Valid;
import kz.example.contact_manager_api.model.ContactModel;
import kz.example.contact_manager_api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<String> createNewContact(@Valid @RequestBody ContactModel contactModel){
        if (contactService.createNewContact(contactModel)){
            return new ResponseEntity<>("Контакт создан", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Контакт с таким именем уже существует",HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public List<ContactModel> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/{number}")
    public ContactModel getContactByNumber(@PathVariable String number){
        return contactService.getContactByNumber(number);
    }

    @PutMapping("/{number}")
    public ResponseEntity<String> updateContact(@Valid @RequestBody ContactModel contactModel,
                                                @PathVariable String number){
        if (contactService.updateContact(contactModel,number)){
            return new ResponseEntity<>("Ваш контакт изменен",HttpStatus.OK);
        }
        return new ResponseEntity<>("Контакт с номером " + number + " нет в списке",HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> deleteContactByNumber(@PathVariable String number){
        if (contactService.deleteContactByNumber(number)){
            return new ResponseEntity<>("Контакт с номером: " + number + " удален", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Контакт с номером: " + number + " нет в списке или был удален",HttpStatus.OK);
        }
    }

}
