package RefrigeratorMemo;

public class RmHwVO {

	private int idx;
	private String mid;
	private String pwd;
	private String HwName;
	private int age;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getHwName() {
		return HwName;
	}
	public void setHwName(String hwName) {
		HwName = hwName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "RmHwVO [idx=" + idx + ", mid=" + mid + ", pwd=" + pwd + ", HwName=" + HwName + ", age=" + age + "]";
	}

	
}
