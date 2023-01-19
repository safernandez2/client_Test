package com.example.Proyectsf.service


import com.example.Proyectsf.model.Client
import com.example.Proyectsf.repository.ClientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ClientServiceTest {
    @InjectMocks
    lateinit var clientService: ClientService

    @Mock
    lateinit var clientRepository: ClientRepository

    val clientMock = Client().apply {
        id = 1
        nui = "01506825334"
        fullname = "Steven"
        address = "Cuenca"
    }

    @Test
    fun saveClientWhenIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)
    }

    @Test
    fun saveClientWhenIsFullnameIsBlank() {
        Assertions.assertThrows(Exception::class.java) {
            clientMock.apply { fullname = " " }
            Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
            clientService.save(clientMock)
        }
    }

    @Test
    fun saveClientWhenIsNuiIsBlank() {
        Assertions.assertThrows(Exception::class.java) {
            clientMock.apply { nui = " " }
            Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
            clientService.save(clientMock)
        }
    }
}