package com.mindwell;
import org.springframework.web.bind.annotation.*;import java.util.Map;
@RestController public class ApiController { @GetMapping("/api/health") public Map<String,String> health(){return Map.of("status","UP","service","mindwell");} }
