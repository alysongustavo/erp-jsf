package br.com.alyson.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author Alyson Rodrigo
 *
 * Modulo: Almoxarifado
 * Descrição: Entidade que Representa as informações do Produto no modulo Almoxarifado
 */
@Entity
@Table(name = "tbamx_produto")
@XmlRootElement
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "seq_amx_produto_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUTO")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Getter @Setter
    @Size(max = 250)
    private String descricao;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dataCadastro;

    @Getter @Setter
    @NotNull
    @Column(name = "nr_nota", nullable = false)
    private Integer nrNotaFiscal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;

        Produto produto = (Produto) o;

        return getId() != null ? getId().equals(produto.getId()) : produto.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
