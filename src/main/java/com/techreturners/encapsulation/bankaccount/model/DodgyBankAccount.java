package com.techreturners.encapsulation.bankaccount.model;

public class DodgyBankAccount {

    //These variables should all be private to encapsulate variables and prevent direct modification
    public String accountNumber;
    public int accountBalance; //The type best to represent money would probably be bigDecimal rather than int
    public int rewardAmount = 50;

    public DodgyBankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    public void depositAmount(int amount) {
        accountBalance += amount;
        addReward();
    }

    //This is misnamed and would be better called printAccountBalance. Or should return the account balance directly
    public void getAccountBalance() {
        System.out.println("Your account balance is " + accountBalance);
    }

    public void debitAmount (int amount) {
        accountBalance -= amount;
    }

    //This should be private to prevent misuse and stop anyone from adding rewards
    public void addReward() {
        accountBalance += rewardAmount;
    }

}
