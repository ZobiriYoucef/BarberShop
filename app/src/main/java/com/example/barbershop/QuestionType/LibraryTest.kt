package com.example.barbershop.QuestionType

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieAnimationView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnListScrollListener
import com.example.barbershop.R
import com.example.barbershop.UsePhoneCamera
import com.mancj.materialsearchbar.MaterialSearchBar
import com.mancj.materialsearchbar.MaterialSearchBar.OnSearchActionListener
import com.neeloy.lib.data.storage.StorageUtility
import com.orhanobut.hawk.Hawk
import com.shreyaspatil.MaterialDialog.MaterialDialog
import kotlinx.android.synthetic.main.activity_library_test.*


class LibraryTest : AppCompatActivity() , OnSearchActionListener {

    private lateinit var dataBaseHelper:DataBaseHelperClass
    val mAdapter =MyAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_test)

        // hawk storge init
        Hawk.init(this).build()

        //Esay data storge
        StorageUtility.initLibrary(this)

        //************* Menu
        searchBar.inflateMenu(R.menu.searchbarmenu)
        searchBar.getMenu().setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener, androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener {
            override fun onMenuItemClick(item:MenuItem):Boolean {
                when (item.itemId) {
                    R.id.id1 -> Toast.makeText(applicationContext,"1111",Toast.LENGTH_LONG).show()
                }
                return false
            }
        })

        //searchBar.setSpeechMode(true)
        searchBar.setOnSearchActionListener(this)
        searchBar.setHint("Name!!")
        //searchBar.setText("Hello World!")
        searchBar.setCardViewElevation(10)

        if (Hawk.contains("Suggestions")) {
            searchBar.lastSuggestions = Hawk.get("Suggestions")
        }


        searchBar.addTextChangeListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
               //Toast.makeText(this@LibraryTest,charSequence,Toast.LENGTH_LONG).show()
                if (charSequence.isEmpty()){
                    mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
                } else {
                    mAdapter.filter.filter(charSequence)
                }

            }

            override fun afterTextChanged(editable: Editable) {}
        })

        //*************************************Collect info
        dataBaseHelper= DataBaseHelperClass(this)
        val allResults=DataManger.fetchAllResults(dataBaseHelper)
        mAdapter.setFinishedSurveyResult(allResults)

        //***********************************setup the adopter
        mList2.layoutManager = LinearLayoutManager(this)
        mList2.adapter = mAdapter

        val onItemSwipeListener = object : OnItemSwipeListener<SurveyResultDataBaseModule> {
            @SuppressLint("RestrictedApi")
            override fun onItemSwiped(position: Int, direction: OnItemSwipeListener.SwipeDirection, item: SurveyResultDataBaseModule): Boolean {
                // Handle action of item swiped
                // Return false to indicate that the swiped item should be removed from the adapter's data set (default behaviour)
                // Return true to stop the swiped item from being automatically removed from the adapter's data set (in this case, it will be your responsibility to manually update the data set as necessary)
                /*Toast.makeText(this@StartASurveyEnhance,position.toString(),Toast.LENGTH_LONG).show()
                Toast.makeText(this@StartASurveyEnhance,item.id,Toast.LENGTH_LONG).show()*/

                val mDialog = MaterialDialog.Builder(this@LibraryTest)
                        .setTitle("Delete?")
                        .setMessage("Are you sure want to delete this file?")
                        .setCancelable(false)
                        .setAnimation(R.raw.delte)
                        .setPositiveButton("Delete", R.drawable.ic_account_circle_black_24dp) { dialogInterface, which ->
                            // Delete Operation
                            DataManger.deleteASingleResponse(dataBaseHelper,item.id)
                            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
                            dialogInterface.dismiss()
                        }
                        .setNegativeButton("Cancel", R.drawable.ic_add) {
                            dialogInterface,which -> dialogInterface.dismiss()
                            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))}
                        .build()
                mDialog.show()

                // Get Animation View
                val animationView: LottieAnimationView = mDialog.getAnimationView()
                //TODO Do operations on animationView
                return true
            }
        }

        val onListScrollListener = object : OnListScrollListener {
            @SuppressLint("RestrictedApi")
            override fun onListScrollStateChanged(scrollState: OnListScrollListener.ScrollState) {
                // Handle change on list scroll state
                if(scrollState== OnListScrollListener.ScrollState.IDLE){
                    fab3.visibility= View.VISIBLE
                }else{
                    fab3.visibility= View.INVISIBLE
                }
            }

            @SuppressLint("RestrictedApi")
            override fun onListScrolled(scrollDirection: OnListScrollListener.ScrollDirection, distance: Int) {
            }
        }

        mList2.orientation = DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING
        mList2.orientation?.removeSwipeDirectionFlag(DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.LEFT)

        mList2.swipeListener = onItemSwipeListener
        mList2.scrollListener = onListScrollListener

        //********************************behind_swiped_item   1

        // *******************by Icons and colors
        /* mList.behindSwipedItemIconDrawableId = R.drawable.camera_icon
         mList.behindSwipedItemIconMargin = 20f //0 if not specified; ignored if behind_swiped_item_icon_centered is true.
         mList.behindSwipedItemCenterIcon = false
         mList.behindSwipedItemBackgroundColor =R.color.Blue*/

        //*********************by a layout (main direction)
        mList2.behindSwipedItemLayoutId = R.layout.swiped_item_main_direction_layout

        //**********************************behind_swiped_item_secondary 2
        // *****************by Icons and colors
        /*
        mList.behindSwipedItemIconSecondaryDrawableId = R.drawable.ic_account_circle_black_24dp
        mList.behindSwipedItemBackgroundSecondaryColor =R.color.Green*/

        //parameter
        mList2.reduceItemAlphaOnSwiping = true
        mList2.longPressToStartDragging = true

        fab3.setOnClickListener {
            val GoToUseCameraPhone = Intent(this, UsePhoneCamera::class.java)
            startActivityForResult(GoToUseCameraPhone, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
        }
    }



    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.test_library_menu, menu)
        val item = menu!!.findItem(R.id.action_search)
        return super.onCreateOptionsMenu(menu)
    }*/

    override fun onBackPressed() {
        /*if (searchView.onBackPressed()) {
            return
        }*/
        super.onBackPressed()
    }

    override fun onButtonClicked(buttonCode: Int) {
        //Toast.makeText(applicationContext,buttonCode.toString(),Toast.LENGTH_LONG).show()
        when (buttonCode) {
            MaterialSearchBar.BUTTON_SPEECH -> Toast.makeText(applicationContext, "Voice", Toast.LENGTH_LONG).show()
            MaterialSearchBar.BUTTON_NAVIGATION -> Toast.makeText(applicationContext, "Navigation", Toast.LENGTH_LONG).show()
            MaterialSearchBar.BUTTON_BACK -> {
                Toast.makeText(applicationContext, "Back", Toast.LENGTH_LONG).show()
                searchBar.closeSearch()
            }
        }
    }

    override fun onSearchStateChanged(enabled: Boolean) {
        val s = if (enabled) "enabled" else "disabled"
        Toast.makeText(applicationContext, "Search $s", Toast.LENGTH_SHORT).show()
        if (!enabled) {
            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
        }

    }

    override fun onSearchConfirmed(text: CharSequence?) {
    }

    override fun onDestroy() {
        super.onDestroy()
        //save last queries to disk
        Toast.makeText(applicationContext, "Search End", Toast.LENGTH_SHORT).show()
        Hawk.put("Suggestions", searchBar.lastSuggestions)
    }

}




