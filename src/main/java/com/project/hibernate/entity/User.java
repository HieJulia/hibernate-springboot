package com.project.hibernate.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//

//@XmlRootElement
////@NamedQueries({
////
//      @NamedQuery(name = "User.findAll", query = "SELECT s FROM user s")})
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

//    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    @Transient
    private String password;

    @Column(name="email", nullable=false)
    @Email(message = "*Please provide a valid e-mail address.")
    private String email;

//    @Basic(optional = false)
    @Column(name = "gender")
    private int gender;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date_of_birth;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id",fetch = FetchType.LAZY)
//    private List<Contact> contact;


// PROJECT
//    @ManyToMany(mappedBy = "members")
//    private Set<Project> projects = new HashSet<>();
////
    // role
    @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns = { @JoinColumn(name="user_id")},
            inverseJoinColumns = { @JoinColumn(name="role_id")}
    )
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Contact contact;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="department_id")
    @JsonBackReference
    private Department department;


}