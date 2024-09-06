package br.com.valkyrie.unisa.ingrid.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity // Indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Table(name = "users") // Define o nome da tabela no banco de dados
@Getter // Gera os métodos getter para todos os campos
@Setter // Gera os métodos setter para todos os campos
@AllArgsConstructor // Gera um construtor com todos os argumentos
@NoArgsConstructor // Gera um construtor sem argumentos
public class Users {

    @Id // Indica que este campo é a chave primária da tabela
    @Column(name = "user_id") // Define o nome da coluna no banco de dados
    private UUID userId;
    private String email;
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String username;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

//    @Enumerated(EnumType.STRING)
    private UsersRoles role;
}
