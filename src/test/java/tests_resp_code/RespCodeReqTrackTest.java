package tests_resp_code;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import unipay.request.SaleRequest;
import unipay.request.SaleRequestWithAccountData;
import unipay.request.component_entities.AuthInfo;
import unipay.request.component_entities.TransactionInfo;
import unipay.request.component_entities.account.AccountData;
import unipay.request.component_entities.account.AccountInfo;
import utils.HttpRequest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class RespCodeReqTrackTest {
    private int amount;
    private String expectedResponseCodeString;
    private SaleRequest saleRequest;



    public RespCodeReqTrackTest(int amount, String expectedResponseCode) {
        this.amount = amount;
        this.expectedResponseCodeString = "responseCode=" + expectedResponseCode;
        this.saleRequest = new SaleRequestWithAccountData(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountData("%25B4111111111111111%5ESMITH%2FJOHN%5E22041011000%201111A123456789012%3F")
        );
    }



    @Test(timeout = 6000)
    public void testCreateTestDataSuite() {
        try {
            String REQUEST_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?" + this.saleRequest.toGetParamsString();
            String response = HttpRequest.sendGet(REQUEST_URL);


            System.out.printf("\r\nSend sale request with accountNumber and amount %d to URL:\r\n%s\r\nResponse: %s\r\n", this.amount, REQUEST_URL, response);
            assertTrue("Expect " + expectedResponseCodeString, response.contains(expectedResponseCodeString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {7000, "D05"}, {7500, "D05"}, {7999, "D05"},
                {13000, "E02"}, {13500, "E02"}, {13999, "E02"},
        });
    }
}
