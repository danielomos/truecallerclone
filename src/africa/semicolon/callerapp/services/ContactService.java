package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.data.models.Contact;

public interface ContactService {
    Contact saveContact(Contact contact);

    int getNumberOfContacts();

//    Contact addNewContact(Contact contact);
}
