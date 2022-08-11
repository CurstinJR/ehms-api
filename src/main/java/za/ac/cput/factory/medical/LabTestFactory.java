package za.ac.cput.factory.medical;

import za.ac.cput.entity.medical.LabTest;
import za.ac.cput.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LabTestFactory {

    public static LabTest createLabTest(Long testId, String testName, LocalDate testSampleDate, BigDecimal testFee) {
        if (Helper.isNull(testId))
            return null;
        if (Helper.isNullorEmpty(testName))
            return null;

        return new LabTest.Builder()
                .testId(testId)
                .testName(testName)
                .testSampleDate(testSampleDate)
                .testFee(testFee)
                .build();

    }

}
