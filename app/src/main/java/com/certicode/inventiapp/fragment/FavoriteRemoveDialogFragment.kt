package com.certicode.inventiapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.certicode.inventiapp.R
import com.certicode.inventiapp.models.FavoriteModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FavoriteRemoveDialogFragment : BottomSheetDialogFragment() {

    private var favorite: FavoriteModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            favorite = it.getParcelable("favorite")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_remove_favorite_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cancelBtn: Button = view.findViewById(R.id.cancelBtn)
        val removeBtn: Button = view.findViewById(R.id.removeBtn)

        favoriteItem(view)
        cancelBtn.setOnClickListener { dismiss() }
        removeBtn.setOnClickListener {
            // Handle remove logic (e.g., notify adapter / delete from DB)
            dismiss()
        }
    }

    private fun favoriteItem(view: View){
        val imagePlaceHolder: ImageView = view.findViewById(R.id.imagePlaceHolder)
        val titleText: TextView = view.findViewById(R.id.listing_title)
        val locationText: TextView = view.findViewById(R.id.location_text)
        val priceText: TextView = view.findViewById(R.id.price_text)
        val periodText: TextView = view.findViewById(R.id.price_period)
        val textView2: TextView = view.findViewById(R.id.textView2)

        favorite?.let {
            imagePlaceHolder.setImageResource(it.imagePlaceHolder)
            titleText.text = it.title
            locationText.text = it.location
            priceText.text = "$${it.price}"
            periodText.text = it.pricePeriod
            textView2.text = "Remove from Favorites?"
        }
    }

    companion object {
        fun newInstance(favorite: FavoriteModel): FavoriteRemoveDialogFragment {
            val fragment = FavoriteRemoveDialogFragment()
            val bundle = Bundle()
            bundle.putParcelable("favorite", favorite)
            fragment.arguments = bundle
            return fragment
        }
    }
}
