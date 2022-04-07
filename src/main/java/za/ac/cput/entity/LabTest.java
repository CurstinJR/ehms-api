package za.ac.cput.entity;
/*
LabTest.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 07 April 2022
*/

import java.math.BigDecimal;
import java.util.Date;

public class LabTest {
    private long testId;
    private String testName;
    private Date testSampleDate;
    private BigDecimal testFee;

    private LabTest(Builder builder) {
        this.testId = builder.testId;
        this.testName = builder.testName;
        this.testSampleDate = builder.testSampleDate;
        this.testFee = builder.testFee;
    }
    public long getTestId() {
        return testId;
    }

    public String getTest() {
        return testName;
    }

    public Date getTestSampleDate() {
        return testSampleDate;
    }

    public BigDecimal getTestFee() {
        return testFee;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTestSampleDate(Date testSampleDate) {
        this.testSampleDate = testSampleDate;
    }

    public void setTestFee(BigDecimal testFee) {
        this.testFee = testFee;
    }

    @Override
    public String toString() {
        return "LabTest{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", testSampleDate=" + testSampleDate +
                ", testFee=" + testFee +
                '}';
    }
    public static class Builder {
        private long testId;
        private String testName;
        private Date testSampleDate;
        private BigDecimal testFee;

        public Builder testId(long testId) {
            this.testId = testId;
            return this;
        }
        public Builder testName(String testName) {
            this.testName = testName;
            return this;
        }
        public Builder testSampleDate(Date testSampleDate) {
            this.testSampleDate = testSampleDate;
            return this;
        }
        public Builder testFee(BigDecimal testFee) {
            this.testFee = testFee;
            return this;
        }
        public Builder copy(LabTest lbt) {
            this.testId = lbt.testId;
            this.testName = lbt.testName;
            this.testSampleDate = lbt.testSampleDate;
            this.testFee = lbt.testFee;
            return this;
        }
        public LabTest build() {
            return new LabTest(this);
        }
    }
}
