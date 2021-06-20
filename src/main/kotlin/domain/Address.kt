package domain

data class Address (
    var zipCode: String? = null,
    var street: String? = null,
    var number: String? = null,
    var complement: String? = null,
    var uf: String? = null,
    var city: String? = null,
    var district: String? = null
)