package domain.service

import domain.Client
import domain.repository.ResumeSimulationRepository

class ClientService(private val resumeSimulationService: ResumeSimulationService, private val resumeSimulationRepository: ResumeSimulationRepository) {
    fun createClient(c: Client): Client? {
        return resumeSimulationService.setClientResumeSimulation(c)
    }
}