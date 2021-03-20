package id.phephen.alodokter.ui.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.phephen.alodokter.databinding.FragmentProfileBinding
import id.phephen.alodokter.preference.SharePrefManager
import id.phephen.alodokter.viewmodel.UserViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvPhone: TextView

    private lateinit var viewModel: UserViewModel

    val CUSTOM_PREF_NAME = "User_data"
    var sharedPrefManager: SharePrefManager? = null

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initialize()
        setUI()
    }

    private fun initView () {
        tvName = binding.tvName
        tvEmail = binding.tvEmail
        tvPhone = binding.tvPhone
    }

    private fun initialize() {
        sharedPrefManager = SharePrefManager()
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun setUI () {
        val userPref = context!!.getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
        val email: String? = userPref.getString("email", "")
        viewModel.getUserDetails(this.requireContext(), email!!)!!.observe(this, Observer {
            tvName.text = it.name
            tvEmail.text = it.email
            tvPhone.text = it.phone
        })
    }

    companion object {
        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}