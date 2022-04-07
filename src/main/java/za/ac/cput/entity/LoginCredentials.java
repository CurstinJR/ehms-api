package za.ac.cput.entity;
/*
LoginCredentials.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 07 April 2022
*/
public class LoginCredentials {
    private long id;
    private String email;
    private String password;
    public long getId() {
        return id;
    }
    private LoginCredentials(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginCredentials{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class Builder {
        private long id;
        private String email;
        private String password;

        public Builder Id(long id) {
            this.id = id;
            return this;
        }
        public Builder Email(String email) {
            this.email = email;
            return this;
        }
        public Builder Password(String password) {
            this.password = password;
            return this;
        }
        public Builder copy(LoginCredentials log){
            this.id = log.id;
            this.email = log.email;
            this.password = log.password;
            return this;

        }

        public LoginCredentials build() {
            return new LoginCredentials(this);
        }

    }
}

