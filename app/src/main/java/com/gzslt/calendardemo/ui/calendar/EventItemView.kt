package com.gzslt.calendardemo.ui.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.gzslt.calendardemo.R
import com.gzslt.calendardemo.databinding.ViewEventItemBinding
import com.gzslt.calendardemo.model.EventPresentationModel
import java.time.format.DateTimeFormatter
import java.util.Locale

class EventItemView : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setPadding(resources.getDimensionPixelSize(R.dimen.margin_padding_size_mini))
    }

    private val binding =
        ViewEventItemBinding.inflate(LayoutInflater.from(context), this)

    fun bind(model: EventPresentationModel) {
        val startEndTimeFormatter =
            DateTimeFormatter.ofPattern("HH:mm", Locale.forLanguageTag("hu-HU"))
        with(binding) {
            startTextView.text = startEndTimeFormatter.format(model.startDate)
            endTextView.text = startEndTimeFormatter.format(model.endDate)
            nameTextView.text = model.name
            venueTextView.text = model.venue
            eventCategory.text = model.category

            // TODO set common color of baseline and category
            binding.cardBaseLineView.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.bright_sun
                )
            )
        }
    }
}
