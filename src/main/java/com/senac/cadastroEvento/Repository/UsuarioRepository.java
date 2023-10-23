package com.senac.cadastroEvento.Repository;

import com.senac.cadastroEvento.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
