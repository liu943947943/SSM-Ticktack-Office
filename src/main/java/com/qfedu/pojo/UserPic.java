package com.qfedu.pojo;/**
 * Created by HP on 2019/5/27.
 */

import org.springframework.stereotype.Component;

/**
 * @author HP liuchenglong
 * @create 2019-05-27 15:54
 **/
@Component
public class UserPic {
    private Integer id;

    private String path;

 /*   private String status;

    private int startRow;
    private int endRow;*/

    public UserPic(Integer id, String path) {
        this.id = id;
        this.path = path;

    }

    public UserPic() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "UserPic{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}