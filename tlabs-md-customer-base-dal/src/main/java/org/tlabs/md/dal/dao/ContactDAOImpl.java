package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.ContactEntity;

@Repository
public class ContactDAOImpl
        extends SimpleAbstractGenericDAO<ContactEntity>
        implements ContactDAO {
}
