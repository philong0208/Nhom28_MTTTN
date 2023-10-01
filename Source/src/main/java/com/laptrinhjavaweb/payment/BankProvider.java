package com.laptrinhjavaweb.payment;

import java.util.List;

abstract class BankProvider {
    public abstract List<String> banks();

    public String getBankLogo(String bankId) {
        return bankId;
    }
}
