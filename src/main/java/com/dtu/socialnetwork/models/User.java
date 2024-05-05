package com.dtu.socialnetwork.models;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;


    @ElementCollection
    @CollectionTable(
            name = "user_followers",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "follower_id"})
    )
    @Column(name = "follower_id")
    private List<Integer> followers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "user_followings",
            joinColumns = @JoinColumn(name = "user_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "following_id"})
    )
    @Column(name = "following_id")
    private List<Integer> followings = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "save_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "posts_id"))
    private Set<Post> savePosts = new LinkedHashSet<>();

    public Set<Post> getSavePosts() {
        return savePosts;
    }

    public void setSavePosts(Set<Post> savePosts) {
        this.savePosts = savePosts;
    }

    public User() {
        // Default constructor required by JPA
    }

    public User(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> followers, List<Integer> followings, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.followers = followers;
        this.followings = followings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Integer> followings) {
        this.followings = followings;
    }

}
