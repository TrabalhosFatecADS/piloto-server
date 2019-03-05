package br.com.pilotoserver.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Veiculo(var marca: String? = null,
               var modelo: String? = null,
               @Id var id: String? =null)