package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.AccountEntity;

@Repository
public class AccountDAOImpl
        extends SimpleAbstractGenericDAO<AccountEntity>
        implements AccountDAO {

}
