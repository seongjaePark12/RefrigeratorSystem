package RefrigeratorMemo;

public class RmVO {

	private int idx;          // 번호
	private String name;      // 이름
	private String putdate;   // 유통기한
	private String position;  // 위치(냉장실,냉동실)
	private int num;       // 개수
	private String kind;       // 종류(유제품,육류,수산물,과일(채소),소스류,반찬,그외
	private String memo;   // 메모(사진)
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPutdate() {
		return putdate;
	}
	public void setPutdate(String putdate) {
		this.putdate = putdate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		return "RmVO [idx=" + idx + ", name=" + name + ", putdate=" + putdate + ", position=" + position + ", num="
				+ num + ", kind=" + kind + ", memo=" + memo + "]";
	}
}

