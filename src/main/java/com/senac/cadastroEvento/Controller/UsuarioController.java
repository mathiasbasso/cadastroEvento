package com.senac.cadastroEvento.Controller;



import com.senac.cadastroEvento.Model.Usuario;
import com.senac.cadastroEvento.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
    public class UsuarioController {

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
        @PutMapping("/{id}")
        public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario updatedUsuario) {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

            if (!optionalUsuario.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Usuario existingUsuario = optionalUsuario.get();
            existingUsuario.setNome(updatedUsuario.getNome());
            existingUsuario.setEmail(updatedUsuario.getEmail());

            Usuario updated = usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(updated);
        }
        @DeleteMapping("/{id}")
        public void deleteUsuario(@PathVariable Long id) {
            usuarioRepository.deleteById(id);
        }


}
