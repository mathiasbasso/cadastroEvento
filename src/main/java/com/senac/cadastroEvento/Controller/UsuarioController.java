package com.senac.cadastroEvento.Controller;



import com.senac.cadastroEvento.Model.Usuario;
import com.senac.cadastroEvento.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
    public class UsuarioController {
    public class GameController {
        @Autowired
        private UsuarioRepository usuarioRepository;

        @GetMapping
        public List<Usuario> getAllUsuarios() {
            return usuarioRepository.findAll();
        }

        @GetMapping("/{id}")
        public Usuario getUsuarioById(@PathVariable Long id) {
            return usuarioRepository.findById(id).orElse(null);
        }


    }
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
