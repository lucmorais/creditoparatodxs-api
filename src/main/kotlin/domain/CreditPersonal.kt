package domain

data class CreditPersonal (
    var valueCredit: Float? = null,
    var quantityPortion: Int? = null,
    var valuePortion: Float? = null,
    var fees: Float = 0.008F,
    var goal: String? = null
)