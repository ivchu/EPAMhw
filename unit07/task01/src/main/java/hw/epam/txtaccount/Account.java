package hw.epam.txtaccount;


public class Account {
    private int accountId;
    private int amountOfMoney;

    Account(int accountId, int amountOfMoney) {
        this.accountId = accountId;
        this.amountOfMoney = amountOfMoney;
    }

   
    public int getAccountId() {
        return accountId;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != account.accountId) return false;
        return amountOfMoney == account.amountOfMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}
