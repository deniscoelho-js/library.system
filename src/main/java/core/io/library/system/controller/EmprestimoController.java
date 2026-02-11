package core.io.library.system.controller;

import core.io.library.system.dto.*;
import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;
import core.io.library.system.service.EmprestimoService;
import core.io.library.system.service.EmprestimoService;
import core.io.library.system.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/emprestimos")
@RestController
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping("/salvar")
    public ResponseEntity<EmprestimoResponseDto> salvarEmprestimo(@RequestBody EmprestimoRequestDto emprestimoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoService.salvarEmprestimo(emprestimoRequestDto));
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<EmprestimoResponseDto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(emprestimoService.buscarEmprestimoId(id));
    }

    @GetMapping("/listarTodos")
    private ResponseEntity<List<EmprestimoResponseDto>> listarTodos() {
        return ResponseEntity.ok(emprestimoService.listarEmprestimos());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarPorUsuarioId/{usuarioId}")
    public ResponseEntity<List<EmprestimoResponseDto>> buscarPorUsuarioId(@PathVariable Integer usuarioId) {
        return ResponseEntity.ok(emprestimoService.buscarEmprestimosPorUsuario(usuarioId));
    }

    @GetMapping("/buscarPorLivroId/{livroId}")
    public ResponseEntity<List<EmprestimoResponseDto>> buscarPorLivroId(@PathVariable Integer livroId) {
        return ResponseEntity.ok(emprestimoService.buscarEmprestimosPorLivro(livroId));
    }

    @PostMapping("/devolverEmprestimo/{emprestimoId}")
    public ResponseEntity<EmprestimoDevolucaoResponseDto> devolverEmprestimo(@PathVariable Integer emprestimoId) {
        return ResponseEntity.ok(emprestimoService.devolverEmprestimo(emprestimoId));
    }

}
