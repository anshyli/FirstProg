package inheritanceapp;

public final class Software extends Product {
	private String version;
	private String programmer;
	private String platform;   //linux, mac, or pc
	private String os;
	
	public Software() {
		super();
//		count++;	
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String whoAmI() {
		return "I am a software. \n";
	}
	
	@Override 
	public boolean equals(Object o) {
			Software anObj = (Software) o;
			if (this.programmer.equals(anObj.programmer) &&
				version.equals(anObj.version) &&
				super.equals(anObj)) {
				return true;
			}
			else {
				return false;
			}
	}
	@Override
	public String toString() {
		return super.toString() + "Version:		" + version + "\n";
	}
}
