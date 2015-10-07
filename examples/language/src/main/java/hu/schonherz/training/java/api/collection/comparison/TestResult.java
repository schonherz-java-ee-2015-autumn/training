package hu.schonherz.training.java.api.collection.comparison;

public class TestResult {

	private String clazz;
	private Long init;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Long getInit() {
		return init;
	}

	public void setInit(Long init) {
		this.init = init;
	}

	@Override
	public String toString() {
		return "TestResult [clazz=" + clazz + ", init=" + init + "]";
	}

}
