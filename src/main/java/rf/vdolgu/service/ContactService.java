package rf.vdolgu.service;

import java.util.List;

import rf.vdolgu.model.Contact;

/**
 * Created by mil on 20.04.15.
 */
public interface ContactService {
    public void addContact(Contact contact);

    public List<Contact> listContact();

    public void removeContact(Integer id);
}
