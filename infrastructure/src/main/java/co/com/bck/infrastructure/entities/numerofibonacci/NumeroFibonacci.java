package co.com.bck.infrastructure.entities.numerofibonacci;

import co.com.bck.infrastructure.entities.fibonacci.Fibonacci;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

import static co.com.bck.infrastructure.constants.Comments.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@Table(name = "NUMERO_FIBONACCI")
@RequiredArgsConstructor
@Builder(toBuilder = true)
@SequenceGenerator(name = "NUMERO_FIBONACCI_SEQ", sequenceName = "NUMERO_FIBONACCI_SEQ", allocationSize = 1)
public class NumeroFibonacci {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NUMERO_FIBONACCI_SEQ")
    @Comment(PRIMARY_KEY_COMMENT)
    private Long id;

    @Comment(NUMERO_FIBONACCI_SEQ)
    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment(FOREING_KEY_FIBONACCI)
    @JoinColumn(name = "idFibonacci", foreignKey = @ForeignKey(name = "NUMERO_FIBONACCI_FK"))
    private Fibonacci fibonacci;

    //AUDITORIA
    @Comment(CREATED_BY_COMMENT)
    @Column(name = "CREATED_BY", nullable = false, updatable = false)
    private String createdBy;

    @CreationTimestamp
    @Comment(CREATED_AT_COMMENT)
    @Column(name = "DATE_CREATED", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "MODIFIED_BY")
    @Comment(MODIFIED_BY_COMMENT)
    private String modifiedBy;

    @UpdateTimestamp
    @Column(name = "DATE_MODIFIED")
    @Comment(MODIFIED_AT_COMMENT)
    private LocalDateTime dateModified;

    /**
     * Overrides the equals method to provide a custom equality check for Tercero entities.
     * This method is designed to handle Hibernate proxy classes by comparing the underlying persistent class types
     * and the entity's ID. It ensures that two entities are considered equal if they have the same ID, even if one
     * or both are proxied.
     *
     * @param o the object to be compared with this Tercero entity for equality.
     * @return true if the given object represents the same Tercero entity as this object, false otherwise.
     */
    @Override
    public final boolean equals(Object o) {
        if(Boolean.TRUE.equals(this == o)){
            return true;
        }
        if (Boolean.TRUE.equals(o == null || this.getClass() != o.getClass())){
            return false;
        }
        // Determine the effective class of the argument, considering Hibernate proxies.
        Class<?> oEffectiveClass;
        if (Boolean.TRUE.equals(this instanceof HibernateProxy)){
            oEffectiveClass =  ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass();
        } else {
            oEffectiveClass =  o.getClass();
        }

        // Determine the effective class of this instance, considering Hibernate proxies.
        Class<?> thisEffectiveClass;
        if (Boolean.TRUE.equals(this instanceof HibernateProxy)){
            thisEffectiveClass =  ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass();
        } else {
            thisEffectiveClass =  this.getClass();
        }

        if (thisEffectiveClass != oEffectiveClass) return false;
        NumeroFibonacci entity = (NumeroFibonacci) o;
        // Check if IDs are the same, considering nulls.
        return getId() != null && Objects.equals(getId(), entity.getId());
    }
    /**
     * Generates a hash code for this entity.
     * This method is overridden to ensure that the hash code is consistent with the entity's identity as defined by its ID.
     * It uses a proxy class's persistent class to generate the hash code if this entity is a Hibernate proxy,
     * ensuring that the hash code remains consistent across different Hibernate sessions and when the entity is lazily loaded.
     *
     * @return an integer representing the hash code of this entity. If this entity is a Hibernate proxy,
     * the hash code of the proxy's persistent class is returned; otherwise, the hash code of this entity's class is returned.
     */
    @Override
    public final int hashCode() {
        if (Boolean.TRUE.equals(this instanceof HibernateProxy)){
            return ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode();
        } else {
            return getClass().hashCode();
        }
    }
}
