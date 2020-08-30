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
 * Modulo: Protocolo
 * Descrição: Entidade que Representa as informações da Especie do Processo no modulo Protocolo
 */
@Entity
@Table(name = "tbpro_especie")
@XmlRootElement
public class Especie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "SEQ_ESPECIE", sequenceName = "seq_pro_especie_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESPECIE")
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
        if (!(o instanceof Especie)) return false;

        Especie especie = (Especie) o;

        return getId() != null ? getId().equals(especie.getId()) : especie.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
