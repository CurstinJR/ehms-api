package za.ac.cput.entity.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Author Curstin Rose - 220275408
 * BaseUser.java
 * 2022/10/03
 */
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Getter
@ToString
@EqualsAndHashCode
public abstract class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
