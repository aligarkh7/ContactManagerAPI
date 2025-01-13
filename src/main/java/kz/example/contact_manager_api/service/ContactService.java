package kz.example.contact_manager_api.service;

import kz.example.contact_manager_api.model.ContactModel;

import java.util.List;

public interface ContactService {
    boolean createNewContact(ContactModel contactModel);
    List<ContactModel> getAllContacts();
    ContactModel getContactByNumber(String number);
    boolean updateContact(ContactModel contactModel, String number);
    boolean deleteContactByNumber(String number);
}
