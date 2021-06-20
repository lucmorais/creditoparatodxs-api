package web.controllers

import domain.Contract
import domain.service.ContractService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

class ContractController(private val contractService: ContractService) {
    suspend fun create(ctx: ApplicationCall) {
        ctx.receive<Contract>().apply {
            contractService.setResumeSimulation(this).apply post@{
                if (this == null) {
                    ctx.respond(HttpStatusCode.BadRequest, "Não foi encontrada uma simulação de crédito aprovada para este CPF")
                    return@post
                }else {
                    contractService.startDateContract(this)
                    ctx.respond(HttpStatusCode.OK, "Contrato de contratação de Crédito Pessoal firmado com sucesso!")
                }
            }
        }
    }
}