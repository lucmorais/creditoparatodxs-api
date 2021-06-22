package web

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
import web.controllers.ClientController
import web.controllers.ContractController
import web.controllers.CreditController
import web.controllers.ResumeSimulationController

fun Route.index() {
    route("/") {
        get {
            call.respondHtml {
                body {
                    h1 { +"API Crédito Para Todxs" }
                    p {+"Segue abaixo os Endpoints da API:"}
                    ul {
                        ol { +"POST - /client          - Cadastrar um cliente"}
                        ol { +"GET  - /credit/ofert    - Consultar a oferta de crédito da empresa"}
                        ol { +"POST - /credit/insert   - Inserir a oferta de crédito do cliente"}
                        ol { +"GET  - /resume          - Consultar o detalhamento da simulação após o cadastro do cliente e do crédito"}
                        ol { +"POST - /contract/insert - Cadastrar o contrato"}
                        ol { +"GET  - /contract/show   - Consultar o contrato" }
                    }
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
    route("/credit/ofert") {
        get {
            call.respondHtml {
                body {
                    h1 { +"Crédito Para Todxs" }
                    p { +"Detalhes do crédito"}
                    h3 {+"Valor do crédito: de R$ 2.000,00 até R$ 30.000,00"}
                    h3 {+"Parcelas: 12, 24 ou 36 vezes"}
                    h3 {+"Juros: 0,8%"}
                }
            }
        }
    }
    route("/credit/insert") {
        post { creditController.choose(this.context) }
    }
}

fun Route.resume(resumeSimulationController: ResumeSimulationController) {
    route("/resume") {
        get { resumeSimulationController.showResume(this.context) }
    }
}

fun Route.contract(contractController: ContractController) {
    route("/contract/insert") {
        post { contractController.create(this.context) }
    }
    route("/contract/show") {
        get { contractController.show(this.context)}
    }
}