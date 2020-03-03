package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
import com.example.barbershop.R
import com.example.barbershop.utils.FileUtils
import java.io.FileInputStream
import java.io.InputStream

//, Filterable
 class MyAdapter(val context:Context): DragDropSwipeAdapter<SurveyResultDataBaseModule, MyAdapter.ViewHolder>(), Filterable {

     lateinit var filterArray: List<SurveyResultDataBaseModule>


     inner class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {

      val nameOfInvestigator:TextView  = itemView.findViewById(R.id.NameOfInvestigator)
      val jobOfInvestigator:TextView  = itemView.findViewById(R.id.JobOfInvestigator)
      val cardImageOfInvestigator:ImageView   = itemView.findViewById(R.id.ivCardOfInvestigator)
      val tvCompanyName:TextView = itemView.findViewById(R.id.tvCompanyName)
      val tvPhoneNumber:TextView  = itemView.findViewById(R.id.tvPhoneNumber)

        var pos=0

        fun setDATA(pos: Int, nameOfInvestigator:String,
                    CompanyNameOfInvestigator:String,
                    jobOfInvestigator:String,
                    phoneNumberOfInvestigator:String,
                    ImagePathOfInvestigator:String
                    ){

            this.pos=pos

            this.nameOfInvestigator.text=nameOfInvestigator
            this.jobOfInvestigator.text=jobOfInvestigator
            this.tvCompanyName.text=CompanyNameOfInvestigator
            this.tvPhoneNumber.text=phoneNumberOfInvestigator

            if(ImagePathOfInvestigator.equals("")){
                this.cardImageOfInvestigator.setImageResource(R.drawable.camera_icon)
            }else{
                val uri = Uri.parse(ImagePathOfInvestigator)
                val file = FileUtils.getFile(context, uri)
                val inputStream: InputStream = FileInputStream(file)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                this.cardImageOfInvestigator.setImageBitmap(bitmap)
            }

        }

        fun setListener() {
            itemView.setOnClickListener {
              val intent= Intent(context,SingleSurveyResult::class.java)
                intent.putExtra(IrisTyres.DataBaseTableEntry.COLUMN_ID,dataSet[pos].id)
                (context as Activity).startActivityForResult(intent,2)
            }
        }

    }

     override fun getViewHolder(itemView: View) = ViewHolder(itemView)

     override fun getViewToTouchToStartDraggingItem(item: SurveyResultDataBaseModule, viewHolder: ViewHolder, position: Int): View? {
         return viewHolder.cardImageOfInvestigator     }

     override fun onBindViewHolder(item: SurveyResultDataBaseModule, viewHolder: ViewHolder, position: Int) {
         val singleFinished=dataSet[position]
         viewHolder.setDATA(
                 position,
                 singleFinished.I3,
                 singleFinished.I4,
                 singleFinished.I5,
                 singleFinished.I6,
                 singleFinished.I10
         )
         viewHolder.setListener()

     }

     fun setFinishedSurveyResult(FinishedSurveyResult: ArrayList<SurveyResultDataBaseModule>) {
         dataSet=FinishedSurveyResult
         filterArray= ArrayList(FinishedSurveyResult)
         notifyDataSetChanged()
     }


     override fun getFilter(): Filter =
             object : Filter() {
                 override fun performFiltering(value: CharSequence?): FilterResults {
                     val results = FilterResults()
                     if (value.isNullOrEmpty()) {
                         results.values = dataSet
                     } else {
                         val dataSet2 = filterArray.filter {
                             it.I3.contains(value, true)
                         }
                         results.values = dataSet2
                     }
                     return results
                 }
                 override fun publishResults(value: CharSequence?, results: FilterResults?) {
                     dataSet = (results?.values as? List<SurveyResultDataBaseModule>).orEmpty()
                     notifyDataSetChanged()
                 }
             }



 }