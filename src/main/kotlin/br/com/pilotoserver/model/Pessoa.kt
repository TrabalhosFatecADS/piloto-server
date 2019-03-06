package br.com.pilotoserver.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Pessoa(

        var nome: String? = null,
        var apelido: String? = null,
        var texto: String? = null,
        @Id var id: String? =null
)