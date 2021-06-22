package domain.service

import domain.Contract
import domain.ResumeSimulation
import domain.repository.ContractRepository
import domain.repository.ResumeSimulationRepository
import java.text.SimpleDateFormat
import java.util.*

class ContractService(private val contractRepository: ContractRepository, private val resumeSimulationRepository: ResumeSimulationRepository) {
    fun setResumeSimulation(contract: Contract): Contract? {
        var resume = contract.cpfClient?.let { resumeSimulationRepository.getResumeSimulation(it) }

        return if (resume != null) {
            contract.resumeSimulation = resume
            contract
        }else {
            null
        }
    }

    fun startDateContract(contract: Contract): Contract? {
        return if (contract.signatureFirstLastName != null) {
            val sdf = SimpleDateFormat("dd/M/yyyy")
            val currentDate = sdf.format(Date())
            contract.signatureDate = currentDate.toString()
            addContract(contract)
            contract
        }else {
            null
        }
    }

    private fun addContract(contract: Contract) {
        if (contract.cpfClient?.let { contractRepository.findContract(it) } == null) {
            contractRepository.addListContracts(contract)
        }
    }
}