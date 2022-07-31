package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.data.models.Contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceImplTest  {

    @Test
    public void testThatContactIsAddedToService() {
        Contact contact = new Contact();
        ContactServiceImpl contactService = new ContactServiceImpl();
        contactService.saveContact(contact);

        assertEquals(1, contactService.contactRepository.count());

    }

}