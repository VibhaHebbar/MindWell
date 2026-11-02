package com.mindwell;
import org.springframework.web.bind.annotation.*;import org.springframework.security.core.Authentication;import jakarta.validation.Valid;import jakarta.validation.constraints.*;import java.util.List;
@RestController @RequestMapping("/api/journal") public class JournalController {
 private final JournalRepository journal;private final UserRepository users;public JournalController(JournalRepository journal,UserRepository users){this.journal=journal;this.users=users;}
 public record JournalRequest(@NotBlank @Size(max=120)String title,@NotBlank @Size(max=10000)String content,@Pattern(regexp="Happy|Calm|Okay|Sad|Anxious|Frustrated",message="Unsupported mood")String mood){}
 private Long userId(Authentication a){return users.findByEmailIgnoreCase(a.getName()).orElseThrow().id;}
 @GetMapping public List<JournalEntry> list(Authentication a){return journal.findTop50ByUserIdOrderByCreatedAtDesc(userId(a));}
 @PostMapping public JournalEntry create(@Valid @RequestBody JournalRequest r,Authentication a){return journal.save(new JournalEntry(userId(a),r.title(),r.content(),r.mood()));}
}
