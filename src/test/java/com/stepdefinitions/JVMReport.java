package com.stepdefinitions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport {
	public static void generate(String jsonLoc) {

		Configuration con = new Configuration(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\"),
				"CucumberDigitalBankDemo");
		con.addClassifications("Group", "Aqua");
		con.addClassifications("Browser", "Chrome");
		con.addClassifications("Browser Version", "V85");
		con.addClassifications("OS:", "Windows10");
		List<String> l = new ArrayList<String>();
		l.add(jsonLoc);
		ReportBuilder builder = new ReportBuilder(l, con);
		builder.generateReports();
	}
}
