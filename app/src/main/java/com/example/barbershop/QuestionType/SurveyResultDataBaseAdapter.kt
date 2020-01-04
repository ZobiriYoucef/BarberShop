package com.example.barbershop.QuestionType

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershop.R
import kotlinx.android.synthetic.main.list_item.view.*


class SurveyResultDataBaseAdapter(private val context: Context) :
        RecyclerView.Adapter<SurveyResultDataBaseAdapter.SurveyResultDataBaseViewHolder>() {

    private lateinit var finishedSurveyResultList:ArrayList<SurveyResultDataBaseModule>

    val TAG= SurveyResultDataBaseAdapter::class.java.name


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ): SurveyResultDataBaseViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return SurveyResultDataBaseViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return   finishedSurveyResultList.size
    }

    override fun onBindViewHolder(holder: SurveyResultDataBaseViewHolder, position: Int) {
   val singleFinished=finishedSurveyResultList[position]
        holder.setDATA(
                position,
                singleFinished.I1,
                singleFinished.I2,
                singleFinished.Q2,
                singleFinished.Q3,
                singleFinished.Q3A
                )

        holder.setListener()
    }

    fun setFinishedSurveyResult(FinishedSurveyResult: ArrayList<SurveyResultDataBaseModule>) {
        finishedSurveyResultList=FinishedSurveyResult
        notifyDataSetChanged()
    }

   inner  class SurveyResultDataBaseViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var pos=0

        fun setDATA(pos: Int,
                    nameOfInvestigator:String,
                    phoneNumberOfInvestigator:String,
                    brandOfInvestigator:String,
                    carModulOfInvestigator:String,
                    rimSizeOfInvestigator:String){

            this.pos=pos

            itemView.NameOfInvestigator.text=nameOfInvestigator
            itemView.PhoneNumberOfInvestigator.text=phoneNumberOfInvestigator
            when (brandOfInvestigator){
                "0" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.audi)
                "1" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.bmw)
                "2" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.byd)
                "3" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.chery)
                "4" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.chevrolet)
                "5" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.citron)
                "6" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.dacia)
                "7" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.daihatsu)
                "8" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.dfm)
                "9" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.dfsk)
                "10" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.fiat)
                "11" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.ford)
                "12" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.hyundai)
                "13" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.kia)
                "14" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.land)
                "15" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.lifan)
                "16" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mahindra)
                "17" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mazda)
                "18" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mercedes)
                "19" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mg)
                "20" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mini)
                "21" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.mitsubishi)
                "22" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.nissan)
                "23" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.opel)
                "24" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.peugeot)
                "25" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.renault)
                "26" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.seat)
                "27" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.skoda)
                "28" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.suzuki)
                "29" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.toyota)
                "30" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.volkswagen)
                "31" -> itemView.ivBrandOfInvestigator.setImageResource(R.drawable.other)
            }

           itemView.tvCarOfInvestigator.text=carModulOfInvestigator
           itemView.ivRimSizeOfInvestigator.setImageResource(R.drawable.cartyers)
           itemView.tvRimeSize.text=rimSizeOfInvestigator
        }

        fun setListener() {
            itemView.setOnClickListener {
            /*val dataBaseHelperClass=DataBaseHelperClass(context)
            val singleSurveyResult=DataManger.fetchASingleResponse(dataBaseHelperClass,finishedSurveyResultList[pos].id)

            Log.i(TAG,singleSurveyResult.toString())*/
            val intent=Intent(context,SingleSurveyResult::class.java)
                intent.putExtra(IrisTyres.DataBaseTableEntry.COLUMN_ID,finishedSurveyResultList[pos].id)
                (context as Activity).startActivityForResult(intent,2)
            }
        }
    }


}