package domain

data class CreditPersonal (
    var valueCredit: Float? = null,
    var quantityPortion: Int? = null,
    var valuePortion: Float? = null,
    var fees: Float = 0.041F,
    var goal: String? = null
)