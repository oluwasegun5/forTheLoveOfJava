package org.myCaller.data.repositories;

import org.myCaller.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    public void saveContact(Contact contact);
    public List<Contact> findBy(String details);
    public Contact findBy(int id);
    public void delete(Contact contact);
    public int totalContact();
}
