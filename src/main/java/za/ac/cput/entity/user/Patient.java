package za.ac.cput.entity.user;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Patient.java
 * Author: Curstin Rose - 220275408
 */
@Entity
@Table(name = "patient")
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;
    private String patientName;
    private String patientSurname;

    public Patient(Builder builder) {
        this.patientId = builder.patientId;
        this.patientName = builder.patientName;
        this.patientSurname = builder.patientSurname;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(patientId, patient.patientId)) return false;
        if (!Objects.equals(patientName, patient.patientName))
            return false;
        return Objects.equals(patientSurname, patient.patientSurname);
    }

    @Override
    public int hashCode() {
        int result = patientId != null ? patientId.hashCode() : 0;
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + (patientSurname != null ? patientSurname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                '}';
    }

    public static class Builder {
        private Long patientId;
        private String patientName;
        private String patientSurname;

        public Builder patientId(Long patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder patientName(String patientName) {
            this.patientName = patientName;
            return this;
        }

        public Builder patientSurname(String patientSurname) {
            this.patientSurname = patientSurname;
            return this;
        }

        public Builder copy(Patient patient) {
            this.patientId = patient.patientId;
            this.patientName = patient.patientName;
            this.patientSurname = patient.patientSurname;

            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }
}
