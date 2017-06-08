package tests_resp_code;

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
public class RespCodeReqTest {
    private int amount;
    private String expectedResponseCodeString;
    private SaleRequest saleRequest;



    public RespCodeReqTest(int amount, String expectedResponseCode) {
        this.amount = amount;
        this.expectedResponseCodeString = "responseCode=" + expectedResponseCode;
        this.saleRequest = new SaleRequestWithAccountNumber(
                new AuthInfo("sale", "test_api_user", "C8v20gAdHjig3LMRWGhm5PK1G00v08V1", "2001"),
                new AccountInfo("R"),
                new TransactionInfo(this.amount, "RE"),
                new AccountNumber("John Smith", "4111111111111111", "0422")
        );
    }



    @Test(timeout = 6000)
    public void testResponseCode() {
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
                {500, "A01"}, {4000, "A01"}, {6999, "A01"},
                {12000, "D03"}, {12500, "D03"}, {12999, "D03"},
        });
    }
}