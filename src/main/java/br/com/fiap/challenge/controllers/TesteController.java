package br.com.fiap.challenge.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@Tag(name = "Teste")
@SecurityRequirement(name = "javainuseapi")
public class TesteController {


    @Operation(summary = "Teste")
    @GetMapping
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("Funcionou");
    }
}
