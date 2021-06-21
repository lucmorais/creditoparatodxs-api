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

        return if (resume != null) {
            null
        }else {
            resumeSimulation?.client = c
            resumeSimulationRepository.addResumeList(resumeSimulation!!)
            resumeSimulation!!.client
        }
    }

    fun setCreditResumeSimulation(cp: CreditPersonal): CreditPersonal? {
        return if (resumeSimulation?.client != null) {
            resumeSimulation!!.credit = cp
            resumeSimulation!!.approved = true
            addCreditResume(resumeSimulation!!)
            resumeSimulation!!.credit
        }else {
            null
        }
    }

    private fun addCreditResume(resumeSimulation: ResumeSimulation) {
        var resume = resumeSimulationRepository.getResumeCreditNull()

        if (resume != null) {
            resume = resumeSimulation
            resumeSimulationRepository.addResumeList(resume)
        }
    }
}