package com.api.FinancialControl.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TransactionDTO {
    @NotBlank
    private String movementType;
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotNull
    private double amount;
    private double totalCashEntry;
    private double totalCashOutflow;
    @NotNull
    private LocalDateTime date;

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalCashEntry() {
        return totalCashEntry;
    }

    public void setTotalCashEntry(double totalCashEntry) {
        this.totalCashEntry = getTotalCashEntry() + totalCashEntry;
    }

    public double getTotalCashOutflow() {
        return totalCashOutflow;
    }

    public void setTotalCashOutflow(double totalCashOutflow) {
        this.totalCashOutflow = totalCashOutflow;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
