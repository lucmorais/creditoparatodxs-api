package domain

data class ResumeSimulation (
    var credit: CreditPersonal? = CreditPersonal(),
    var client: Client? = Client(),
    var approved: Boolean? = null
)