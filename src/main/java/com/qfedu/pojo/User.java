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
    //private Integer role;
    private char flag;
    private Integer headphoto;
    private UserPic userPic;
    private Role userRole;

    public User(Integer id, String no, String password, String name,  char flag, Integer headphoto, UserPic userPic, Role userRole) {
        this.id = id;
        this.no = no;
        this.password = password;
        this.name = name;

        this.flag = flag;
        this.headphoto = headphoto;
        this.userPic = userPic;
        this.userRole = userRole;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
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



    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
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

                ", flag=" + flag +
                ", headphoto=" + headphoto +
                ", userPic=" + userPic +
                '}';
    }
}
