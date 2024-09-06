package br.com.valkyrie.unisa.ingrid.backend.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.StackTrace;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UsersResponseDto {
    private UUID userId;
    private String email;
    private String password;
    private String fullName;
    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy : HH:mm:ss")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy : HH:mm:ss")
    private Date updatedAt;
}
