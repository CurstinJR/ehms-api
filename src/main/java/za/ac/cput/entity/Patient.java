package za.ac.cput.entity;

import java.util.Objects;

/*
Patient.java
Author: Curstin Rose - 220275408
Date: 5 April 2022
 */
public class Patient
{
    private final Long patientId;
    private final String patientFirstName;
    private final String patientLastname;

    public Patient(Builder builder)
    {
        this.patientId = builder.patientId;
        this.patientFirstName = builder.patientFirstName;
        this.patientLastname = builder.patientLastname;
    }

    public Long getPatientId()
    {
        return patientId;
    }

    public String getPatientFirstName()
    {
        return patientFirstName;
    }

    public String getPatientLastname()
    {
        return patientLastname;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(patientId, patient.patientId)) return false;
        if (!Objects.equals(patientFirstName, patient.patientFirstName))
            return false;
        return Objects.equals(patientLastname, patient.patientLastname);
    }

    @Override
    public int hashCode()
    {
        int result = patientId != null ? patientId.hashCode() : 0;
        result = 31 * result + (patientFirstName != null ? patientFirstName.hashCode() : 0);
        result = 31 * result + (patientLastname != null ? patientLastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastname='" + patientLastname + '\'' +
                '}';
    }

    public static class Builder
    {
        private Long patientId;
        private String patientFirstName;
        private String patientLastname;

        public Builder patientId(Long patientId)
        {
            this.patientId = patientId;
            return this;
        }

        public Builder patientFirstName(String patientFirstName)
        {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public Builder patientLastname(String patientLastname)
        {
            this.patientLastname = patientLastname;
            return this;
        }

        public Patient copy(Patient patient)
        {
            this.patientId = patient.patientId;
            this.patientFirstName = patient.patientFirstName;
            this.patientLastname = patient.patientLastname;

            return patient;
        }

        public Patient build()
        {
            return new Patient(this);
        }
    }
}
