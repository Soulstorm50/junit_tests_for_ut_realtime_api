package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Sale request for acc verification with account data
 *
 * @see SaleRequest
 * @see SaleRequestWithAccountData
 */
public class SaleAVSRequestWithAccountData extends SaleRequestWithAccountData {
    private BillingAddressInfo billingAddressInfo;

    public SaleAVSRequestWithAccountData(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountData accountData, BillingAddressInfo billingAddressInfo) {
        super(authInfo, accountInfo, transactionInfo, accountData);
        this.billingAddressInfo = billingAddressInfo;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.billingAddressInfo));

        return map;
    }
}
