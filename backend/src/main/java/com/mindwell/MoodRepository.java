package com.mindwell;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface MoodRepository extends JpaRepository<MoodEntry,Long>{List<MoodEntry> findTop30ByUserIdOrderByCreatedAtDesc(Long userId);}
