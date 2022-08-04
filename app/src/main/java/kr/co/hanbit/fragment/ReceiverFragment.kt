package kr.co.hanbit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import kr.co.hanbit.fragment.databinding.ActivityMainBinding
import kr.co.hanbit.fragment.databinding.FragmentReceiverBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReceiverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReceiverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentReceiverBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiverBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_receiver, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request") { key, bundle ->  //"request라는 키로 값을 보내면 이 리스너 안의 코드가 실행됨
            /* 리스너는 값을 수신하면 key와 bundle 2개의 파라미터 사용가능 (실제 value는 bundle 안에 Map형태로 담겨있음)
            bundle.getString("키")로 값을 꺼낼 수 있음
            request는 요청 전체에 대한 키, valuekey는 요청에 담겨 있는 여러 개의 값 중에 하나의 값을 가리키는 키 */
            bundle.getString("valueKey")?.let {
                binding.textView.setText(it)
            }
        }
    }

    //    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ReceiverFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ReceiverFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}