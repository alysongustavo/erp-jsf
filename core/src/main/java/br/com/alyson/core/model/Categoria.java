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
 * Modulo: Almoxarifado
 * Descrição: Entidade que Representa as informações da Categoria do Produto no modulo Almoxarifado
 */
@Entity
@Table(name = "tbamx_categoria")
@XmlRootElement
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "seq_amx_categoria_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Getter @Setter
    @Size(max = 255)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;

        Categoria categoria = (Categoria) o;

        return getId() != null ? getId().equals(categoria.getId()) : categoria.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
