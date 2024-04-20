package com.codigo.lopezedison.dao;

import com.codigo.lopezedison.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

}
