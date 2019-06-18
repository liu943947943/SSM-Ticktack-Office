package com.qfedu.pojo;/**
 * Created by HP on 2019/6/13.
 */

/**
 * @author HP liuchenglong
 * @create 2019-06-13 17:28
 **/
public class User {

    private Integer id;
    private String no;
    private String password;
    private String name;
    private Integer role;
    private Integer flag;
    private Integer headphoto;
    private UserPic userPic;

    public User(Integer id, String no, String password, String name, Integer role, Integer flag, Integer headphoto, UserPic userPic) {
        this.id = id;
        this.no = no;
        this.password = password;
        this.name = name;
        this.role = role;
        this.flag = flag;
        this.headphoto = headphoto;
        this.userPic = userPic;
    }



    public User() {
        super();
    }
    public UserPic getUserPic() {
        return userPic;
    }

    public void setUserPic(UserPic userPic) {
        this.userPic = userPic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getHeadphoto() {
        return headphoto;
    }

    public void setHeadphoto( Integer headphoto) {
        this.headphoto = headphoto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", flag=" + flag +
                ", headphoto=" + headphoto +
                ", userPic=" + userPic +
                '}';
    }
}