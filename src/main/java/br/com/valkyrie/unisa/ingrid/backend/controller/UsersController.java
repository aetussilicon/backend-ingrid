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

@RestController // Indica que esta classe é um controlador REST e que irá responder a requisições HTTP
@RequestMapping("users") // Define o caminho base para todas as requisições
@RequiredArgsConstructor // Gera um construtor com todos os campos finais (final) como parâmetros
public class UsersController {

    // Declaração do serviço que será usado para manipular os dados dos usuários
    private final UsersService service;

    // Mapeia requisições HTTP POST para a URL /users/signup
    @PostMapping("signup")
    // Método para registrar um novo usuário
    // @RequestBody indica que o objeto NewUserDto será passado no corpo da requisição
    // @Valid valida o objeto NewUserDto com base nas anotações de validação
    public ResponseEntity<UsersResponseDto> signupUser(@RequestBody @Valid NewUserDto dto) {
        // Chama o serviço para registrar o usuário e retorna a resposta com status HTTP 201 (Created)
        return new ResponseEntity<>(service.signupUser(dto), HttpStatus.CREATED);
    }

    // Mapeia requisições HTTP GET para a URL /users/get/{username}
    @GetMapping("get/{username}")
    // Método para obter os dados de um usuário específico pelo nome de usuário
    // @PathVariable indica que o valor do parâmetro username será extraído da URL
    public ResponseEntity<UsersResponseDto> getUser(@PathVariable String username) {
        // Chama o serviço para obter os dados do usuário e retorna a resposta com status HTTP 200 (OK)
        return new ResponseEntity<>(service.getUser(username), HttpStatus.OK);
    }

    // Mapeia requisições HTTP GET para a URL /users/get/all
    @GetMapping("get/all")
    // Método para obter os dados de todos os usuários
    public ResponseEntity<List<UsersResponseDto>> getAllUsers() {
        // Chama o serviço para obter os dados de todos os usuários e retorna a resposta com status HTTP 200 (OK)
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
}
