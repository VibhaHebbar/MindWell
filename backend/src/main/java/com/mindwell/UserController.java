package com.mindwell;
import org.springframework.web.bind.annotation.*;import org.springframework.security.core.Authentication;import java.util.Map;
@RestController @RequestMapping("/api/users") public class UserController {
 private final UserRepository users;public UserController(UserRepository users){this.users=users;}
 @GetMapping("/me") public Map<String,Object> me(Authentication a){User u=users.findByEmailIgnoreCase(a.getName()).orElseThrow();return Map.of("id",u.id,"name",u.name,"email",u.email);}
}
