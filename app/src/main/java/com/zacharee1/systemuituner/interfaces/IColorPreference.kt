package com.zacharee1.systemuituner.interfaces

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import androidx.preference.PreferenceViewHolder
import androidx.recyclerview.widget.RecyclerView
import com.zacharee1.systemuituner.R
import kotlinx.android.synthetic.main.custom_preference.view.*

interface IColorPreference {
    var iconColor: Int

    fun bindVH(holder: RecyclerView.ViewHolder)
}

class ColorPreference(context: Context, attrs: AttributeSet?) :
    IColorPreference {
    override var iconColor: Int = Int.MIN_VALUE

    init {
        if (attrs != null) {
            val array = context.theme.obtainStyledAttributes(attrs, R.styleable.ColorPreference, 0, 0)

            iconColor = array.getColor(R.styleable.ColorPreference_icon_color, Int.MIN_VALUE)
        }
    }

    override fun bindVH(holder: RecyclerView.ViewHolder) {
        holder.itemView.icon_frame.apply {
            (background as StateListDrawable).apply {
                val drawable = getStateDrawable(1)

                if (iconColor != Int.MIN_VALUE) {
                    drawable.setColorFilter(iconColor, PorterDuff.Mode.SRC_ATOP)
                } else {
                    drawable.clearColorFilter()
                }
            }
        }
    }
}