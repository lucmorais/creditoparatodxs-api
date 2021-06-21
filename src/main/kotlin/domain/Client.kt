package domain

import java.util.*

data class Client(
    var id: String? = UUID.randomUUID().toString(),
    var name: String? = null,
    var cpf: String? = null,
    var dateBirth: String? = null,
    var mail: String? = null,
    var cellNumber: String? = null,
    var incomeMonthly: Float? = null,
    var profession: String? = null
)