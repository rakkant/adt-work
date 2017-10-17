public class Comment {
 
	private int id;
	private int parentId;
	private String msg;
 
	public Comment(int id, int parentId, String msg) {
		this.setId(id);
		this.setParentId(parentId);
		this.setMsg(msg);
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public int getParentId() {
		return parentId;
	}
 
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
 
	public String getMsg() {
		return msg;
	}
 
	public void setMsg(String msg) {
		this.msg = msg;
	}
}