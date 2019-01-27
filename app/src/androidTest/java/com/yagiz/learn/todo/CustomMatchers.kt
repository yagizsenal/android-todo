package com.yagiz.learn.todo

import android.support.test.espresso.matcher.BoundedMatcher
import android.support.v7.widget.RecyclerView
import android.view.View
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

object RecyclerViewMatchers {
    var recyclerViewId : Int? = null

    fun withItemCount(itemCount: Int): BoundedMatcher<View, RecyclerView> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun matchesSafely(item: RecyclerView?): Boolean {
                return item?.adapter?.itemCount == itemCount
            }

            override fun describeTo(description: Description?) {
                description?.appendText("has $itemCount items.")
            }

        }
    }

    fun atPosition(position: Int): TypeSafeMatcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, targetViewId: Int): TypeSafeMatcher<View> {
        return object : TypeSafeMatcher<View>() {
            private var childView: View? = null

            override fun matchesSafely(view: View?): Boolean {
                if (childView == null) {
                    val recyclerView = view?.rootView?.findViewById<RecyclerView>(recyclerViewId!!)
                    if (recyclerView != null && recyclerView.id == recyclerViewId) {
                        childView =
                            recyclerView.findViewHolderForAdapterPosition(position)?.itemView
                    } else {
                        return false
                    }
                }
                if (position == -1) {
                    return view == childView
                }
                return view == childView?.findViewById(targetViewId)
            }

            override fun describeTo(description: Description?) {
            }

        }
    }
}

