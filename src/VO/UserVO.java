package VO;

public class UserVO {
    private static int userNumber = 0;
    private String name;
    private String id;
    private String address;
    private String phonNumber;
	private int point;
    private String regDate;
    private String password;
    private String roll;

    public UserVO() {
        userNumber++;
    }

    public static int getUserNumber() {
        return userNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonNumber() {
		return phonNumber;
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}

    public String getRoll() {        return roll;   }

    public void setRoll(String roll) {       this.roll = roll;    }
}
