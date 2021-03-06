package com.github.jozijug.service.querydsl;

/**
 * @author Corneil du Plessis
 */

import com.github.jozijug.jpadomain.Contact;
import com.mysema.query.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static com.github.jozijug.jpadomain.QContact.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Configurable
@ContextConfiguration(classes = {DataSourceConfig.class})
public class QueryDslDataTest {
    @Inject
    ContactRepository contactRepository;

    @Test
    public void testCountCompanyContacts() {
        Predicate p = createContactByCompanyNamePredicate("BBD");
        long count = contactRepository.count(p);
        assertEquals(46, count);
    }

    @Test
    public void testListCompanyContacts() {
        Predicate p = createContactByCompanyNamePredicate("BBD");
        Iterable<Contact> results = contactRepository.findAll(p);
        int count = 0;
        for (Contact contact : results) {
            count += 1;
            System.out.println(contact.toString());
        }
        assertEquals(46, count);
    }

    private Predicate createContactByCompanyNamePredicate(String companyName) {
        return contact.company.name.eq(companyName);
    }
}
