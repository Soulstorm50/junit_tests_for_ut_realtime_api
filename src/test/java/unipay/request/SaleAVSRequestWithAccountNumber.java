package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;
import unipay.request.component_entities.account.AccountNumber;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Sale request for acc verification with acc number
 *
 * @see SaleRequest
 * @see SaleRequestWithAccountNumber
 */
public class SaleAVSRequestWithAccountNumber extends SaleRequestWithAccountNumber {
    private BillingAddressInfo billingAddressInfo;

    public SaleAVSRequestWithAccountNumber(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountNumber accountNumber, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo, accountNumber);
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
