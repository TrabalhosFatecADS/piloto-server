package br.com.pilotoserver.repository

import br.com.pilotoserver.model.Veiculo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import java.util.stream.Stream

interface VeiculoRepository : MongoRepository<Veiculo, String> {

    @Query("{}")
    fun all(): Stream<Veiculo>

    fun findByMarca(marca: String): List<Veiculo>

    fun findByModelo(modelo: String): Veiculo
}