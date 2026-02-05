package core.io.library.system.service;

import core.io.library.system.dto.MultaRequestDto;
import core.io.library.system.dto.MultaResponseDto;

import java.util.List;

public interface MultaService {
    public MultaResponseDto salvarMulta(MultaRequestDto MultaRequestDto);
    public MultaResponseDto buscarMultaId(Integer id);
    public List<MultaResponseDto> listarMultas();
    public void deletarMulta(Integer id);
    public MultaResponseDto editarMulta(Integer id, MultaRequestDto MultaRequestDto);
}
