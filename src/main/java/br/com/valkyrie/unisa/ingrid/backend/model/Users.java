package br.com.valkyrie.unisa.ingrid.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @Column(name = "user_id")
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
    private UsersRoles role;
}
