package org.tlabs.md.ptl.converter;

import org.tlabs.md.dal.entity.ContactEntity;
import org.tlabs.md.dal.entity.ContactType;
import org.tlabs.md.ptl.ws.dto.PersonalContactDTO;

import java.util.List;

public class ContactEntityStrategyConverter
        implements SimpleStrategyConverter<PersonalContactDTO, ContactEntity> {

    @Override
    public void execute(PersonalContactDTO personalContactDTO, ContactEntity contactEntity) {

        throw new RuntimeException("Missing implementation");
    }

    @Override
    public void execute(PersonalContactDTO personalContactDTO, List<ContactEntity> target) {

        if(personalContactDTO.getEmailAddress()!=null &&
                !personalContactDTO.getEmailAddress().isEmpty()) {

            ContactEntity contactEmailEntity = new ContactEntity();
            contactEmailEntity.setContact(personalContactDTO.getEmailAddress());
            contactEmailEntity.setContactType(ContactType.EMAIL);

            target.add(contactEmailEntity);
        }

        if(personalContactDTO.getMobilePhoneNumber()!=null &&
                !personalContactDTO.getMobilePhoneNumber().isEmpty()) {

            ContactEntity contactMobileEntity = new ContactEntity();
            contactMobileEntity.setContact(personalContactDTO.getMobilePhoneNumber());
            contactMobileEntity.setContactType(ContactType.MOBILE);

            target.add(contactMobileEntity);
        }
    }

    @Override
    public void execute(List<PersonalContactDTO> source, List<ContactEntity> target) {

        throw new RuntimeException("Missing implementation");
    }
}
