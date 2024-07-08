package com.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.Resources.ExtendReportsNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtendReportsNG.GetReportsObject();
    @Override
    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.log(Status.PASS, "Test Passed Successfully");

    }

    @Override
    public void onTestFailure(ITestResult result){
        test.fail(result.getThrowable());
        try {
            page = (WebDriver) result.getTestClass().getRealClass().getField("page").get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String filePath = null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(),page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result){

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        // not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        // not implemented
        extent.flush();
    }
}
