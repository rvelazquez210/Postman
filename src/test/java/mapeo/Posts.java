package mapeo;

public class Posts {
	
	int userID;
	int id;
	String title;
	String body;
	String address;
	
	public Posts(int userId, int id, String title, String body) {
		userId = userId;
		id = id;
		title = title;
		body = body;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return title;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	

}
