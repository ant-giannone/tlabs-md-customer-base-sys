package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.AccountEntity;

import javax.persistence.Query;
import java.util.UUID;

@Repository
public class AccountDAOImpl
        extends SimpleAbstractGenericDAO<AccountEntity>
        implements AccountDAO {

    @Override
    public AccountEntity findByActivationCode(UUID activationCode) {

        Query findByActivationCodeQ = getEntityManager().createQuery(
                "select account from AccountEntity account where account.activationCode = :activationCode");

        findByActivationCodeQ.setParameter("activationCode", activationCode);

        return (AccountEntity) findByActivationCodeQ.getSingleResult();
    }
}
