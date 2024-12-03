package com.shiv.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionCode {

    @Test
    public void softAssertMethod(){
        SoftAssert softAssert=new SoftAssert();
        boolean condition=6<3;
        Object a=null;
        softAssert.assertEquals(1,2,"not equals");
        softAssert.assertTrue(condition,"Passed");
        softAssert.assertNull(a,"Not null");
        softAssert.assertAll();
    }

}
