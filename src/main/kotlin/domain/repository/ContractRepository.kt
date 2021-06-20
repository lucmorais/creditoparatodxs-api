package domain.repository

import domain.Contract

class ContractRepository {
    private val contracts = mutableListOf<Contract>()

    fun findContract(cpf: String): Contract? {
        return contracts.firstOrNull {
            it.resumeSimulation?.client?.cpf == cpf
        }
    }

    fun addListContracts(contract: Contract) {
        contracts.add(contract)
    }
}