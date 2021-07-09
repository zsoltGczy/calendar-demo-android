package com.gzslt.calendardemo.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.gzslt.calendardemo.R
import com.gzslt.calendardemo.common.extension.setTextColorRes
import com.gzslt.calendardemo.databinding.FragmentCalendarBinding
import dagger.hilt.android.AndroidEntryPoint
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLegendLayout()
    }

    private fun setLegendLayout() {
        val daysOfWeek = DayOfWeek.values()
        binding.legendLayout.root.children.forEachIndexed { index, dayNameView ->
            (dayNameView as TextView).apply {
                text =
                    daysOfWeek[index].getDisplayName(
                        TextStyle.SHORT,
                        Locale.forLanguageTag("hu-HU")
                    ).uppercase()

                setTextColorRes(R.color.legend_day)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
