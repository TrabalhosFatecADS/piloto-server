package br.com.pilotoserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PilotoServerApplication

fun main(args: Array<String>) {
	runApplication<PilotoServerApplication>(*args)
}
