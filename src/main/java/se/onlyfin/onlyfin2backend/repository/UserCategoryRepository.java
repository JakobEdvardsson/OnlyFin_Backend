package se.onlyfin.onlyfin2backend.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.onlyfin.onlyfin2backend.model.UserCategory;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Integer> {
    List<UserCategory> findByUserStockId(Integer userStockId);

    @EntityGraph(attributePaths = "modules")
    @Query("""
            SELECT category
            FROM UserCategory category
            WHERE category.userStock.id = :userStockId
            """)
    List<UserCategory> findByUserStockIdIncludeModules(@Param("userStockId") Integer userStockId);
}
