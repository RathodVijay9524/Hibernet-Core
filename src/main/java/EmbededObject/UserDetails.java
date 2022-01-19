package EmbededObject;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetails {

    @Id
    private int userId;
    private String userName;
    private String userCompany;
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserDetails(int userId, String userName, String userCompany) {
        this.userId = userId;
        this.userName = userName;
        this.userCompany = userCompany;
    }

    public UserDetails() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userCompany='" + userCompany + '\'' +
                '}';
    }
}
