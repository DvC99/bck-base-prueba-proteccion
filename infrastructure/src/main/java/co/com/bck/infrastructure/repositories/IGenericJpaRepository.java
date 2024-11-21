package co.com.bck.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface IGenericJpaRepository<E, K> extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {
    /**
     * Verifica si una entidad está siendo utilizada como clave foránea en otras tablas.
     *
     * @param tableName El nombre de la tabla de la entidad.
     * @return true si la entidad está siendo utilizada en otras tablas, false en caso contrario.
     */
    @Query(value =
            "SELECT CASE WHEN EXISTS ( "+
                "SELECT 1 "+
                "FROM ALL_CONSTRAINTS FK "+
                "JOIN ALL_CONS_COLUMNS FKC ON FK.CONSTRAINT_NAME = FKC.CONSTRAINT_NAME AND FK.OWNER = FKC.OWNER "+
                "JOIN ALL_CONSTRAINTS PK ON FK.R_CONSTRAINT_NAME = PK.CONSTRAINT_NAME AND FK.R_OWNER = PK.OWNER "+
                "JOIN ALL_CONS_COLUMNS PKC ON PK.CONSTRAINT_NAME = PKC.CONSTRAINT_NAME AND PK.OWNER = PKC.OWNER AND PKC.POSITION = FKC.POSITION "+
                "WHERE FK.CONSTRAINT_TYPE = 'R' "+
                "AND PK.CONSTRAINT_TYPE = 'P' "+
                "AND PK.TABLE_NAME = UPPER(:TABLE_NAME) "+
            ") THEN 'TRUE' ELSE 'FALSE' "+
            "END AS RESULT "+
            "FROM DUAL ",
            nativeQuery = true)
    boolean isUsedInOtherTables(@Param("TABLE_NAME") String tableName);
}
