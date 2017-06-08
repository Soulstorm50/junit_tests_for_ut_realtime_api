package unipay.request;

import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;

import java.util.Map;
import java.util.Objects;

/**
 * Sale request container class.
 * <p>
 * Sale request with appropriate entities.
 */
public abstract class SaleRequest {
    protected AuthInfo authInfo;
    protected AccountInfo accountInfo;
    protected TransactionInfo transactionInfo;

    public SaleRequest(AuthInfo authInfo, AccountInfo accountInfo, TransactionInfo transactionInfo) {
        this.authInfo = authInfo;
        this.accountInfo = accountInfo;
        this.transactionInfo = transactionInfo;
    }

    /**
     * Construct Key-Value map from all aggregated entities
     *
     * @return map - all entities as map of key-value
     * @throws IllegalAccessException
     */
    public abstract Map toMap() throws IllegalAccessException;

    public String toGetParamsString() throws IllegalAccessException {
        StringBuilder paramsStr = new StringBuilder();
        Map<Object, Object> map = this.toMap();



        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            paramsStr.append(entry.getKey() + "=" + entry.getValue() + "&");
        }


        if (paramsStr.length() > 0) paramsStr.setLength(paramsStr.length() - 1);

        return paramsStr.toString().replace(" ", "+");
    }
}
