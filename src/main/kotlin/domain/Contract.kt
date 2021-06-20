package domain

data class Contract (
    var resumeSimulation: ResumeSimulation? = null,
    val signatureFirstLastName: String? = null,
    var signatureDate: Int? = null,
    var cpfClient: String? = null
)