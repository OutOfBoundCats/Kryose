package com.kryose.kryose.Entity;


import javax.persistence.*;

@Entity
@Table(name="user_details")
public class MyUserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name="username")
    private String userName;

    @OneToOne(mappedBy = "myUserDetauilsID",fetch = FetchType.LAZY)
    private User myuser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private Resource myResource;



    public MyUserDetails(String userName) {
        this.userName = userName;
    }

    public MyUserDetails() {
    }
    public User getMyuser() {
        return myuser;
    }

    public Resource getMyResource() {
        return myResource;
    }

    public void setMyResource(Resource myResource) {
        this.myResource = myResource;
    }

    public void setMyuser(User myuser) {
        this.myuser = myuser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "id=" + id +
                ", userName='" + userName + '\'' +

                '}';
    }
}
