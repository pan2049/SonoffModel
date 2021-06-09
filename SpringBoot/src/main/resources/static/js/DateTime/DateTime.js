// 現在 日期，時間 


//日期
function Showtime() {　
    var fullDate = new Date();
    var yyyy = fullDate.getFullYear();
    var MM = (fullDate.getMonth() + 1) >= 10 ? (fullDate.getMonth() + 1) : ("0" + (fullDate.getMonth() + 1));
    var dd = fullDate.getDate() < 10 ? ("0" + fullDate.getDate()) : fullDate.getDate();
    var today = (yyyy + ":" + MM + ":" + dd);　
    // var mm=("日期 : " + yyyy+ " 年 " + M + " 月 " + d + "日" +"  " )

    var day_list = ['日', '一', '二', '三', '四', '五', '六'];
    var day = fullDate.getDay(); // or "new Date().getDay()";
    $("#day_list_Date").val('Today is 星期' + day_list[day]);
    $("#day_list_Date_L").text('Today is 星期' + day_list[day]);

    $("#date").val(today);
    $("#Ldate").text(today);
}
Showtime();
// DateTime

//時間，幾點幾分
function ShowTime2() {　
    var NowDate = new Date();　
    var h = NowDate.getHours(); //小時
    　
    var m = NowDate.getMinutes(); //分
    　
    var s = NowDate.getSeconds();　 //秒
    var mm = (String(h) + ':' + String(m) + ':' + String(s));
    $("#date1").val(mm);　
    $("#Ldate1").text(mm);
}
setInterval("ShowTime2()", 0);