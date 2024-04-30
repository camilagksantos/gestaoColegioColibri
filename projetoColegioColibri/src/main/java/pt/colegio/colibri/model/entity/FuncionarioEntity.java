package pt.colegio.colibri.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="funcionario")
public class FuncionarioEntity extends PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_funcionario")
    private Integer idFuncionario;
}
