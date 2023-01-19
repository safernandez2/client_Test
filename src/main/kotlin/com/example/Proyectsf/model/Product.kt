package com.example.Proyectsf.model

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "product")

class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String?=null
    var brand: String?=null
    var stock: Long?=null
    var price: Double?=null
}