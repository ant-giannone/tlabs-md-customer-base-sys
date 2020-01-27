package org.tlabs.md.dal.dao;

import org.springframework.stereotype.Repository;
import org.tlabs.md.dal.entity.AccountEntity;

import javax.persistence.TypedQuery;
import java.util.UUID;

@Repository
public class AccountDAOImpl
        extends SimpleAbstractGenericDAO<AccountEntity>
        implements AccountDAO {

    @Override
    public AccountEntity findByActivationCode(UUID activationCode) {

        TypedQuery<AccountEntity> findByActivationCodeQ = getEntityManager().createQuery(
                "select account from AccountEntity account where account.activationCode = :activationCode",
                AccountEntity.class);

        findByActivationCodeQ.setParameter("activationCode", activationCode);

        return findByActivationCodeQ.getSingleResult();
    }

    @Override
    public AccountEntity findByUsername(String username) {

        TypedQuery<AccountEntity> findByCredentialQ = getEntityManager().createQuery(
                "select account from AccountEntity account where account.username = :username",
                AccountEntity.class);

        findByCredentialQ.setParameter("username", username);

        return findByCredentialQ.getSingleResult();
    }
}
