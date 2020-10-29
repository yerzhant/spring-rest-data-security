package kz.toyville.back.catalog.domain.port

import kz.toyville.back.catalog.domain.entity.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.security.access.prepost.PreAuthorize
import java.util.*

@PreAuthorize("hasRole('ADMIN')")
interface CategoryRepository : CrudRepository<Category, Long> {

    @PreAuthorize("permitAll()")
    override fun findAll(): MutableIterable<Category>

    @PreAuthorize("permitAll()")
    override fun findById(id: Long): Optional<Category>

}