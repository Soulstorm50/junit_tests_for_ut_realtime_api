package unipay.request.component_entities.account;

/**
 * Account info
 *
 * @see <a href="https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Account_Information"></a>
 */
public class AccountInfo {
    private String accountType;
    private String csc;

    public AccountInfo(String accountType) {
        this.accountType = accountType;
    }

    public AccountInfo(String accountType, String csc) {
        this.accountType = accountType;
        this.csc = csc;
    }


    public String getAccountType() {
        return accountType;
    }

    public String getCsc() {
        return this.csc;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }
}
