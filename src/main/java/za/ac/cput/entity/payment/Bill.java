package za.ac.cput.entity.payment;

import lombok.*;
import za.ac.cput.entity.user.Patient;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author Curstin Rose - 220275408
 * Bill.java
 * 2022/10/01
 */
@Entity
@Table(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
