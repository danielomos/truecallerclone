package africa.semicolon.callerapp.data.repositories;

import africa.semicolon.callerapp.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private int counter;
    private List<Contact> contacts = new ArrayList<Contact>();

@Override
public Contact save(Contact contact) {
   if (contact.getId() == 0) {
       counter++;
       contact.setId(counter);
       contacts.add(contact);
   }
   else {
     Contact oldcontact = findById(contact.getId());
     contact.setId(oldcontact.getId());
     contacts.remove(oldcontact);
     contacts.add(contact);

   }
   return contact;
//    var contactToEdit  =findById(contact.getId());
//    if (contactToEdit == null) {
//        counter++;
//        contact.setId  (counter);
//        contacts.add(contact);
//    }
//    else{
//        contactToEdit.setFirstName(contact.getFirstName());
//        contactToEdit.setLastName(contact.getLastName());
//        contactToEdit.setEmail(contact.getEmail());
//        contactToEdit.setPhoneNumber(contact.getPhoneNumber());
//    }
//    return  contact;
}


    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void delete(Contact toDeletecontact) {
    for (Contact contact :  contacts) {
        if(contact.getId() == toDeletecontact.getId()) {
            contacts.remove(contact);
            break;
        }
    }

        }


    @Override
    public void delete(int id) {
      Contact findcontact = findById(id);
                contacts.remove(findcontact);




    }

    @Override
    public Contact findById(int id) {
       for (Contact contact : contacts) {
           if (contact.getId() == id) {
               return contact;
           }
        }
        return null;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
    ArrayList<Contact> contactWithFirstName = new ArrayList<Contact>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName))  {
                contactWithFirstName.add(contact);

            }
        }
        return contactWithFirstName;
    }



    @Override
    public List<Contact> findByLastName(String lastName) {
        ArrayList<Contact> contactWithLastName = new ArrayList<Contact>();
        for (Contact contact : contacts) {
            if (contact.getLastName().equals(lastName))  {
                contactWithLastName.add(contact);

            }
        }
        return contactWithLastName;
    }



    @Override
    public List<Contact> findAll() {
        return contacts;
    }
    @Override
    public int count(){
        return contacts.size();
    }

}
