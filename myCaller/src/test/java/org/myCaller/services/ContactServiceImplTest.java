package org.myCaller.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myCaller.data.models.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {
    ContactService contactService;
    @BeforeEach
    void setUp(){
        contactService = new ContactServiceImpl();
    }

    @Test
    void addContactTest(){
        contactService.createContact("Oluwasegun","Adeayo","1234567890");

        assertEquals(1,contactService.find("Oluwasegun").get(1).getId());
    }

}