package com.mindwell;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="mood_entries") public class MoodEntry {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id;
 @Column(name="user_id",nullable=false) public Long userId;
 @Column(nullable=false,length=20) public String mood;
 @Column(length=500) public String note;
 @Column(nullable=false) public Integer energy;
 @Column(nullable=false) public Integer stress;
 @Column(name="created_at",insertable=false,updatable=false) public Instant createdAt;
 protected MoodEntry(){} public MoodEntry(Long userId,String mood,String note,Integer energy,Integer stress){this.userId=userId;this.mood=mood;this.note=note;this.energy=energy;this.stress=stress;}
}
