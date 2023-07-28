package com.cs.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {};
	
	private static final String REPORT_PATH = System.getProperty("user.dir")+"/src/test/resources/report/index_"+ System.currentTimeMillis()  + ".html";

	public static String getReportPath() {
		return REPORT_PATH;
	}
	
}
