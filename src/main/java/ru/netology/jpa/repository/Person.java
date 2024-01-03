package ru.netology.jpa.repository;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "surname", "age"})
})
public class Person implements Serializable {
    @EmbeddedId
    PersonId personId;

    @Column(name = "phone_number", length = 10)
    private String phone_number;

    @Column(name = "city_of_living", nullable = false, length = 60)
    private String city_of_living;

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + personId.getName() + '\'' +
                ", surname='" + personId.getSurname() + '\'' +
                ", age=" + personId.getAge() +
                ", contact=" + phone_number +
                ", city=" + city_of_living +
                '}';

    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
class PersonId implements Serializable {
    private String name;
    private String surname;
    private Short age;

}
