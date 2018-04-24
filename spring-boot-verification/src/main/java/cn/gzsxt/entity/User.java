package cn.gzsxt.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class User implements Serializable {


    private Integer id;
    /**
     * @NotBlank 注解判断是否为null或为空,去除两边空白
     * @NotEmpty 注解判断是否为null或为空,不去空
     *
     *
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * @Length:判断字符串长度
     * min:最小
     * max:最大
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 12,message = "密码位数最小为6位,最大为12位.")
    private String password;
    @Min(value = 0,message = "年龄最小不能低于0")
    @Max(value = 99,message = "年龄最大不能大于99")
    private Integer age;

    @Email(message = "邮箱有误,请重新输入")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {

        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
