package fourthLessons.mockTest.pojo;

/**
 * @author sukeqiang
 * @since 2017
 */
public class TCourse {
	
	private long id;
	private String name;
	private String mark;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id->" + String.valueOf(id) + "  name->" + name + "  mark->" + mark;
	}
}
