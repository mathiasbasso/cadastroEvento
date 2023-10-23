package com.senac.cadastroEvento.Service;

import com.senac.cadastroEvento.Model.Usuario;
import com.senac.cadastroEvento.Repository.UsuarioRepository;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }
    public boolean deleteUsuario(Long id) {
        Optional<Usuario> existingGame = usuarioRepository.findById(id);
        if (existingGame.isPresent()) {
            JavaIOFileDescriptorAccess existingUsuario;
            usuarioRepository.delete(existingUsuario.get());
            return true;
        }
        return false;
    }
}
