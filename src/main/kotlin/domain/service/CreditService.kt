package domain.service

import domain.CreditPersonal
import domain.repository.ResumeSimulationRepository

class CreditService(private val resumeSimulationRepository: ResumeSimulationRepository, private val resumeSimulationService: ResumeSimulationService) {
    fun applyCredit(cp: CreditPersonal): CreditPersonal? {
        var credit = calcValuePortion(cp)

        return credit?.let { resumeSimulationService.setCreditResumeSimulation(it) }
    }

    private fun calcValuePortion(cp: CreditPersonal): CreditPersonal? {
        return if (cp.quantityPortion != null && cp.valueCredit != null) {
            var percentage = cp.valueCredit!! * cp.fees
            cp.valuePortion =  (cp.valueCredit!! / cp.quantityPortion!!) + (percentage/ cp.quantityPortion!!)
            cp
        }else {
            null
        }
    }
}