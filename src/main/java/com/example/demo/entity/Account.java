package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @JsonProperty("username")
    private String userName;
    private String password;
    private String fullName;
    private String email;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Authority> authorities;


}
