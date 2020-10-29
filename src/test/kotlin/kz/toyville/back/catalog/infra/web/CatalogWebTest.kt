package kz.toyville.back.catalog.infra.web

import kz.toyville.back.catalog.domain.entity.Category
import kz.toyville.back.catalog.domain.entity.Toy
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
internal class CatalogWebTest @Autowired constructor(
        private val mvc: MockMvc
) {

    @Test
    @Sql("/scripts/catalog.sql")
    internal fun `List categories`() {
        mvc.get("/v1/categories").andExpect {
            status { isOk }
            jsonPath("\$._embedded.categories", hasSize<Category>(3))
        }
    }

    @Test
    @Sql("/scripts/catalog.sql")
//    @WithMockUser(roles = ["ADMIN"])
    internal fun `List toys for a category`() {
        mvc.get("/v1/toys/search/findByCategory?category=/category/1").andExpect {
            status { isOk }
            jsonPath("\$._embedded.toys", hasSize<Toy>(0)) {
                isArray
            }
        }
    }
}