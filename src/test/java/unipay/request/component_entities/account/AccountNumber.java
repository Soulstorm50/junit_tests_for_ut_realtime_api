package unipay.request.component_entities.account;

/**
 * Acc number
 */
public class AccountNumber {
    private String holderName;
    private String accountNumber;
    private String accountAccessory;

    public AccountNumber(String holderName, String accountNumber, String accountAccessory) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.accountAccessory = accountAccessory;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountAccessory() {
        return accountAccessory;
    }

    public void setAccountAccessory(String accountAccessory) {
        this.accountAccessory = accountAccessory;
    }
}
