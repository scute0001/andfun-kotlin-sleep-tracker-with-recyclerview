/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

//Change RecyclerView.Adapter’s parameter to <SleepNightAdapter.ViewHolder>.
//class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
class SleepNightAdapter : RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

//    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
//        val item = data[position]
//        holder.textView.text = item.sleepQuality.toString()
//
//        if (item.sleepQuality <= 1) {
//            holder.textView.setTextColor(Color.RED) // red
//        } else {
//            // reset
//            holder.textView.setTextColor(Color.BLACK) // black
//        }
//    }

    // Change onBindViewHolder’s holder parameter type to ViewHolder, and update views.

//@@change move to Class Viewholder

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = data[position]
//        val res = holder.itemView.context.resources
//        holder.sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
//        holder.quality.text = convertNumericQualityToString(item.sleepQuality, res)
//
////        holder.textView.text = item.sleepQuality.toString()
////        holder.textView.text = """ID: ${item.nightId}
////            |start time: ${convertLongToDateString(item.startTimeMilli)}
////            |end time: ${convertLongToDateString(item.endTimeMilli)}
////            |quality: ${item.sleepQuality}
////            |
////        """.trimMargin()
//
//        holder.qualityImage.setImageResource(when (item.sleepQuality) {
//            0 -> R.drawable.ic_sleep_0
//            1 -> R.drawable.ic_sleep_1
//            2 -> R.drawable.ic_sleep_2
//            3 -> R.drawable.ic_sleep_3
//            4 -> R.drawable.ic_sleep_4
//            5 -> R.drawable.ic_sleep_5
//            else -> R.drawable.ic_sleep_active
//        })

        // Add an if block and set the sleep quality to red
        // if sleepQuality is 1 or less.
        // Add an else clause and reset the color if sleepQuality is 2 or higher.
    //        if (item.sleepQuality <=1) {
    //            holder.textView.setTextColor(Color.RED)
    //        } else {
    //            holder.textView.setTextColor(Color.BLACK)
    //        }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            holder.bind(item)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }





//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
//
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//                .inflate(R.layout.text_item_view, parent, false) as TextView
//        return TextItemViewHolder(view)
//    }

//@@change move to Class Viewholder
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//        // Update view to inflate list_item_sleep_night, and change
//        // return type to ViewHolder.
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater
//                .inflate(R.layout.list_item_sleep_night, parent, false)
//
//        return ViewHolder(view)
//    }

    // Create a ViewHolder class that extends RecyclerView.ViewHolder.




    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        // Refactor the logic for creating the ViewHolder into a function called from().
        // Make the from() function into a companion object.
        // Move the companion object into the ViewHolder class, and have it
        // return a ViewHolder.

        val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
        val quality: TextView = itemView.findViewById(R.id.quality_string)
        val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

        fun bind(item: SleepNight) {
            val res = itemView.context.resources

            sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
            quality.text = convertNumericQualityToString(item.sleepQuality, res)
            qualityImage.setImageResource(when (item.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                        .inflate(R.layout.list_item_sleep_night, parent, false)

                return ViewHolder(view)
            }
        }
    }
}
