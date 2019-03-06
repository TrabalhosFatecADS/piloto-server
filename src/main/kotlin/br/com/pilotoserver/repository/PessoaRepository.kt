package br.com.pilotoserver.repository

import br.com.pilotoserver.model.Pessoa
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.stream.Stream

interface PessoaRepository : MongoRepository<Pessoa, String> {

    @Query("{}")
    fun all(): Stream<Pessoa>

    fun findByNome(nome: String): Pessoa

    fun findByApelido(apelido: String): Pessoa
}