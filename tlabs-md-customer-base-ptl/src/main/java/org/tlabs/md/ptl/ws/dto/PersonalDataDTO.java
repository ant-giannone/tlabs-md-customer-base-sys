package org.tlabs.md.ptl.ws.dto;

import org.tlabs.md.ptl.ws.utils.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "personalData")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDataDTO {

    @XmlElement(name="name", required = true)
    private String name;

    @XmlElement(name="surname", required = true)
    private String surname;

    @XmlElement(name="birthDate", required = true)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;


    public PersonalDataDTO() {
    }

    public PersonalDataDTO(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "PersonalDataDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
