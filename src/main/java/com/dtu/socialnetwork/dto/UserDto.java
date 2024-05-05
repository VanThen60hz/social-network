package com.dtu.socialnetwork.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.dtu.socialnetwork.models.User}
 */
public class UserDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String gender;
    private final List<Integer> followers;
    private final List<Integer> followings;

    public UserDto(Integer id, String firstName, String lastName, String email, String password, String gender, List<Integer> followers, List<Integer> followings) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public List<Integer> getFollowings() {
        return followings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.gender, entity.gender) &&
                Objects.equals(this.followers, entity.followers) &&
                Objects.equals(this.followings, entity.followings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, gender, followers, followings);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "gender = " + gender + ", " +
                "followers = " + followers + ", " +
                "followings = " + followings + ")";
    }
}