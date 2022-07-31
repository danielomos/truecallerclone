package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.Contact;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class ContactRepositoryImplTest {



    @Test
    public void saveTest() {
        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08099344");
        contact.setFirstName("ajo");
        contact.setLastName("ejo");
        contact.setEmail("test@example.com");
        contactRepository.save(contact);
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void getcontact() {
        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08099344");
        contact.setFirstName("ajo");
        contact.setLastName("ejo");
        contact.setEmail("test@example.com");
        contactRepository.save(contact);
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("08099344");
        contact1.setFirstName("ajo");
        contact1.setLastName("ejo");
        contact1.setEmail("test@example.com");
        contactRepository.save(contact1);

        assertEquals(2, contactRepository.count());
        Contact savedContact = contactRepository.findById(2);
        assertEquals("ajo", savedContact.getFirstName());
    }

    @Test
    public void deletecontact() {
        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08099344");
        contact.setFirstName("ajo");
        contact.setLastName("ejo");
        contact.setEmail("test@example.com");
        contactRepository.save(contact);

        Contact contact1 = new Contact();
        contact1.setPhoneNumber("08099344");
        contact1.setFirstName("ajo");
        contact1.setLastName("ejo");
        contact1.setEmail("test@example.com");
        contactRepository.save(contact1);


        assertEquals(2, contactRepository.count());
        contactRepository.delete(2);
        assertEquals(1, contactRepository.count());
    }
    @Test
    public void updatecontact() {
        ContactRepositoryImpl contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("08099344");
        contact.setFirstName("ajo");
        contact.setLastName("ejo");
        contact.setEmail("test@example.com");
        contactRepository.save(contact);
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("08099344");
        contact1.setFirstName("test");
        contact1.setLastName("dummy");
        contact1.setEmail("test@example.com");
        contactRepository.save(contact1);


        contact.setPhoneNumber("08099344");
        contact.setFirstName("test");
        contact.setLastName("gth");
        contact.setEmail("test@example.com");
        contactRepository.save(contact);
        assertEquals(2, contactRepository.count());
        assertEquals("test", contactRepository.findById(1).getFirstName());
    }


}