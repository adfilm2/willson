package com.example.appjam_willson

import android.os.Handler


//타이머를 미리 다 만들어 놓고 그다음에 1초씩 줄어 들도록 설정하면됨
//분이 들어오면 1초씩 줄어들게


class CustomTimer{
    companion object {
        var listCompleteTimer = 0
        var choiceHelperTimer = 0
        var chattingTimer = 0
    }
    init{
        val h = Handler()
        h.postDelayed(object : Runnable {
            private var time: Long = 0

            override fun run() {
                if(listCompleteTimer>0) listCompleteTimer --
                if(choiceHelperTimer>0) choiceHelperTimer --
                if(chattingTimer>0) chattingTimer --
            }
        }, 1000) // 1 second delay (takes millis)
    }

    public fun setListCompleteTimer(time:Int){
        listCompleteTimer = time
    }
}


/*
CustomTimer.listCompleTimer*/

//이거는 다른 액티비티나 그런 곳에서 사용할때 이렇게 접근해서 불러오기