package com.example.Proyectsf.service



import com.example.Proyectsf.model.Product
import com.example.Proyectsf.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ProductServiceTest {
    @InjectMocks
    lateinit var productService: ProductService

    @Mock
    lateinit var productRepository: ProductRepository

    val productMock = Product().apply{
        id= 1
        description= "Zapatos"
        brand= "nike"
        stock= 10
        price= 1.1
    }

    @Test
    fun saveProductWhenIsCorrect(){
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.id, productMock.id)
    }

    @Test
    fun saveProductWhenIsDescriptionIsBlank(){
        Assertions.assertThrows(Exception::class.java){
            productMock.apply{description = " " }
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }
    }

    @Test
    fun saveProductWhenIsStockIsLessThanCero(){
        Assertions.assertThrows(Exception::class.java){
            productMock.apply{stock = 0 }
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }
    }

}