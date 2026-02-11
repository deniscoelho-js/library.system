package core.io.library.system.service;

import core.io.library.system.dto.EmprestimoDevolucaoResponseDto;
import core.io.library.system.dto.EmprestimoRequestDto;
import core.io.library.system.dto.EmprestimoResponseDto;

import java.util.List;

public interface EmprestimoService {
    public EmprestimoResponseDto salvarEmprestimo(EmprestimoRequestDto emprestimoRequestDto);
    public EmprestimoResponseDto buscarEmprestimoId(Integer id);
    public List<EmprestimoResponseDto> listarEmprestimos();
    public void deletarEmprestimo(Integer id);
    List<EmprestimoResponseDto> buscarEmprestimosPorUsuario(Integer usuarioId);
    List<EmprestimoResponseDto> buscarEmprestimosPorLivro(Integer livroId);
    public EmprestimoDevolucaoResponseDto devolverEmprestimo(Integer id);
}
