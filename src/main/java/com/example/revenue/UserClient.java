package com.example.revenue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "gestion-utilisateur")
public interface UserClient {
    @GetMapping("/api/utilisateurs/getbyid/{id}")
    UserDTO getUserById(@PathVariable Long id);
}

