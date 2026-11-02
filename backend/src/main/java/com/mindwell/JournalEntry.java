package com.mindwell;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="journal_entries") public class JournalEntry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(name="user_id",nullable=false) public Long userId;
 @Column(nullable=false,length=120) public String title;
 @Column(nullable=false,columnDefinition="TEXT") public String content;
 @Column(length=20) public String mood;
 @Column(name="created_at",insertable=false,updatable=false) public Instant createdAt;
 protected JournalEntry(){} public JournalEntry(Long userId,String title,String content,String mood){this.userId=userId;this.title=title;this.content=content;this.mood=mood;}
}
