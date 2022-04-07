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
}
