package com.mindwell;
import org.springframework.web.bind.annotation.*;import org.springframework.security.core.Authentication;import jakarta.validation.Valid;import jakarta.validation.constraints.*;import java.util.List;
@RestController @RequestMapping("/api/moods") public class MoodController {
 private final MoodRepository moods;private final UserRepository users;public MoodController(MoodRepository moods,UserRepository users){this.moods=moods;this.users=users;}
 public record MoodRequest(@NotBlank @Pattern(regexp="Happy|Calm|Okay|Sad|Anxious|Frustrated")String mood,@Size(max=500)String note,@Min(1)@Max(5)Integer energy,@Min(1)@Max(5)Integer stress){}
 private Long userId(Authentication a){return users.findByEmailIgnoreCase(a.getName()).orElseThrow().id;}
 @GetMapping public List<MoodEntry> list(Authentication a){return moods.findTop30ByUserIdOrderByCreatedAtDesc(userId(a));}
 @PostMapping public MoodEntry create(@Valid @RequestBody MoodRequest r,Authentication a){return moods.save(new MoodEntry(userId(a),r.mood(),r.note(),r.energy(),r.stress()));}
}
