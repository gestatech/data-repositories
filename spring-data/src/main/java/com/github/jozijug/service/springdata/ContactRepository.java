package com.github.jozijug.service.springdata;

import com.github.jozijug.jpadomain.Company;
import com.github.jozijug.jpadomain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Page<Contact> findByCompanyAndNameLikeIgnoreCase(Company company, String filter, Pageable pageable);

    public Long countByCompanyAndNameLikeIgnoreCase(Company company, String string);

    public List<Contact> findByCompanyAndNameLikeIgnoreCase(Company company, String string);
}
