package africa.semicolon.callerapp.services;

import africa.semicolon.callerapp.data.models.Contact;
import africa.semicolon.callerapp.data.repositories.ContactRepository;
import africa.semicolon.callerapp.dtos.responses.AddContactResponse;
import africa.semicolon.callerapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepository contactRepository;
    AddContactResponse contactResponse = new AddContactResponse();

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactServiceImpl() {

    }

    @Override
    public Contact saveContact(Contact contact) {
       Contact AddNewcontact = new Contact();
        Mapper.map(contact, AddNewcontact);



        contactRepository.save(AddNewcontact);
       // System.out.println(contactResponse.getMessage());
        return AddNewcontact;


    }

    @Override
    public int getNumberOfContacts() {
        return 0;
    }
//
//    @Override
//    public Contact addNewContact(Contact contact) {
//    contactRepository.save(contact);
//    return contact;
//    }
}
