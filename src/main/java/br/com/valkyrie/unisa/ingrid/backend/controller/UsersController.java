package br.com.valkyrie.unisa.ingrid.backend.controller;

import br.com.valkyrie.unisa.ingrid.backend.model.Users;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.NewUserDto;
import br.com.valkyrie.unisa.ingrid.backend.model.dtos.UsersResponseDto;
import br.com.valkyrie.unisa.ingrid.backend.services.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;

    @PostMapping("signup")
    public ResponseEntity<UsersResponseDto> signupUser(@RequestBody @Valid NewUserDto dto) {
        return new ResponseEntity<>(service.signupUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("get/{username}")
    public ResponseEntity<UsersResponseDto> getUser(@PathVariable String username) {
        return new ResponseEntity<>(service.getUser(username), HttpStatus.OK);
    }

    @GetMapping("get/all")
    public ResponseEntity<List<UsersResponseDto>> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
}
