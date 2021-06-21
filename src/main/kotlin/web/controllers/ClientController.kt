package web.controllers

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import domain.Client
import domain.repository.ResumeSimulationRepository
import domain.service.ClientService
import io.ktor.http.*

class ClientController(private val clientService: ClientService) {
    suspend fun register(ctx: ApplicationCall) {
        ctx.receive<Client>().apply {
            clientService.createClient(this).apply {
                if (this != null) {
                    ctx.respond(HttpStatusCode.OK, "Cadastro do cliente ${this.name} efetuado")
                }else {
                    ctx.respond(HttpStatusCode.BadRequest, "Cliente já possui um cadastro no sistema")
                }
            }
        }
    }
}