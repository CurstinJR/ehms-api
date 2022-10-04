package za.ac.cput.entity.user;

import lombok.*;

import javax.persistence.*;

/*
LoginCredentials.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 07 April 2022
*/
@Entity
@Table(name = "login_credentials")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LoginCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

