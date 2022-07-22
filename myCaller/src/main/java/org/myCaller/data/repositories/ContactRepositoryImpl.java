package org.myCaller.data.repositories;

import org.myCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    List<Contact> contacts = new ArrayList<>();

    @Override
    public void saveContact(Contact contact) {
        contacts.add(contact);
        contact.setId(contacts.size());
    }

    @Override
    public List<Contact> findBy(String detail) {
        List<Contact> resultContacts = new ArrayList<>();
        for (var contact : contacts) {
            boolean resultIsTrue = contact.getFirstName().equals(detail) || contact.getLastName().equals(detail) || contact.getPhoneNumber().equals(detail);
            if(resultIsTrue)resultContacts.add(contact);
        }
        return resultContacts;
    }

    @Override
    public Contact findBy(int id) {
        return contacts.get(id-1);
    }

    @Override
    public void delete(Contact contact) {
        for (var theContant:contacts){
            if (contact.equals(theContant))contacts.remove(contact);
        }
    }

    @Override
    public int totalContact() {
        return contacts.size();
    }
}
