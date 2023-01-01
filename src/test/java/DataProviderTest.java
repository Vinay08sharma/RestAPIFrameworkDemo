import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataProviderTest {

    @Test(dataProvider = "getData")
    public void dataProviderTest(String data, String data2){
        System.out.println("data = " + data);
        System.out.println("data2 = " + data2);
    }

    @Test(dataProvider = "getData1")
    public void dataProviderTest(Map<String,String> data){
        System.out.println("username = " + data.get("username"));
        System.out.println("password = " + data.get("password"));
        System.out.println("email = " + data.get("email"));
    }

    @DataProvider
    public Object[][] getData1(){
        // First[] --> number of times you want to execute
        // Second [] --> number of params to the method
        Object[][] data = new Object[3][1];
        Map<String,String> map = new HashMap<>();
        map.put("username", "abcs");
        map.put("password", "pass");
        map.put("email", "abc@abc.copm");

        Map<String,String> map2 = new HashMap<>();
        map2.put("username", "abc3rqwes");
        map2.put("password", "paszdss");
        map2.put("email", "abc@abawsc.copm");

        Map<String,String> map3 = new HashMap<>();
        map3.put("username", "abasdascs");
        map3.put("password", "pasasds");
        map3.put("email", "abc@abfdffc.copm");

        data[0][0] = map;
        data[1][0] = map2;
        data[2][0] = map3;

        return data;
    }

    @DataProvider
    public Object[][] getData(){
        // First[] --> number of times you want to execute
        // Second [] --> number of params to the method

        return new Object[][] {
            {"abcd", "weasds"},
            {"asdas","wsdee"},
            {"abwqeasdcd", "trrfgr"},
            {"weasd", "rtdfd"}
        };
    }
}
