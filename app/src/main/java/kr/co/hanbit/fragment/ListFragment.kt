package kr.co.hanbit.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.hanbit.fragment.databinding.FragmentListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    // goDetail() 메서드를 호출해야하므로 MainActivity를 전달받는 코드를 작성
    var mainActivity: MainActivity? = null //mainActivity를 담아둘 멤버 변수 선언
    lateinit var binding:FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        /* 목록 프래그먼트의 레이아웃에 있는 버튼을 사용하기 위해서 코드 수정 */
        //return inflater.inflate(R.layout.fragment_list, container, false) //inflater로 생성한 뷰를 바로 리턴
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.btnNext.setOnClickListener { mainActivity?.goDetail() }

        /* arguments 에서 값을 꺼낸 후 레이아웃에 작성해둔 텍스트뷰에 입력 */
        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"

        return binding.root //onCreateView() 메서드의 반환값이 View이므로 바인딩이 가지고 있는 root 뷰를 넘겨줌
    }

    /* 액티비티로부터 전달받을 문자열을 출력하는 메서드 */
    fun setValue(value:String) {
        binding.textFromActivity.text = value
    }

    // 메서드를 오버라이드 할 때는 대부분 onCreat() 메서드 블록 바로 아랫줄에 함
    override fun onAttach(context: Context) { //프래그먼트의 생명 주기 메서드 onAttach()를 통해 (MainActivity를 전달받는)코드를 전달받음
        super.onAttach(context)

        /* onAttach() 메서드를 통해 넘어온 Context를 캐스팅해서 MainActivity에 담음
            프래그먼트의 onAttach() 메서드를 통해 넘어오는 Context는 부모 액티비티 전체가 담겨있음
            context의 타입이 MainActivity인 것을 확인하고 mainActivity 프로퍼티에 저장해둠 */
        if (context is MainActivity) mainActivity = context
    }
}