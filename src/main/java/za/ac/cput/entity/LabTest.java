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
    private String test;
    private Date testSampleDate;
    private BigDecimal testFee;

    private LabTest(Builder builder) {
        this.testId = builder.testId;
        this.test = builder.test;
        this.testSampleDate = builder.testSampleDate;
        this.testFee = builder.testFee;
    }
    public long getTestId() {
        return testId;
    }

    public String getTest() {
        return test;
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

    public void setTest(String test) {
        this.test = test;
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
                ", test='" + test + '\'' +
                ", testSampleDate=" + testSampleDate +
                ", testFee=" + testFee +
                '}';
    }
    public static class Builder {
        private long testId;
        private String test;
        private Date testSampleDate;
        private BigDecimal testFee;

        public Builder TestId(long testId) {
            this.testId = testId;
            return this;
        }
        public Builder Test(String test) {
            this.test = test;
            return this;
        }
        public Builder TestSampleDate(Date testSampleDate) {
            this.testSampleDate = testSampleDate;
            return this;
        }
        public Builder TestFee(BigDecimal testFee) {
            this.testFee = testFee;
            return this;
        }
        public Builder copy(LabTest lbt) {
            this.testId = lbt.testId;
            this.test = lbt.test;
            this.testSampleDate = lbt.testSampleDate;
            this.testFee = lbt.testFee;
            return this;
        }
        public LabTest build() {
            return new LabTest(this);
        }
    }
}
