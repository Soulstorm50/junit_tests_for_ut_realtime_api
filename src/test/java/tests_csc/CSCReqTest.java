package tests_csc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleRequest;
import unipay.request.SaleRequestWithAccountNumber;
import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountInfo;
import unipay.request.component_entities.account.AccountNumber;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CSCReqTest {
    private String cscCode;
    private String expectedCscResponseCodeString;
    private SaleRequest saleRequest;



    public CSCReqTest(String cscCode, String expectedCscResponseCode ) {
        this.cscCode = cscCode;
        this.expectedCscResponseCodeString = "cscResponseCode=" + expectedCscResponseCode ;
        this.saleRequest = new SaleRequestWithAccountNumber(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R", this.cscCode),
                new TransactionInfo(5000, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422")
        );
    }



    @Test(timeout = 6000)
    public void testCSCRequest() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);

            System.out.printf("\r\nSend sale request with accountNumber and csc code %s to URL:\r\n%s\r\nResponse: %s\r\n", this.cscCode, REQUEST_URL, response);
            assertTrue("Expect " + expectedCscResponseCodeString, response.contains(expectedCscResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"111", "M"}, {"222", "N"}
        });
    }
}
