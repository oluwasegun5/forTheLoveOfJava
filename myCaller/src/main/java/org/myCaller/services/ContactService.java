package org.myCaller.services;

import org.myCaller.data.models.Contact;

import java.util.List;

public interface ContactService {
    public void createContact(String firstName, String lastName, String phoneNumber);
    public List<Contact> find(String contact);
    public void delete(Contact contact);
    public String update(String detail);

}
