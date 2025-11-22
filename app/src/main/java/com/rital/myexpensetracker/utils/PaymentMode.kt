package com.rital.myexpensetracker.utils

enum class PaymentMode(val displayName: String = "") {
    CASH("CASH"),
    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    UPI("UPI"),
    NET_BANKING("NET_BANKING"),
    WALLET("WALLET"),
    OTHER("OTHER");

    companion object {
        fun fromString(value: String): PaymentMode {
            return values().find { it.name.equals(value, ignoreCase = true) } ?: OTHER
        }
    }
}