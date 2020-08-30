package br.com.alyson.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @version 1.0
 * @author Alyson Rodrigo
 *
 * Modulo: Cadastro
 * Descrição: Entidade que Representa as informações do Endereço no modulo Cadastro
 */
@Entity
@Table(name = "tbcad_pessoa")
@XmlRootElement
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "seq_cad_pessoa_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String name;

    @Getter @Setter
    private Integer idade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;

        Pessoa pessoa = (Pessoa) o;

        return getId() != null ? getId().equals(pessoa.getId()) : pessoa.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
