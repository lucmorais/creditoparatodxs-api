package server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.request.*
import io.ktor.routing.*
import org.kodein.di.generic.instance
import org.slf4j.event.Level
import web.*
import web.controllers.ClientController
import web.controllers.ContractController
import web.controllers.CreditController
import web.controllers.ResumeSimulationController

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads

fun Application.module(testing: Boolean = false) {
    val clientController by Config.kodein.instance<ClientController>()
    val creditController by Config.kodein.instance<CreditController>()
    val contractController by Config.kodein.instance<ContractController>()
    val resumeController by Config.kodein.instance<ResumeSimulationController>()

    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            disableHtmlEscaping()
        }
    }

    install(Routing) {
        index()
        client(clientController)
        credit(creditController)
        contract(contractController)
        resume(resumeController)
    }
}
