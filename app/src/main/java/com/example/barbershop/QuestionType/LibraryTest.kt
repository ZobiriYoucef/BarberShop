package com.example.barbershop.QuestionType

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieAnimationView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnListScrollListener
import com.example.barbershop.R
import com.example.barbershop.R2.id.fab3
import com.ferfalk.simplesearchview.SimpleSearchView
import com.ferfalk.simplesearchview.SimpleSearchView.SearchViewListener
import com.shreyaspatil.MaterialDialog.MaterialDialog
import kotlinx.android.synthetic.main.activity_library_test.*


class LibraryTest : AppCompatActivity() {

    private lateinit var dataBaseHelper:DataBaseHelperClass
    val mAdapter =MyAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library_test)

        dataBaseHelper= DataBaseHelperClass(this)

        val allResults=DataManger.fetchAllResults(dataBaseHelper)

        mAdapter.setFinishedSurveyResult(allResults)

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

                /*SweetAlertDialog(this@StartASurveyEnhance, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure you want to delete ${item.I1} response profile")
                        .setContentText("Won't be able to recover this response profile!")
                        .setConfirmText("Yes,deleted it!")
                        .setCancelText("No,cancel plx!")
                        .setConfirmClickListener { sDialog ->
                            DataManger.deleteASingleResponse(dataBaseHelper,item.id)
                            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
                            sDialog
                                    .setTitleText("Successfully deleted")
                                    .setContentText("${item.I1} response no longer exists")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setConfirmClickListener{ sDialog ->
                                        sDialog.dismissWithAnimation()
                                        }
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE)
                        }
                        .setCancelClickListener { sDialog ->
                            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
                            sDialog.dismiss() }
                        .show()*/

                val mDialog = MaterialDialog.Builder(this@LibraryTest)
                        .setTitle("Delete?")
                        .setMessage("Are you sure want to delete this file?")
                        .setCancelable(false)
                        .setAnimation(R.raw.delte)
                        .setPositiveButton("Delete", R.drawable.ic_account_circle_black_24dp) { dialogInterface, which ->
                            // Delete Operation
                            DataManger.deleteASingleResponse(dataBaseHelper,item.id)
                            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
                        }
                        .setNegativeButton("Cancel", R.drawable.ic_add) { dialogInterface, which -> dialogInterface.dismiss()
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

        //behind_swiped_item

        // by Icons and colors
        /* mList.behindSwipedItemIconDrawableId = R.drawable.camera_icon
         mList.behindSwipedItemIconMargin = 20f //0 if not specified; ignored if behind_swiped_item_icon_centered is true.
         mList.behindSwipedItemCenterIcon = false
         mList.behindSwipedItemBackgroundColor =R.color.Blue*/

        //by a layout (main direction)
        mList2.behindSwipedItemLayoutId = R.layout.swiped_item_main_direction_layout



        //behind_swiped_item_secondary
        /*// by Icons and colors
        mList.behindSwipedItemIconSecondaryDrawableId = R.drawable.ic_account_circle_black_24dp
        mList.behindSwipedItemBackgroundSecondaryColor =R.color.Green*/

        //parameter
        mList2.reduceItemAlphaOnSwiping = true
        mList2.longPressToStartDragging = true


        fab3.setOnClickListener {
            val GoToSurvyLibTest = Intent(this, SurvyLibTest::class.java)
            startActivityForResult(GoToSurvyLibTest, 1)
        }

        /*hidden_search_with_recycler.hideAtScroll = true
        hidden_search_with_recycler.visibleAtInit = false
        hidden_search_with_recycler.scrollToBottomBeforeHide = false
        hidden_search_with_recycler.scrollToTopBeforeShow = false
        hidden_search_with_recycler.filterWhileTyping = true*/

        searchView.setOnQueryTextListener(object : SimpleSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("SimpleSearchView", "Submit:$query")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                Log.d("SimpleSearchView", "Text changed:$newText")
                return false
            }

            override fun onQueryTextCleared(): Boolean {
                Log.d("SimpleSearchView", "Text cleared")
                return false
            }
        })

        searchView.setOnSearchViewListener(object : SearchViewListener {
            override fun onSearchViewShown() {
                Log.d("SimpleSearchView", "onSearchViewShown")
            }

            override fun onSearchViewClosed() {
                Log.d("SimpleSearchView", "onSearchViewClosed")
            }

            override fun onSearchViewShownAnimation() {
                Log.d("SimpleSearchView", "onSearchViewShownAnimation")
            }

            override fun onSearchViewClosedAnimation() {
                Log.d("SimpleSearchView", "onSearchViewClosedAnimation")
            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            mAdapter.setFinishedSurveyResult(DataManger.fetchAllResults(dataBaseHelper))
        }
        if (searchView.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.test_library_menu, menu)
        val item = menu!!.findItem(R.id.action_search)
        searchView.setMenuItem(item)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        if (searchView.onBackPressed()) {
            return
        }
        super.onBackPressed()
    }


}
