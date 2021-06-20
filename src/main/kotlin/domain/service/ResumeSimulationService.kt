package domain.service

import domain.Client
import domain.CreditPersonal
import domain.ResumeSimulation
import domain.repository.ResumeSimulationRepository

class ResumeSimulationService(private val resumeSimulationRepository: ResumeSimulationRepository) {
    private var resumeSimulation: ResumeSimulation? = null

    fun setClientResumeSimulation(c: Client): Client? {
        var resume = c.cpf?.let { resumeSimulationRepository.getResumeSimulation(it) }
        resumeSimulation = ResumeSimulation()

        return if(resume != null) {
            resumeSimulation?.client = null
            resumeSimulation?.client
        }else {
            resumeSimulation?.client = c
            resumeSimulation?.client
        }
    }

    fun setCreditResumeSimulation(cp: CreditPersonal): CreditPersonal? {
        return if(resumeSimulation?.client != null) {
            resumeSimulation!!.credit = cp
            addResume()
            resumeSimulation!!.credit
        }else {
            null
        }
    }

    private fun addResume() {
        if (resumeSimulation?.client != null && resumeSimulation?.credit != null) {
            resumeSimulation!!.approved = true
            resumeSimulationRepository.addResumeList(resumeSimulation!!)
        }
    }
}