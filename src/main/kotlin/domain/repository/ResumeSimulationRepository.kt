package domain.repository

import domain.Client
import domain.CreditPersonal
import domain.ResumeSimulation

class ResumeSimulationRepository {
    private val resumes = mutableListOf<ResumeSimulation>()

    fun addResumeList(r: ResumeSimulation) {
        if (r.credit == null) {
            resumes.add(r)
        }else {
            var resume = getResumeCreditNull()
            resumes.remove(resume)
            resumes.add(r)
        }
    }

    fun getResumeSimulation(cpf: String): ResumeSimulation? {
        return resumes.firstOrNull {
            it.client?.cpf == cpf
        }
    }

    fun getResumeCreditNull(): ResumeSimulation? {
        return resumes.firstOrNull {
            it.client != null && it.credit == null
        }
    }
}