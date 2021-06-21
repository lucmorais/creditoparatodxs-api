package server

import domain.repository.ContractRepository
import domain.repository.ResumeSimulationRepository
import domain.service.ClientService
import domain.service.ContractService
import domain.service.CreditService
import domain.service.ResumeSimulationService
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import web.controllers.ClientController
import web.controllers.ContractController
import web.controllers.CreditController
import web.controllers.ResumeSimulationController

object Config {
    private val clientModule = Kodein.Module("CLIENT"){
        bind() from singleton { ClientController(instance()) }
        bind() from singleton { ClientService(instance(), instance()) }
    }

    private val creditModule = Kodein.Module("CREDIT"){
        bind() from singleton { CreditController(instance()) }
        bind() from singleton { CreditService(instance(), instance()) }
    }

    private val resumeModule = Kodein.Module("RESUME"){
        bind() from singleton { ResumeSimulationController(instance()) }
        bind() from singleton { ResumeSimulationService(instance()) }
        bind() from singleton { ResumeSimulationRepository() }
    }

    private val contractModule = Kodein.Module("CONTRACT"){
        bind() from singleton { ContractController(instance(), instance()) }
        bind() from singleton { ContractService(instance(), instance()) }
        bind() from singleton { ContractRepository() }
    }

    internal val kodein = Kodein {
        import(resumeModule)
        import(clientModule)
        import(creditModule)
        import(contractModule)
    }
}