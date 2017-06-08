package tests_avs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleAVSRequestWithAccountData;
import unipay.request.SaleRequest;
import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AVSReqTrackTest {
    private String zipCode;
    private String expectedAvsResponseCodeString;
    private SaleRequest saleRequest;



    public AVSReqTrackTest(String zipCode, String expectedAvsResponseCode) {
        this.zipCode = zipCode;
        this.expectedAvsResponseCodeString = "avsResponseCode=" + expectedAvsResponseCode;
        this.saleRequest = new SaleAVSRequestWithAccountData(
                new AuthInfo("account-verification", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(5000, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F"),
                new BillingAddressInfo(this.zipCode)
        );
    }




    @Test(timeout = 6000)
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            System.out.printf("\r\nSend AVS request with accountData and zipCode %s to URL:\r\n%s\r\nResponse: %s\r\n", this.zipCode, REQUEST_URL, response);
            assertTrue("Expect " + expectedAvsResponseCodeString, response.contains(expectedAvsResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"33333", "43"},
                {"44444", "40"}
        });
    }
}
