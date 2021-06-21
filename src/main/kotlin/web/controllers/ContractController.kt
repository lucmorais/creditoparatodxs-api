package web.controllers

import domain.Contract
import domain.Query
import domain.repository.ContractRepository
import domain.service.ContractService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

class ContractController(private val contractService: ContractService, private val contractRepository: ContractRepository) {
    suspend fun create(ctx: ApplicationCall) {
        ctx.receive<Contract>().apply {
            contractService.setResumeSimulation(this).apply post@{
                if (this == null) {
                    ctx.respond(HttpStatusCode.BadRequest, "Não foi encontrada uma simulação de Crédito Pessoal aprovada para este CPF em nosso sistema, portanto não foi possivel firmar o contrato de contratação")
                    return@post
                }else {
                    contractService.startDateContract(this)
                    ctx.respond(HttpStatusCode.OK, "Contrato de contratação de Crédito Pessoal firmado com sucesso!")
                }
            }
        }
    }

    suspend fun show(ctx: ApplicationCall) {
        ctx.receive<Query>().apply {
            this.cpfClient?.let {
                contractRepository.findContract(it).apply post@{
                    if (this != null) {
                        ctx.respond(this)
                    }else {
                        ctx.respond(HttpStatusCode.BadRequest, "Não foi encontrado um contrato registrado neste CPF")
                        return@post
                    }
                }
            }
        }
    }
}