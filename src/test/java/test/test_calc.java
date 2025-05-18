package test;

import com.aventstack.extentreports.Status;
import org.example.pages.Home_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.lang.reflect.Method;

public class test_calc extends Test_Base {
    Home_Page homePageObject;

    @BeforeMethod
    public void startReport(Method method) {
        testLogger = extent.createTest(method.getName());
    }

    @Test
    public void testAddition() throws InterruptedException {
        testLogger.log(Status.INFO, "بدء اختبار الجمع");
        homePageObject = new Home_Page(driver);
        homePageObject.enter_calc_no("30", "10");
        testLogger.log(Status.INFO, "تم إدخال الأرقام 30 و 10");
        homePageObject.press_add();
        testLogger.log(Status.INFO, "تم الضغط على زر الجمع");
        Thread.sleep(1000);
        String result = homePageObject.getResultText().trim();
        Assert.assertEquals(result, "40", "فشل في نتيجة الجمع");
        testLogger.pass("تم اختبار الجمع بنجاح، النتيجة: " + result);
    }

    @Test
    public void testSubtraction() throws InterruptedException {
        testLogger.log(Status.INFO, "بدء اختبار الطرح");
        homePageObject = new Home_Page(driver);
        homePageObject.enter_calc_no("30", "10");
        testLogger.log(Status.INFO, "تم إدخال الأرقام 30 و 10");
        homePageObject.press_sub();
        testLogger.log(Status.INFO, "تم الضغط على زر الطرح");
        Thread.sleep(1000);
        String result = homePageObject.getResultText().trim();
        Assert.assertEquals(result, "20", "فشل في نتيجة الطرح");
        testLogger.pass("تم اختبار الطرح بنجاح، النتيجة: " + result);
    }

    @Test
    public void testMultiplication() throws InterruptedException {
        testLogger.log(Status.INFO, "بدء اختبار الضرب");
        homePageObject = new Home_Page(driver);
        homePageObject.enter_calc_no("30", "10");
        testLogger.log(Status.INFO, "تم إدخال الأرقام 30 و 10");
        homePageObject.press_multi();
        testLogger.log(Status.INFO, "تم الضغط على زر الضرب");
        Thread.sleep(1000);
        String result = homePageObject.getResultText().trim();
        Assert.assertEquals(result, "300", "فشل في نتيجة الضرب");
        testLogger.pass("تم اختبار الضرب بنجاح، النتيجة: " + result);
    }
}
