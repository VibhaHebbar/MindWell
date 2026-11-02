package com.mindwell;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="app_users") public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(nullable=false,length=80) public String name;
 @Column(nullable=false,unique=true,length=254) public String email;
 @Column(name="password_hash",nullable=false,length=100) public String passwordHash;
 @Column(name="created_at",insertable=false,updatable=false) public Instant createdAt;
 protected User(){} public User(String name,String email,String passwordHash){this.name=name;this.email=email;this.passwordHash=passwordHash;}
}
