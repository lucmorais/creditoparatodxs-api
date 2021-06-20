package web.controllers

import domain.Client
import domain.CreditPersonal
import domain.Query
import domain.repository.ResumeSimulationRepository
import domain.service.ResumeSimulationService
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*

class ResumeSimulationController(private val resumeSimulationRepository: ResumeSimulationRepository) {
    suspend fun showResume(ctx: ApplicationCall) {
        ctx.receive<Query>().apply {
            var resume = this.cpfClient?.let { resumeSimulationRepository.getResumeSimulation(it) }

            if (resume != null) {
                ctx.respond(resume)
            }else {
                ctx.respond(HttpStatusCode.BadRequest, "NÃO TEM SIMULAÇÃO CADASTRADA")
            }
        }
    }
}