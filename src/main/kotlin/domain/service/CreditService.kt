package domain.service

import domain.CreditPersonal
import domain.repository.ResumeSimulationRepository

class CreditService(private val resumeSimulationRepository: ResumeSimulationRepository, private val resumeSimulationService: ResumeSimulationService) {
    fun applyCredit(cp: CreditPersonal): CreditPersonal? {
        var credit = calcValuePortion(cp)
        return credit?.let { resumeSimulationService.setCreditResumeSimulation(it) }
    }

    private fun calcValuePortion(cp: CreditPersonal): CreditPersonal? {
        return if(cp.quantityPortion != null && cp.valueCredit != null) {
            cp.valuePortion = (cp.valueCredit!! / cp.quantityPortion!!) * cp.fees
            cp
        }else {
            null
        }
    }
}