package entities;

import javax.persistence.*;

@Entity
@Table(name = "login_info")
public class LoginInfo {

    @Id
    @Column(name = "login_info_id")
    private Long loginInfoId;
    @Column(name = "login_name")
    private String loginName;
    private String password;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getLoginInfoId() {
        return loginInfoId;
    }

    public void setLoginInfoId(Long loginInfoId) {
        this.loginInfoId = loginInfoId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
