package cn.funcoding.wanandroid.base.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import cn.funcoding.wanandroid.base.R

class HorizontalView : LinearLayout {
    private lateinit var leftIcon: ImageView
    private lateinit var titleTv: TextView
    private lateinit var descTv: TextView
    private lateinit var rightIcon: ImageView

    var title: String? = null
    var titleTextColor: Int = Color.WHITE

    var leftIconDrawable: Drawable? = null
    var leftIconTint: Int = Color.WHITE

    var desc: String? = null
    var descTextColor: Int = Color.WHITE

    var rightIconDrawable: Drawable? = null
    var rightIconTint: Int = Color.WHITE

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        inflate(context, R.layout.base_horizontal_view, this)
        leftIcon = findViewById(R.id.leftIcon)
        titleTv = findViewById(R.id.title)
        descTv = findViewById(R.id.desc)
        rightIcon = findViewById(R.id.rightIcon)

        if (attrs != null) {
            val array = context.obtainStyledAttributes(attrs, R.styleable.HorizontalView)
            leftIconDrawable = array.getDrawable(R.styleable.HorizontalView_leftIcon)
            leftIconTint = array.getColor(R.styleable.HorizontalView_leftIconTint, Color.WHITE)

            title = array.getString(R.styleable.HorizontalView_title)
            titleTextColor = array.getColor(R.styleable.HorizontalView_titleTextColor, Color.WHITE)

            desc = array.getString(R.styleable.HorizontalView_desc)
            descTextColor = array.getColor(R.styleable.HorizontalView_descTextColor, Color.WHITE)

            rightIconDrawable = array.getDrawable(R.styleable.HorizontalView_leftIcon)
            rightIconTint = array.getColor(R.styleable.HorizontalView_leftIconTint, Color.WHITE)

            array.recycle()
        }


    }

}