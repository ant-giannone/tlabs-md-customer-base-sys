package org.tlabs.md.ptl.converter;

import org.tlabs.md.dal.entity.AccountEntity;
import org.tlabs.md.ptl.ws.dto.PersonalCredentialDTO;

import java.util.List;

public class CredentialEntityStrategyConverter
        implements SimpleStrategyConverter<PersonalCredentialDTO, AccountEntity> {

    @Override
    public void execute(PersonalCredentialDTO personalCredentialDTO, AccountEntity accountEntity) {
        accountEntity.setUsername(personalCredentialDTO.getUsername());
        accountEntity.setPassword(personalCredentialDTO.getPassword());
    }

    @Override
    public void execute(PersonalCredentialDTO personalCredentialDTO, List<AccountEntity> target) {

        throw new RuntimeException("Missing implementation");
    }

    @Override
    public void execute(List<PersonalCredentialDTO> source, List<AccountEntity> target) {

        throw new RuntimeException("Missing implementation");
    }
}
