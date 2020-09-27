package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.stepdefinitions.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src\\test\\resources\\Features\\DBBank.feature" },
        glue = "com.stepdefinitions", 
        strict = true, 
        monochrome = true, 
        dryRun = false,
        		plugin= {"json:src\\test\\resources\\Report\\DigitalBank.json"},
tags = {" not @test1 and @test2"}
)
public class TestRunner {
	@AfterClass
	public static void report() {
		JVMReport.generate(System.getProperty("user.dir")+"\\src\\test\\resources\\Report\\DigitalBank.json");
	}
}
