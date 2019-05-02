package Common;

public class Member {

	private String MNo;
	private String Name;
	private String Family;
	private String Mobile;
	private String Phone;
	private int Age;
	public String getMNo() {
		return MNo;
	}
	public void setMNo(String mNo) {
		MNo = mNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFamily() {
		return Family;
	}
	public void setFamily(String family) {
		Family = family;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	@Override
	public String toString() {
		return "Member [MNo=" + MNo + ", Name=" + Name + ", Family=" + Family + ", Mobile=" + Mobile + ", Phone="
				+ Phone + ", Age=" + Age + "]";
	}

}
