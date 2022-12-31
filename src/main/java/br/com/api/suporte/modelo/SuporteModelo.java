package br.com.api.suporte.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="tbl_suporte")
@Getter
@Setter
public class SuporteModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long codigo;
    private Integer codigo;
    private String local;
    private String descric_problem;
    private String status = "Solicitado";
    private Date data = new java.sql.Date(System.currentTimeMillis());
}