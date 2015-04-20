package rf.vdolgu.dao;

import rf.vdolgu.model.Contact;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by mil on 20.04.15.
 */

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
    }
}
