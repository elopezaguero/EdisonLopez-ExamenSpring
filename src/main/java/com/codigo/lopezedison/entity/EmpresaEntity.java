package com.codigo.lopezedison.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    @Column(name = "es_agente_retencion")
    private boolean esAgenteRetencion;
    private int estado;

    @Column(name = "usua_crea")
    private String usuaCrea;
    @Column(name = "date_create")
    private Date dateCreate;
    @Column(name = "usua_modif")
    private String usuaModif;
    @Column(name = "date_modif")
    private Date dateModif;
    @Column(name = "usua_delet")
    private String usuaDelet;
    @Column(name = "date_delet")
    private Date dateDelet;

}
