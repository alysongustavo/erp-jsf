package br.com.alyson.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @author Alyson Rodrigo
 *
 * Modulo: Protocolo
 * Descrição: Entidade que Representa as informações do Processo no modulo Protocolo
 */
@Entity
@Table(name = "tbpro_processo")
@XmlRootElement
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_PROCESSO", sequenceName = "seq_pro_processo_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROCESSO")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 20)
    @Column(name = "nr_processo")
    private String nrProcesso;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @Getter @Setter
    @Size(max = 250)
    private String descricao;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dataCadastro;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Pessoa solicitante;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Processo)) return false;

        Processo processo = (Processo) o;

        return getId() != null ? getId().equals(processo.getId()) : processo.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
