package core.io.library.system.service;

import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;

import java.util.List;

public interface EmprestimoService {
    public EmprestimoResponseDto salvarEmprestimo(EmprestimoRequestDto EmprestimoRequestDto);
    public EmprestimoResponseDto buscarEmprestimoId(Integer id);
    public List<EmprestimoResponseDto> listarEmprestimos();
    public void deletarEmprestimo(Integer id);
    public EmprestimoResponseDto editarEmprestimo(Integer id, EmprestimoRequestDto EmprestimoRequestDto);
}
