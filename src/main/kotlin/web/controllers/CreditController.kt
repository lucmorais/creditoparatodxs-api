package web.controllers

import domain.CreditPersonal
import domain.service.CreditService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

class CreditController(private val creditService: CreditService) {
    suspend fun choose(ctx: ApplicationCall) {
        ctx.receive<CreditPersonal>().apply {
            creditService.applyCredit(this).apply post@{
                if (this == null) {
                    ctx.respond(HttpStatusCode.BadRequest, "A oferta de Crédito Pessoal só pode ser simulada após o cadastro do cliente")
                    return@post

                }else {
                    ctx.respond(this)
                }
            }
        }
    }
}