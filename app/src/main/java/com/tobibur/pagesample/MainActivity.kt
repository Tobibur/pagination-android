package com.tobibur.pagesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tobibur.pagesample.data.Item
import com.tobibur.pagesample.network.RetrofitInstance
import com.tobibur.pagination.PaginationInterface
import com.tobibur.pagination.PaginationUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity(), PaginationInterface {

    private lateinit var recAdapter: ReposAdapter
    private val mService = RetrofitInstance.apiService

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillRecyclerView(listOf())
        getRepositories()

    }

    private fun getRepositories(page: Int = 1) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repos = mService.getRepos("Android", page)
                withContext(Dispatchers.Main){
                    recAdapter.addAll(repos.items)
                }
            }catch (e:Exception){
                Log.d(TAG, "getRepositories: ${e.message}")
            }

        }
    }

    private fun fillRecyclerView(items: List<Item>) {
        val linearLayoutManager = LinearLayoutManager(this,
            RecyclerView.VERTICAL, false)
        repoRecycler.apply {
            layoutManager = linearLayoutManager
            PaginationUtils.initPagination(this, linearLayoutManager,
                this@MainActivity)
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(this@MainActivity,
                    DividerItemDecoration.VERTICAL)
            )
            isFocusable = false
            recAdapter = ReposAdapter(items.toMutableList())
            adapter = recAdapter
        }
    }

    override fun onPagination(page: Int) {
        getRepositories(page)
        Log.d(TAG, "onPagination: $page")
    }
}
