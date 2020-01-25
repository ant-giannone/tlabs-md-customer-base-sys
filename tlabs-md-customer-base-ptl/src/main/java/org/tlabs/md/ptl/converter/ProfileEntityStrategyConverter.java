package org.tlabs.md.ptl.converter;

import org.tlabs.md.dal.entity.ProfileEntity;
import org.tlabs.md.ptl.ws.dto.PersonalDataDTO;

import java.util.List;

public class ProfileEntityStrategyConverter
        implements SimpleStrategyConverter<PersonalDataDTO, ProfileEntity> {

    @Override
    public void execute(PersonalDataDTO personalDataDTO, ProfileEntity profileEntity) {

        profileEntity.setName(personalDataDTO.getName());
        profileEntity.setSurname(personalDataDTO.getSurname());
        profileEntity.setBirthDate(personalDataDTO.getBirthDate());
    }

    @Override
    public void execute(PersonalDataDTO personalDataDTO, List<ProfileEntity> target) {

        throw new RuntimeException("Missing implementation");
    }

    @Override
    public void execute(List<PersonalDataDTO> source, List<ProfileEntity> target) {

        throw new RuntimeException("Missing implementation");
    }
}
