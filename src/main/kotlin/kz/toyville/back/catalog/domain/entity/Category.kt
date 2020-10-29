package kz.toyville.back.catalog.domain.entity

import kz.toyville.back.common.domain.entity.BaseEntity
import javax.persistence.Entity
import javax.validation.constraints.NotBlank

@Entity
class Category(
        @NotBlank
        var name: String,
        @NotBlank
        var image: String
) : BaseEntity()