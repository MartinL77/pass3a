package com.example.pass3a

import android.content.Context

object CsvReader {

    fun readMedallists(context: Context): List<Medallist> {

        val medallists = mutableListOf<Medallist>()

        context.resources.openRawResource(R.raw.medallists)
            .bufferedReader()
            .readLines()
            .drop(1)
            .forEach { line ->

                val parts = line.split(",")

                if (parts.size >= 6) {

                    try {

                        val country = parts[0]
                        val code = parts[1]
                        val timesCompeted = parts[2].toInt()
                        val gold = parts[3].toInt()
                        val silver = parts[4].toInt()
                        val bronze = parts[5].toInt()

                        medallists.add(
                            Medallist(
                                country = country,
                                code = code,
                                timesCompeted = timesCompeted,
                                gold = gold,
                                silver = silver,
                                bronze = bronze
                            )
                        )

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

        return medallists
    }
}