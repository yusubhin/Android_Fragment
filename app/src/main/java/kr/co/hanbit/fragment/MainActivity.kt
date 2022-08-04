package kr.co.hanbit.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.hanbit.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listFragment:ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment() //프래그먼트 삽입

        /* 버튼이 클릭되면 listFragment를 통해서 setValue를 호출 */
        binding.btnSend.setOnClickListener {
            listFragment.setValue("전달할 값")
        }
    }

    fun setFragment() {
        listFragment = ListFragment()
        var bundle = Bundle() //번들 생성
        /* 번들에 전달할 값 담기 */
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20210101)
        listFragment.arguments = bundle //값이 담긴 번들을 프래그먼트의 arguments에 전달

        val transaction = supportFragmentManager.beginTransaction() //begin transaction(액티비티가 가지고 있는 프래그먼트 매니저를 통해서 트랜잭션 시작)
        transaction.add(R.id.frameLayout, listFragment) //add fragment(frameLayout을 id로 가지고 있는 레이아웃에 listFragment 삽입)
        transaction.commit() //commit transaction(모든 작업이 정상적으로 처리되었음을 트랜젝션에 알림)
    }

    fun goDetail() { //Next 버튼 클릭했을 때 호출
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail") //for 뒤로가기 버튼 사용(addToBackStack을 사용하지 않은 채로 뒤로가기를 하면 액티비티가 종료됨)
        transaction.commit()
    }

    fun goBack() { //Back 버튼 클릭했을 때 호출(트랜잭션 없이 뒤로가기로 처리)
        onBackPressed() //뒤로가기가 필요할 때 액티비티에서 사용할 수 있는 기본 메서드
    }
}