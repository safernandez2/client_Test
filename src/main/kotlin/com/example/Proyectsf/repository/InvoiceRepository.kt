package com.example.Proyectsf.repository


import com.example.Proyectsf.model.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long?> {
    fun findById(id: Long?): Invoice
    @Query(nativeQuery = true)
    fun findTotalMoreThat(@Param("total")total:Double?):List<Invoice>?
}
