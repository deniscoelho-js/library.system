package core.io.library.system.controller;

import core.io.library.system.dto.LivrosRequestDto;
import core.io.library.system.dto.LivrosResponseDto;
import core.io.library.system.dto.LivrosRequestDto;
import core.io.library.system.dto.LivrosResponseDto;
import core.io.library.system.service.LivrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/livros")
@RestController
public class LivrosController {

    private final LivrosService livrosService;


    @PostMapping("/salvar")
    public ResponseEntity<LivrosResponseDto> salvarLivros(@RequestBody LivrosRequestDto LivrosRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livrosService.salvarLivro(LivrosRequestDto));
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<LivrosResponseDto> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(livrosService.buscarLivroId(id));
    }

    @GetMapping("/listarTodos")
    private ResponseEntity<List<LivrosResponseDto>> listarTodos() {
        return ResponseEntity.ok(livrosService.listarLivros());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        livrosService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<LivrosResponseDto> editar(@PathVariable Integer id, @RequestBody LivrosRequestDto LivrosRequestDto){

        return ResponseEntity.ok(livrosService.editarLivro(id, LivrosRequestDto));
    }
}
