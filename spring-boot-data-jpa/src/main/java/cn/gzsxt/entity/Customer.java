package cn.gzsxt.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_customer")
public class Customer implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String phone;

    private String addrs;

    private String gender;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", addrs='" + addrs + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddrs() {
        return addrs;
    }

    public String getGender() {
        return gender;
    }
}
