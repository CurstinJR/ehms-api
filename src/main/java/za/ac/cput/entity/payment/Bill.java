package za.ac.cput.entity.payment;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Bill.java
 * Author: Curstin Rose - 220275408
 */
@Entity
@Table(name = "bill")
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private BigDecimal billAmount;
    private String billDescription;
    private LocalDate billDate;

    public Bill(Builder builder) {
        this.billId = builder.billId;
        this.billAmount = builder.billAmount;
        this.billDescription = builder.billDescription;
        this.billDate = builder.billDate;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (!Objects.equals(billId, bill.billId)) return false;
        if (!Objects.equals(billAmount, bill.billAmount)) return false;
        if (!Objects.equals(billDescription, bill.billDescription))
            return false;
        return Objects.equals(billDate, bill.billDate);
    }

    @Override
    public int hashCode() {
        int result = billId != null ? billId.hashCode() : 0;
        result = 31 * result + (billAmount != null ? billAmount.hashCode() : 0);
        result = 31 * result + (billDescription != null ? billDescription.hashCode() : 0);
        result = 31 * result + (billDate != null ? billDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", billAmount=" + billAmount +
                ", billDescription='" + billDescription + '\'' +
                ", billDate=" + billDate +
                '}';
    }

    public static class Builder {
        private Long billId;
        private BigDecimal billAmount;
        private String billDescription;
        private LocalDate billDate;

        public Builder billId(Long billId) {
            this.billId = billId;
            return this;
        }

        public Builder billAmount(BigDecimal billAmount) {
            this.billAmount = billAmount;
            return this;
        }

        public Builder billDescription(String billDescription) {
            this.billDescription = billDescription;
            return this;
        }

        public Builder billDate(LocalDate billDate) {
            this.billDate = billDate;
            return this;
        }

        public Builder copy(Bill bill) {
            this.billId = bill.billId;
            this.billAmount = bill.billAmount;
            this.billDescription = bill.billDescription;
            this.billDate = bill.billDate;

            return this;
        }

        public Bill build() {
            return new Bill(this);
        }
    }
}
