package com.ivan.fintrack.domain;

import java.math.BigDecimal;

public class Account {
    private final String id;
    private final String ownerName;
    private BigDecimal balance;

    public Account(String id, String ownerName, BigDecimal balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be null or negative");
        }
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
    }
}
