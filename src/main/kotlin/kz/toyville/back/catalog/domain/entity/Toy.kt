package kz.toyville.back.catalog.domain.entity

import kz.toyville.back.common.domain.entity.BaseEntity
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Toy(
        @Positive
        @NotNull
        @Column(scale = 2)
        var price: BigDecimal,

        @Positive
        @NotNull
        @Column(scale = 2)
        var subscriptionPrice: BigDecimal,

        @NotBlank
        var name: String,

        @Column(length = 16384)
        var description: String?,

        var image: String?,

        @ManyToOne
        var category: Category?

): BaseEntity()