package Model;

/**
 * @author ajie
 * @date 2019-10-11 15:17
 */

public class User {

    private String username;

    private String  address;

    private Integer age;


    public User(){

    }

    public User(String username, String address, Integer age) {
        this.username = username;
        this.address = address;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
