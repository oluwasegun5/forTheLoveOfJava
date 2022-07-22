package org.myCaller.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myCaller.data.models.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }
    @Test
    void testThatContactHasId(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Gbemisola","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        assertEquals(contact,contactRepository.findBy(1));
        assertEquals(1,contactRepository.findBy(1).getId());
    }

    @Test
    void testThatICanFindById(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Gbemisola","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        assertEquals(contact,contactRepository.findBy(1));
    }

    @Test
    void testThatContactCanBeSaved(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);

        String result = contactRepository.findBy(1).getFirstName();
        assertEquals("Oluwasegun", result);
    }

    @Test
    void testThatContactIncreasesWhenISave(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Gbemisola","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        assertEquals(2,contactRepository.totalContact());
    }

    @Test
    void findByFirstNameTest(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Gbemisola","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        Contact result = contactRepository.findBy(contact.getFirstName()).get(0);
        assertEquals(contact,result);
    }
    @Test
    void findByFirstNameReturnAllContactThatHasNameTest(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Adeayo","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        int result = contactRepository.findBy(contact1.getFirstName()).size();

        assertEquals(2,result);
    }

    @Test
    void findBylastNameReturnAllContactThatHasNameTest(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Adeayo","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        int result = contactRepository.findBy(contact.getLastName()).size();

        assertEquals(2,result);
    }

    @Test
    void deleteTest(){
        var contact = new Contact("Oluwasegun","Adeayo","09012878141");
        contactRepository.saveContact(contact);
        var contact1 = new Contact("Adeayo","Abiodun","1234567890");
        contactRepository.saveContact(contact1);

        contactRepository.delete(contact);
        assertEquals(1,contactRepository.totalContact());
        assertEquals("Adeayo",contactRepository.findBy(1).getFirstName());
    }
}