package idnull.z.koinnotes.presentation.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import idnull.z.koinnotes.R
import idnull.z.koinnotes.databinding.FragmentMainBinding

import idnull.z.koinnotes.domain.AppNote
import idnull.z.koinnotes.utils.APP_ACTIVITY
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!


    private val mViewModel: MainFragmentViewModel by viewModel()




    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList:Observer<List<AppNote>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentMainBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        initStart()
    }

    private fun initStart() {
        setHasOptionsMenu(true)
        mAdapter= MainAdapter()
        mRecyclerView=mBinding.recycler
        mRecyclerView.adapter= mAdapter
        mObserverList= Observer {
            val list = it.asReversed()
            mAdapter.setList(list)
        }



        mViewModel.allNotes.observe(this,mObserverList)
        mBinding.btnAddNote.setOnClickListener{
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment2_to_addNewNoteFragment2)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }
    companion object{
        fun click(note: AppNote){
            val bundle =Bundle()
            bundle.putSerializable("note",note)
            APP_ACTIVITY.navController.navigate(R.id.action_mainFragment2_to_noteFragment2,bundle)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.exit_action_menu,menu)

    }


}