package com.example.pass3a

data class Medallist(
    val country: String,
    val code: String,
    val timesCompeted: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
) {
    val totalMedals: Int
        get() = gold + silver + bronze
}