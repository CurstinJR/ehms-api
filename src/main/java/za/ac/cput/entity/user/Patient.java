package za.ac.cput.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import za.ac.cput.entity.medical.Vitals;

import javax.persistence.*;

/**
 * @Author Curstin Rose - 220275408
 * Patient.java
 * 2022/10/01
 */
@Entity
@Table(name = "patient")
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class Patient extends BaseUser {
}
