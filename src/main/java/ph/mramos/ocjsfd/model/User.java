package ph.mramos.ocjsfd.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

public class User {

	@NotNull(groups = { Default.class, Group1.class })
	@Size(min = 1, groups = { Default.class, Group1.class })
	private String username;

	@Size(min = 3, max = 6, groups = { Default.class, Group1.class })
	private String name;

	@NotNull(groups = { Default.class, Group2.class })
	@Min(value = 18, groups = { Default.class, Group2.class })
	@Max(value = 30, groups = { Default.class, Group2.class })
	private Integer age;

	@NotNull(groups = { Default.class, Group2.class })
	@DecimalMin(value = "15000.50", groups = { Default.class, Group2.class })
	@DecimalMax(value = "30000.50", groups = { Default.class, Group2.class })
	private Double salary;

	@Pattern(regexp = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", groups = Default.class)
	private String ipAddress;

	public User() {
		super();
	}

	public User(String username) {
		this.username = username;
	}
	
	public User(String username, String name, Integer age, Double salary, String ipAddress) {
		this.username = username;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return String.format("User [username=%s, name=%s, age=%s, salary=%s, ipAddress=%s]", username, name, age,
				salary, ipAddress);
	}

}
