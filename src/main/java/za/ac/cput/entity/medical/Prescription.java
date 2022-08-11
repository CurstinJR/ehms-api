package za.ac.cput.entity.medical;

/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
public class Prescription {
    private final Long prescriptionNumber;
    private final String name;
    private final double bigDecimal;
    private final String description;
    private final String type;

    public Prescription(Builder builder) {
        this.prescriptionNumber = builder.prescriptionNumber;
        this.name = builder.name;
        this.bigDecimal = builder.bigDecimal;
        this.description = builder.description;
        this.type = builder.type;
    }

    public Long getPrescriptionNumber() {
        return prescriptionNumber;
    }

    public String getName() {
        return name;
    }

    public double getBigDecimal() {
        return bigDecimal;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionNumber=" + prescriptionNumber +
                ", name='" + name + '\'' +
                ", bigDecimal=" + bigDecimal +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static class Builder {
        private Long prescriptionNumber;
        private String name;
        private double bigDecimal;
        private String description;
        private String type;

        public Builder setPrescriptionNumber(Long prescriptionNumber) {
            this.prescriptionNumber = prescriptionNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBigDecimal(double bigDecimal) {
            this.bigDecimal = bigDecimal;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }


        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder copy(Prescription prescription) {
            this.prescriptionNumber = prescription.prescriptionNumber;
            this.name = prescription.name;
            this.bigDecimal = prescription.bigDecimal;
            this.description = prescription.description;
            this.type = prescription.type;
            return this;
        }

        public Prescription build() {
            return new Prescription(this);
        }
    }


}
