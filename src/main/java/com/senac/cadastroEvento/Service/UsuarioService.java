package com.senac.cadastroEvento.Service;

import com.senac.cadastroEvento.Model.Usuario;
import com.senac.cadastroEvento.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


}
