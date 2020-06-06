# 솝커톤 SOPT-ON

## &lt;RegisterActivity&gt;
  
### 회원가입 항목 중 비어 있는 것이 있으면 Toast를 이용하여 "가입 정보를 확인하세요" 출력
### 그렇지 않으면 이름/생일/id/pw/ybob/part/score를 가지고 통신
### 성공할 시 "회원가입 성공" 실패할 시 "올바르지 못한 요청"  | "가입 정보를 확인하세요" 출력
### 회원가입 성공 이후 LoginActivity로 이동

## &lt;LoginActivity&gt;

### RelativeLayout으로 구현, CheckBox, EditText, TextView, Botton등을 사용하여 로그인 화면 구성, 서버와 연결하여 로그인 기능 구현함.

## &lt;MainActivity&gt;

### MainActivity는 파트장 화면으로
### 출석체크 ON 클릭 시 AnswerAdminActivity로 이동
### 파트원 출석 명단 확인하기 클릭 시 CheckAdminActivity로 이동

## 세미나에서 배운 확장함수 사용 customEnqueue / showToast
##  startActivity라는 확장함수 생성

```kotlin
import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.startActivity(){
    val intent = Intent(this, T ::class.java)
    startActivity(intent)
}
```

* CheckAdminActivity : 파트원 명단 화면
* ImageButton인 홈버튼을 누르면 main 화면으로 화면 전환
* 날짜 설정, 시작 시간 생성 스피너 구현
* Button 커스텀하여 클릭 시 다른 색상으로 변경되게 구현함
* LinearLayout으로 전체, 출석, 지각, 결석 버튼 정렬 
* RecyclerView로 회원 명단을 보여줌. 텍스트와 이미지를 item으로 전달, Adapter로 연결함 

* 파트장이 출석을 위해 세미나 날짜와 시간을 선택하는 부분을 각각 DatePickerDialog, TimePickerDialog로 구현했다. 시간 같은 경우 손가락으로 스와이프하는 형식인 스피너로 구현하고 싶었지만, 쉽게 구현되지 않았고 많은 시간을 하나의 기능에 할애할 수 없었던 특성에 결국 시계가 나오도록 구현했다. 또 코드를 EditText에 입력해 생성하고 파트원은 코드를 입력해 해당 파트원들의 출결 상황을 볼 수 있는 화면으로 넘어가도록 구현했다.
