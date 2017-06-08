package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.ObjToMapConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Sale request with acc info
 *
 * @see SaleRequest
 */
public class SaleRequestWithAccountData extends SaleRequest {
    protected AccountData accountData;

    public SaleRequestWithAccountData(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo, AccountData accountData) {
        super(authInfo, accountInfo, transactionInfo);
        this.accountData = accountData;
    }

    @Override
    public Map toMap() throws IllegalAccessException {
        Map map = new HashMap();

        map.putAll(ObjToMapConverter.getKeyValueMap(this.authInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.transactionInfo));
        map.putAll(ObjToMapConverter.getKeyValueMap(this.accountData));

        return map;
    }
}
