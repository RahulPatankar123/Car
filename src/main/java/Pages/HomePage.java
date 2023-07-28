package Pages;

import DriverManager.DriverManager;

public class HomePage {

	public String getHomePageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public String getHomePageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}
}
