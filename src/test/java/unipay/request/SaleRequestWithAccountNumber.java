package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;
import unipay.request.component_entities.account.AccountNumber;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Sale request with acc data
 *
 * @see SaleRequest
 */
public class SaleRequestWithAccountNumber extends SaleRequest {
    protected AccountNumber accountNumber;

    public SaleRequestWithAccountNumber(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountNumber accountNumber) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountNumber = accountNumber;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountNumber));

        return map;
    }
}

