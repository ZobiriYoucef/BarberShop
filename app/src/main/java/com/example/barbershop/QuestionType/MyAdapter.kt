package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
import com.example.barbershop.R

//, Filterable
 class MyAdapter(val context:Context): DragDropSwipeAdapter<SurveyResultDataBaseModule, MyAdapter.ViewHolder>(), Filterable {

     lateinit var filterArray: List<SurveyResultDataBaseModule>


     inner class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {

      val nameOfInvestigator:TextView  = itemView.findViewById(R.id.NameOfInvestigator)
      val phoneNumberOfInvestigator:TextView  = itemView.findViewById(R.id.PhoneNumberOfInvestigator)
      val brandOfInvestigator:ImageView   = itemView.findViewById(R.id.ivBrandOfInvestigator)
      val carModulOfInvestigator:TextView = itemView.findViewById(R.id.tvCarOfInvestigator)
      val ivRimSizeOfInvestigator:ImageView = itemView.findViewById(R.id.ivRimSizeOfInvestigator)
      val rimSizeOfInvestigator:TextView  = itemView.findViewById(R.id.tvRimeSize)

        var pos=0

        fun setDATA(pos: Int, nameOfInvestigator:String, phoneNumberOfInvestigator:String, brandOfInvestigator:String, carModulOfInvestigator:String, rimSizeOfInvestigator:String){

            this.pos=pos

            this.nameOfInvestigator.text=nameOfInvestigator
            this.phoneNumberOfInvestigator.text=phoneNumberOfInvestigator
            when (brandOfInvestigator){
                "0" ->  this.brandOfInvestigator.setImageResource(R.drawable.audi)
                "1" ->  this.brandOfInvestigator.setImageResource(R.drawable.bmw)
                "2" ->  this.brandOfInvestigator.setImageResource(R.drawable.byd)
                "3" ->  this.brandOfInvestigator.setImageResource(R.drawable.chery)
                "4" ->  this.brandOfInvestigator.setImageResource(R.drawable.chevrolet)
                "5" ->  this.brandOfInvestigator.setImageResource(R.drawable.citron)
                "6" ->  this.brandOfInvestigator.setImageResource(R.drawable.dacia)
                "7" ->  this.brandOfInvestigator.setImageResource(R.drawable.daihatsu)
                "8" ->  this.brandOfInvestigator.setImageResource(R.drawable.dfm)
                "9" ->  this.brandOfInvestigator.setImageResource(R.drawable.dfsk)
                "10" -> this.brandOfInvestigator.setImageResource(R.drawable.fiat)
                "11" -> this.brandOfInvestigator.setImageResource(R.drawable.ford)
                "12" -> this.brandOfInvestigator.setImageResource(R.drawable.hyundai)
                "13" -> this.brandOfInvestigator.setImageResource(R.drawable.kia)
                "14" -> this.brandOfInvestigator.setImageResource(R.drawable.land)
                "15" -> this.brandOfInvestigator.setImageResource(R.drawable.lifan)
                "16" -> this.brandOfInvestigator.setImageResource(R.drawable.mahindra)
                "17" -> this.brandOfInvestigator.setImageResource(R.drawable.mazda)
                "18" -> this.brandOfInvestigator.setImageResource(R.drawable.mercedes)
                "19" -> this.brandOfInvestigator.setImageResource(R.drawable.mg)
                "20" -> this.brandOfInvestigator.setImageResource(R.drawable.mini)
                "21" -> this.brandOfInvestigator.setImageResource(R.drawable.mitsubishi)
                "22" -> this.brandOfInvestigator.setImageResource(R.drawable.nissan)
                "23" -> this.brandOfInvestigator.setImageResource(R.drawable.opel)
                "24" -> this.brandOfInvestigator.setImageResource(R.drawable.peugeot)
                "25" -> this.brandOfInvestigator.setImageResource(R.drawable.renault)
                "26" -> this.brandOfInvestigator.setImageResource(R.drawable.seat)
                "27" -> this.brandOfInvestigator.setImageResource(R.drawable.skoda)
                "28" -> this.brandOfInvestigator.setImageResource(R.drawable.suzuki)
                "29" -> this.brandOfInvestigator.setImageResource(R.drawable.toyota)
                "30" -> this.brandOfInvestigator.setImageResource(R.drawable.volkswagen)
                "31" -> this.brandOfInvestigator.setImageResource(R.drawable.other)
            }

            this.carModulOfInvestigator.text=carModulOfInvestigator
            this.ivRimSizeOfInvestigator.setImageResource(R.drawable.cartyers)
            this.rimSizeOfInvestigator.text=rimSizeOfInvestigator
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
         return viewHolder.ivRimSizeOfInvestigator     }

     override fun onBindViewHolder(item: SurveyResultDataBaseModule, viewHolder: ViewHolder, position: Int) {
         val singleFinished=dataSet[position]
         viewHolder.setDATA(
                 position,
                 singleFinished.I1,
                 singleFinished.I2,
                 singleFinished.Q2,
                 singleFinished.Q3,
                 singleFinished.Q3A
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
                             it.I1.contains(value, true)
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