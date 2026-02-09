package core.io.library.system.controller;

import core.io.library.system.dto.UsuarioRequestDto;
import core.io.library.system.dto.UsuarioResponseDto;
import core.io.library.system.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResponseDto> salvarUsuario(@RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuarioRequestDto));
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioId(id));
    }

    @GetMapping("/listarTodos")
    private ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponseDto> editar(@PathVariable Integer id, @RequestBody UsuarioRequestDto usuarioRequestDto){

        return ResponseEntity.ok(usuarioService.editarUsuario(id, usuarioRequestDto));
    }
}
