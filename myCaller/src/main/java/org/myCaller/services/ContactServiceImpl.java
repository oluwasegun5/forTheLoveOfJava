package org.myCaller.services;

import org.myCaller.data.models.Contact;
import org.myCaller.data.repositories.ContactRepository;

import java.util.List;

public class ContactServiceImpl implements ContactService{

    ContactRepository contactRepository;
    @Override
    public void createContact(String firstName, String lastName, String phoneNumber) {
        Contact contact =new Contact(firstName, lastName, phoneNumber);
        contactRepository.saveContact(contact);
    }

    @Override
    public List<Contact> find(String contact) {
        return contactRepository.findBy(contact);
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public String update(String detail) {
        return null;
    }
}
