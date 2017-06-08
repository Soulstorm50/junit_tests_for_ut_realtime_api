package unipay.request.component_entities;

/**
 * Transaction Info
 *
 * @see <a href="https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Transaction_Information"></a>
 */
public class TransactionInfo {
    private int amount;
    private String transactionIndustryType;

    public TransactionInfo(int amount, String transactionIndustryType) {
        this.amount = amount;
        this.transactionIndustryType = transactionIndustryType;

    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionIndustryType() {
        return transactionIndustryType;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTransactionIndustryType(String transactionIndustryType) {
        this.transactionIndustryType = transactionIndustryType;
    }

    public void setTransactionOriginCode(String transactionOriginCode) {
    }
}
