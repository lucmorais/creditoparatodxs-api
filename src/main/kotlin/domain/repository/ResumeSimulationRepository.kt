package domain.repository

import domain.Client
import domain.CreditPersonal
import domain.ResumeSimulation

class ResumeSimulationRepository {
    private val resumes = mutableListOf<ResumeSimulation>()

    fun findResumeCredit(cp: CreditPersonal): ResumeSimulation? {
        return resumes.firstOrNull {
            it.credit?.goal == cp.goal && it.credit?.quantityPortion == cp.quantityPortion && it.credit?.valueCredit == cp.valueCredit
                    && it.credit?.valuePortion == cp.valuePortion
        }
    }

    fun addResumeList(r: ResumeSimulation) {
        resumes.add(r)
    }

    fun getResumeSimulation(cpf: String): ResumeSimulation? {
        return resumes.firstOrNull {
            it.client?.cpf == cpf
        }
    }
}