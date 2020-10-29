package kz.toyville.back.catalog.domain.port

import kz.toyville.back.catalog.domain.entity.Category
import kz.toyville.back.catalog.domain.entity.Toy
import org.springframework.data.repository.CrudRepository
import org.springframework.security.access.prepost.PreAuthorize

@PreAuthorize("hasRole('ADMIN')")
interface ToyRepository : CrudRepository<Toy, Long> {

    @PreAuthorize("permitAll()")
    fun findByCategory(category: Category): Iterable<Toy>
}