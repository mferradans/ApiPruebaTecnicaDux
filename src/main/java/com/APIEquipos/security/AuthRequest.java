package com.APIEquipos.security;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AuthRequest {
    private String username;
    private String password;
}
