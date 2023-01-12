package naveenAutomationBrowser;

public enum Browser {

	GOOGLE_CHROME("google"),
	EDGE("edge"),
	FIREFOX("firefox");
	String name;
	Browser(String name){
	this.name=name;
		
	}
	public String getName() {
		return name;
	}
	

}
