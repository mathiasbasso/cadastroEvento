package com.senac.cadastroEvento.Controller;



import com.senac.cadastroEvento.Model.Usuario;
import com.senac.cadastroEvento.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
    public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/eventos")
    public String listarEventos(Model model) {
        model.addAttribute("usuarios", new Usuario());
        return "index";
    }
    @GetMapping("/espere")
    public String EspereEventos(Model model) {
        model.addAttribute("usuarios", new Usuario());
        return "Espere";
    }
    @GetMapping("/expofemi")
    public String ExpoFemiEventos(Model model) {
        model.addAttribute("usuarios",new Usuario());
        return "expofemi";
    }

    @GetMapping("/novo")
    public String novoUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formularioUsuario";
    }

    @GetMapping("/lista")
    public String ListaUsuario(Model model) {
        model.addAttribute("usuarios",  usuarioRepository.findAll());
        return "ListaUsuarios";
    }
    @PostMapping("/novo")
    public String salvarNovoUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios/novo";
    }
        @PutMapping("/{id}")
        public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario updatedUsuario) {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

            if (optionalUsuario.isEmpty()) {
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
