package za.ac.cput.entity.user;

import lombok.*;

import javax.persistence.*;

/**
 * @Author Curstin Rose - 220275408
 * Patient.java
 * 2022/10/01
 */
@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String patientName;
    private String patientSurname;
}
