package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.ProfileEntity;

@Repository
public class ProfileDAOImpl
        extends SimpleAbstractGenericDAO<ProfileEntity>
        implements ProfileDAO {
}
