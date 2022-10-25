package za.ac.cput.entity.user;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
