package tests_avs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleAVSRequestWithAccountNumber;
import unipay.request.SaleRequest;
import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.BillingAddressInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;
import unipay.request.component_entities.account.AccountNumber;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AVSReqTest {
    private String zipCode;
    private String expectedAvsResponseCodeString;
    private SaleRequest saleRequest;


    public AVSReqTest(String zipCode, String expectedAvsResponseCode) {
        this.zipCode = zipCode;
        this.expectedAvsResponseCodeString = "avsResponseCode=" + expectedAvsResponseCode;
        this.saleRequest = new SaleAVSRequestWithAccountNumber(
                new AuthInfo("account-verification", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(5000, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422"),
                new BillingAddressInfo(this.zipCode)
        );
    }



    @Test(timeout = 6000)
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            System.out.printf("\r\nSend AVS request with accountNumber and zipCode %s to URL:\r\n%s\r\nResponse: %s\r\n", this.zipCode, REQUEST_URL, response);
            assertTrue("Expect " + expectedAvsResponseCodeString, response.contains(expectedAvsResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"11111", "00"},
                {"22222", "46"}
        });
    }
}
