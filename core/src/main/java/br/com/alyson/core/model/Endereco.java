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
@Table(name = "tbcad_endereco")
@XmlRootElement
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "seq_cad_endereco_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO")
    private Long id;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Getter @Setter
    @NotBlank
    @Size(max = 2)
    private String uf;

    @Getter @Setter
    @NotBlank
    @Size(max = 60)
    private String cidade;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String bairro;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String rua;

    @Getter @Setter
    @Size(max = 100)
    private String complemento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;

        Endereco endereco = (Endereco) o;

        return getId() != null ? getId().equals(endereco.getId()) : endereco.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
