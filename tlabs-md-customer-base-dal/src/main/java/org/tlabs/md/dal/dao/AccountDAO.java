package org.tlabs.md.dal.dao;

import org.tlabs.md.dal.entity.AccountEntity;

import java.util.UUID;

public interface AccountDAO extends SimpleGenericDAO<AccountEntity> {

    public AccountEntity findByActivationCode(UUID activationCode);
}
