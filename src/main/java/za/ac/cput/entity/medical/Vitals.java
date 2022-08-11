package za.ac.cput.entity.medical;

/*
Vitals.java
Author: Tarren-Marc Adams - 214041794
Date: 7 April 2022
 */

public class Vitals {
    private Long vitalsId;
    private Double weight;
    private Double height;
    private String bloodPressure;
    private Double temperature;

    private Vitals(Builder builder) {
        this.vitalsId = builder.vitalsId;
        this.weight = builder.weight;
        this.height = builder.height;
        this.bloodPressure = builder.bloodPressure;
        this.temperature = builder.temperature;
    }

    public Long getVitalsId() {
        return vitalsId;
    }

    public void setVitalsId(Long vitalsId) {
        this.vitalsId = vitalsId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Vitals{" +
                "vitalsId=" + vitalsId +
                ", weight=" + weight +
                ", height=" + height +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public static class Builder {
        private Long vitalsId;
        private Double weight;
        private Double height;
        private String bloodPressure;
        private Double temperature;

        public Builder vitalsId(Long vitalsId) {
            this.vitalsId = vitalsId;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder height(Double height) {
            this.height = height;
            return this;
        }

        public Builder bloodPressure(String bloodPressure) {
            this.bloodPressure = bloodPressure;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder copy(Vitals vitals) {
            this.vitalsId = vitals.vitalsId;
            this.weight = vitals.weight;
            this.height = vitals.height;
            this.bloodPressure = vitals.bloodPressure;
            this.temperature = vitals.temperature;
            return this;
        }

        public Vitals build() {
            return new Vitals(this);
        }
    }
}
