package kz.example.contact_manager_api.service;

import kz.example.contact_manager_api.model.ContactModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class ContactServiceImp implements ContactService {

    private static final TreeMap<String, ContactModel> contactMap = new TreeMap<>();

    @Override
    public boolean createNewContact(ContactModel contactModel) {
        if (contactMap.containsKey(contactModel.getNumber())){
            return false;
        }else {
            contactMap.put(contactModel.getNumber(),contactModel);
            return true;
        }
    }

    @Override
    public List<ContactModel> getAllContacts() {
        return new ArrayList<>(contactMap.values());
    }

    @Override
    public ContactModel getContactByNumber(String number) {
        return contactMap.get(number);
    }

    @Override
    public boolean updateContact(ContactModel contactModel, String number) {
        if (contactMap.containsKey(number)){
            contactMap.put(number,contactModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteContactByNumber(String number) {
        if (contactMap.containsKey(number)){
            contactMap.remove(number);
            return true;
        }
        return false;
    }
}
