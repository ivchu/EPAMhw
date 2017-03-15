package hw.epam.txtaccount;


public class Account {
    private int accountId;
    private int amountOfMoney;

    Account(int accountId, int amountOfMoney) {
        this.accountId = accountId;
        this.amountOfMoney = amountOfMoney;
    }

    void readInfoFromFile(){

    }

    void writeInfoToFile(){

    }

    public int getAccountId() {
        return accountId;
    }

    private void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
