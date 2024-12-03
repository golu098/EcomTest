package com.shiv.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCode {

    @Test(dataProvider="data",dataProviderClass = example.class)
    public void userInput(String userName,String Password){
        System.out.println("usernname :- "+userName+" and Password:-  "+Password);
    }
}
class example{
    @DataProvider(name="data")
    public static Object[][] valuesMethod(){
        return new Object[][]{
                {"shiv","kant"},
                {"a","b"},
                {"c","d"}
        };
    }
}
