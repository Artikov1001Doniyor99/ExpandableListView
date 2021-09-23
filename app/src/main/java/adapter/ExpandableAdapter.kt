package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.modul_5_2_lesson1.R
import kotlinx.android.synthetic.main.child_item.view.*
import kotlinx.android.synthetic.main.group_item.view.*

class ExpandableAdapter(var titleList:List<String>,var map:HashMap<String,List<String>>) : BaseExpandableListAdapter(){



    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return map[titleList[p0]]?.size!!
    }

    override fun getGroup(p0: Int): Any {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        val list = map[titleList[p0]]
        return list?.get(p1)!!
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var groupItemView:View
        if (p2 == null){
            groupItemView = LayoutInflater.from(p3?.context).inflate(R.layout.group_item,p3,false)
        }else{
            groupItemView = p2
        }

        groupItemView.group_tv.text = titleList[p0]
        return groupItemView

    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var childItemView:View
        if (p3 == null){
            childItemView = LayoutInflater.from(p4?.context).inflate(R.layout.child_item,p3,false)
        }else{
            childItemView = p3
        }

        val list = map[titleList[p0]]
        val get = list?.get(p1)
        childItemView.child_tv.text = get
        return childItemView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}