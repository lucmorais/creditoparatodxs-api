package web

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.h1
import web.controllers.ClientController
import web.controllers.ContractController
import web.controllers.CreditController
import web.controllers.ResumeSimulationController

fun Route.index() {
    route("/index") {
        get {
            call.respondHtml {
                body {
                    h1 { +"Inicio da API" }
                }
            }
        }
    }
}

fun Route.client(clientController: ClientController) {
    route("/client") {
        post { clientController.register(this.context) }
    }
}

fun Route.credit(creditController: CreditController) {
    route("/credit") {
        post { creditController.choose(this.context) }
    }
}

fun Route.resume(resumeSimulationController: ResumeSimulationController) {
    route("/resume") {
        get { resumeSimulationController.showResume(this.context) }
    }
}

fun Route.contract(contractController: ContractController) {
    route("/contract") {
        post { contractController.create(this.context) }
    }
}