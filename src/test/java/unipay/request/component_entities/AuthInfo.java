package unipay.request.component_entities;

/**
 * Auth Info
 *
 * @see <a href="https://unidoc.unitedthinkers.com/processing-api/realtime/operations#component_Sale_Request_field_group_Authentication_Information"></a>
 */
public class AuthInfo {
    private String requestType;
    private String userName;
    private String password;
    private String merchantAccountCode;

    public AuthInfo(String requestType, String userName, String password, String merchantAccountCode) {
        this.requestType = requestType;
        this.userName = userName;
        this.password = password;
        this.merchantAccountCode = merchantAccountCode;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMerchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
    }
}
