package com.mindwell;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.List;
public interface JournalRepository extends JpaRepository<JournalEntry,Long>{List<JournalEntry> findTop50ByUserIdOrderByCreatedAtDesc(Long userId);}
