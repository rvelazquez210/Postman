package mapeo;

public class Universities {
	
	private String[] web_pages;
	private String country;
	private String stateProvince;
	private String[] domains;
	private String name;
	private String alpha_two_code;
		
	public Universities (String[] web_pages, String country, String stateProvince, String[] domains, String name, String code) {
			this.web_pages = web_pages;
			this.country = country;
			this.stateProvince = stateProvince;
			this.domains = domains;
			this.name = name;
			this.name = code;			
	}

	public String[] getWeb_pages() {
		return web_pages;
	}

	public void setWeb_pages(String[] web_pages) {
		this.web_pages = web_pages;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String[] getDomains() {
		return domains;
	}

	public void setDomains(String[] domains) {
		this.domains = domains;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha_two_code() {
		return alpha_two_code;
	}

	public void setAlpha_two_code(String alpha_two_code) {
		this.alpha_two_code = alpha_two_code;
	}

	
	
}
