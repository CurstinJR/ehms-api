package za.ac.cput.entity.user;

import lombok.*;

import javax.persistence.*;

/*
Employee.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */
@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
