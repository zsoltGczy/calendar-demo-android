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
import com.gzslt.calendardemo.databinding.LayoutCalendarDayBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.kizitonwose.calendarview.utils.yearMonth
import dagger.hilt.android.AndroidEntryPoint
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@AndroidEntryPoint
class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private var selectedDate: LocalDate? = null
    private val daysOfWeek = DayOfWeek.values()

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
        setCalendarDays()
    }

    private fun setLegendLayout() {
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

    private fun setCalendarDays() {
        val currentMonth = YearMonth.now()
        val startMonth = currentMonth.minusMonths(10)
        val endMonth = currentMonth.plusMonths(10)
        binding.calendarView.setup(startMonth, endMonth, daysOfWeek.first())
        binding.calendarView.scrollToMonth(currentMonth)

        class DayViewContainer(view: View) : ViewContainer(view) {
            lateinit var day: CalendarDay
            val textView = LayoutCalendarDayBinding.bind(view).dayTextView

            init {
                view.setOnClickListener {
                    if (selectedDate == day.date) {
                        selectedDate = null
                        binding.calendarView.notifyDayChanged(day)
                    } else {
                        if (day.owner != DayOwner.THIS_MONTH) {
                            binding.calendarView.scrollToDate(day.date)
                        }
                        val oldDate = selectedDate
                        selectedDate = day.date
                        binding.calendarView.notifyDateChanged(day.date)
                        oldDate?.let { binding.calendarView.notifyDateChanged(oldDate) }
                    }
                }
            }
        }

        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                // TODO add event dots
                container.day = day
                val textView = container.textView
                textView.text = day.date.dayOfMonth.toString()
                if (day.owner == DayOwner.THIS_MONTH) {
                    when (day.date) {
                        selectedDate -> {
                            textView.setBackgroundResource(R.drawable.shape_selected_date_background)
                        }
                        LocalDate.now() -> {
                            textView.setTextColorRes(R.color.today_date)
                            textView.background = null
                        }
                        else -> {
                            textView.setTextColorRes(R.color.calendar_date_text)
                            textView.background = null
                        }
                    }
                } else {
                    textView.setTextColorRes(R.color.calendar_date_text_not_current_month)
                    textView.background = null
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
