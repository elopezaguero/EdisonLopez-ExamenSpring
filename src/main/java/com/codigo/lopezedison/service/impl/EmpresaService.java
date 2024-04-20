package com.codigo.lopezedison.service.impl;

import com.codigo.lopezedison.constants.Constants;
import com.codigo.lopezedison.dao.IEmpresaRepository;
import com.codigo.lopezedison.entity.EmpresaEntity;
import com.codigo.lopezedison.service.IEmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaService implements IEmpresaService {

    private final IEmpresaRepository iEmpresaRepository;

    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        EmpresaEntity empresa = new EmpresaEntity();

        empresa.setRazonSocial(empresaEntity.getRazonSocial());
        empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
        empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
        empresa.setCondicion(empresaEntity.getCondicion());
        empresa.setDireccion(empresaEntity.getDireccion());
        empresa.setDistrito(empresaEntity.getDistrito());
        empresa.setProvincia(empresaEntity.getProvincia());
        empresa.setDepartamento(empresaEntity.getDepartamento());
        empresa.setEsAgenteRetencion(empresaEntity.isEsAgenteRetencion());
        empresa.setEstado(Constants.STATUS_ACTIVE);
        empresa.setUsuaCrea(Constants.USU_ADMIN);
        empresa.setDateCreate(getTimestamp());

        return iEmpresaRepository.save(empresa);
    }

    @Override
    public Optional<EmpresaEntity> buscarXId(Long id) {
        return iEmpresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> BuscarAll() {
         return iEmpresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity> optionalEmpresa = iEmpresaRepository.findById(id);
        if(optionalEmpresa.isPresent()){
           EmpresaEntity empresa = optionalEmpresa.get();
           empresa.setRazonSocial(empresaEntity.getRazonSocial());
           empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
           empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
           empresa.setCondicion(empresaEntity.getCondicion());
           empresa.setDireccion(empresaEntity.getDireccion());
           empresa.setDistrito(empresaEntity.getDistrito());
           empresa.setProvincia(empresaEntity.getProvincia());
           empresa.setDepartamento(empresaEntity.getDepartamento());
           empresa.setEsAgenteRetencion(empresaEntity.isEsAgenteRetencion());
           empresa.setEstado(empresaEntity.getEstado());
           empresa.setUsuaModif(Constants.USU_ADMIN);
           empresa.setDateModif(getTimestamp());

           return iEmpresaRepository.save(empresa);
        }
        return null;
    }

    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = iEmpresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setUsuaDelet(Constants.USU_ADMIN);
            empresaRecuperada.get().setDateDelet(getTimestamp());
            return iEmpresaRepository.save(empresaRecuperada.get());
        }
        return null;
    }
}