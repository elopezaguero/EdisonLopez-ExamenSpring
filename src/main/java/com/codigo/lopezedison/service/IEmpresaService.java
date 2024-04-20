package com.codigo.lopezedison.service;

import com.codigo.lopezedison.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface IEmpresaService {
    EmpresaEntity crear(EmpresaEntity empresaEntity);
    Optional<EmpresaEntity> buscarXId(Long id);
    List<EmpresaEntity> BuscarAll();
    EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity);
    EmpresaEntity borrar(Long id);
}
