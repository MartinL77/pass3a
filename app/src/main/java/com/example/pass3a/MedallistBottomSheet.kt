package com.example.pass3a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MedallistBottomSheet : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(medallist: Medallist): MedallistBottomSheet {
            val sheet = MedallistBottomSheet()
            val args = Bundle()

            args.putString("country", medallist.country)
            args.putString("code", medallist.code)
            args.putInt("gold", medallist.gold)
            args.putInt("silver", medallist.silver)
            args.putInt("bronze", medallist.bronze)
            args.putInt("total", medallist.totalMedals)

            sheet.arguments = args
            return sheet
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.bottom_sheet_medallist, container, false)

        val country = arguments?.getString("country") ?: ""
        val code = arguments?.getString("code") ?: ""
        val gold = arguments?.getInt("gold") ?: 0
        val silver = arguments?.getInt("silver") ?: 0
        val bronze = arguments?.getInt("bronze") ?: 0
        val total = arguments?.getInt("total") ?: 0

        view.findViewById<TextView>(R.id.sheetTitle).text = country
        view.findViewById<TextView>(R.id.sheetDetails).text =
            "IOC Code: $code\nGold: $gold\nSilver: $silver\nBronze: $bronze\nTotal medals: $total"

        return view
    }
}