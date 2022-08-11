package za.ac.cput.entity.payment;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * MedicalAid.java
 * Author: Curstin Rose - 220275408
 */
@Entity
@Table(name = "medical_aid")
@NoArgsConstructor
public class MedicalAid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long claimId;
    private LocalDate claimDate;
    private String claimType;
    private String medicalAidName;
    private Long medicalAidNo;

    public MedicalAid(Builder builder) {
        this.claimId = builder.claimId;
        this.claimDate = builder.claimDate;
        this.claimType = builder.claimType;
        this.medicalAidName = builder.medicalAidName;
        this.medicalAidNo = builder.medicalAidNo;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public void setMedicalAidName(String medicalAidName) {
        this.medicalAidName = medicalAidName;
    }

    public Long getMedicalAidNo() {
        return medicalAidNo;
    }

    public void setMedicalAidNo(Long medicalAidNo) {
        this.medicalAidNo = medicalAidNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicalAid that = (MedicalAid) o;

        if (!Objects.equals(claimId, that.claimId)) return false;
        if (!Objects.equals(claimDate, that.claimDate)) return false;
        if (!Objects.equals(claimType, that.claimType)) return false;
        if (!Objects.equals(medicalAidName, that.medicalAidName))
            return false;
        return Objects.equals(medicalAidNo, that.medicalAidNo);
    }

    @Override
    public int hashCode() {
        int result = claimId != null ? claimId.hashCode() : 0;
        result = 31 * result + (claimDate != null ? claimDate.hashCode() : 0);
        result = 31 * result + (claimType != null ? claimType.hashCode() : 0);
        result = 31 * result + (medicalAidName != null ? medicalAidName.hashCode() : 0);
        result = 31 * result + (medicalAidNo != null ? medicalAidNo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MedicalAid{" +
                "claimId=" + claimId +
                ", claimDate=" + claimDate +
                ", claimType='" + claimType + '\'' +
                ", medicalAidName='" + medicalAidName + '\'' +
                ", medicalAidNo=" + medicalAidNo +
                '}';
    }

    public static class Builder {
        private Long claimId;
        private LocalDate claimDate;
        private String claimType;
        private String medicalAidName;
        private Long medicalAidNo;

        public Builder claimId(Long claimId) {
            this.claimId = claimId;
            return this;
        }

        public Builder claimDate(LocalDate claimDate) {
            this.claimDate = claimDate;
            return this;
        }

        public Builder claimType(String claimType) {
            this.claimType = claimType;
            return this;
        }

        public Builder medicalAidName(String medicalAidName) {
            this.medicalAidName = medicalAidName;
            return this;
        }

        public Builder medicalAidNo(Long medicalAidNo) {
            this.medicalAidNo = medicalAidNo;
            return this;
        }

        public Builder copy(MedicalAid medicalAid) {
            this.claimId = medicalAid.claimId;
            this.claimDate = medicalAid.claimDate;
            this.claimType = medicalAid.claimType;
            this.medicalAidName = medicalAid.medicalAidName;
            this.medicalAidNo = medicalAid.medicalAidNo;

            return this;
        }

        public MedicalAid build() {
            return new MedicalAid(this);
        }
    }
}
