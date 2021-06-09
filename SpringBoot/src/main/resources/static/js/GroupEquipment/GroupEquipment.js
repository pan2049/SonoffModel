// 先建立群組表單
$("#CreateTable").click(function() {
    var Get_Group_Name = $("#Group_Name").val();


    $.ajax({
        //告訴程式表單要傳送到哪裡                                      
        url: "/",
        //需要傳送的資料
        //傳送給後端的資料
        data: {
            "Get_Group_Name": Get_Group_Name
        },
        // async: true,
        //使用POST或GET方法     
        type: "post",
        //接收回傳資料的格式，在這個例子中，只要是接收true就可以了
        dataType: 'json',
        //傳送失敗則跳出失敗訊息  
        error: function(response) {
            //資料傳送失敗後就會執行這個function內的程式，可以在這裡寫入要執行的程式  
            alert("失敗");
        },
        //傳送成功則跳出成功訊息
        success: function(response) {
            //資料傳送成功後就會執行這個function內的程式，可以在這裡寫入要執行的程式 
            // alert("成功");
            console.log(response.data);
        }
    });
});




$(".input-dyna-add").on("click", "#switch_Group", function() {
    if ($("#switch_Group").prop("checked")) {
        $("input[name='switch-checkbo-Group']").prop("checked", true).val("true");

        var switch_Group_value = $("#switch_Group").val(); // 開關 true false
        var Location_Name_value = $("#Location_Name").val(); // 設備位置
        var Group_Content_value = $("#Group_Content").val(); // 設備內容
        var Group_Content_value_Array = Group_Content_value.split(',');

        var Date = $("#Ldate").text(); // 日期
        var Time = $("#Ldate1").text(); // 時間
        var DateTime = Date + " " + Time // 日期 + 時間


        $.ajax({
            //告訴程式表單要傳送到哪裡                                      
            url: "/",
            //需要傳送的資料
            //傳送給後端的資料
            data: {
                "switch_Group_value": switch_Group_value,
                "Location_Name_value": Location_Name_value,
                "Group_Content_value_Array": Group_Content_value_Array,
                "DateTime": DateTime
            },
            // async: true,
            //使用POST或GET方法     
            type: "post",
            //接收回傳資料的格式，在這個例子中，只要是接收true就可以了
            dataType: 'json',
            //傳送失敗則跳出失敗訊息  
            error: function(response) {
                //資料傳送失敗後就會執行這個function內的程式，可以在這裡寫入要執行的程式  
                alert("失敗");
            },
            //傳送成功則跳出成功訊息
            success: function(response) {
                //資料傳送成功後就會執行這個function內的程式，可以在這裡寫入要執行的程式 
                // alert("成功");
                console.log(response.data);
            }
        });

    } else {
        $("input[name='switch-checkbo-Group']").prop("checked", false).val("false");

        var switch_Group_value = $("#switch_Group").val(); // 開關
        var Location_Name_value = $("#Location_Name").val(); // 設備位置
        var Group_Content_value = $("#Group_Content").val(); // 設備內容
        var Group_Content_value_Array = Group_Content_value.split(',');

        var Date = $("#Ldate").text(); // 日期
        var Time = $("#Ldate1").text(); // 時間
        var DateTime = Date + " " + Time // 日期 + 時間


        $.ajax({
            //告訴程式表單要傳送到哪裡                                      
            url: "/",
            //需要傳送的資料
            //傳送給後端的資料
            data: {
                "switch_Group_value": switch_Group_value,
                "Location_Name_value": Location_Name_value,
                "Group_Content_value": Group_Content_value,
                "DateTime": DateTime
            },
            // async: true,
            //使用POST或GET方法     
            type: "post",
            //接收回傳資料的格式，在這個例子中，只要是接收true就可以了
            dataType: 'json',
            //傳送失敗則跳出失敗訊息  
            error: function(response) {
                //資料傳送失敗後就會執行這個function內的程式，可以在這裡寫入要執行的程式  
                alert("失敗");
            },
            //傳送成功則跳出成功訊息
            success: function(response) {
                //資料傳送成功後就會執行這個function內的程式，可以在這裡寫入要執行的程式 
                // alert("成功");
                console.log(response.data);
            }
        });

    }
});