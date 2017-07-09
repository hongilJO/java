package auth_dao;


public class dto {
	
	String id,pwd,username,address;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public dto(String id,String pwd, String username, String address){
		
		this.id = id;
		this.pwd = pwd;
		this.username = username;
		this.address = address;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+this.pwd;
	}
	

}
