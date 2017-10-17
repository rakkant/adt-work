
public class CommentArray {
	
	private Comment[] comments;
	private int commentsCount ;
	private int size;
	public CommentArray(int size){
		this.comments = new Comment[size];
		this.size = size;
		this.commentsCount = 0;
	}
	
	public int findLocationByTid (int p){
		for (int i = 0 ; i < commentsCount ; i ++){
			if(comments[i].getId() == p){
				return i;
			}
		}
		return -1;
	}
	
	public void insert (int i, Comment comment){
		for (int j = commentsCount -1 ; j >= i ; j--){
			comments[j+1] = comments[j];
		}
		comments[i] = comment ;
		commentsCount++;
	}
	
	public Comment get(int i){
		return comments[i];
	}
}
