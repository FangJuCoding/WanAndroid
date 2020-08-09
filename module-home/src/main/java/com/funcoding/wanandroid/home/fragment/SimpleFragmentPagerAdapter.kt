package com.funcoding.wanandroid.home.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SimpleFragmentPagerAdapter(
    fm: FragmentManager,
    private val fragmentList: List<Fragment>,
    private val titles: List<String>? = null
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    init {
        require(!(titles != null && titles.size != fragmentList.size)) {
            "Fragment的数量必须和标题的数量匹配"
        }
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getItemId(position: Int): Long = fragmentList[position].hashCode().toLong()

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titles?.get(position)
}