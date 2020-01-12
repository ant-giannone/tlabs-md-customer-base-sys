package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.DummyEntity;

@Repository
public class DummyDAOImpl
        extends SimpleAbstractGenericDAO<DummyEntity>
        implements DummyDAO {

}
