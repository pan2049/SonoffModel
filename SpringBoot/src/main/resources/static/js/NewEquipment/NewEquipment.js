// 新增設備，傳遞給後台

$("#NewEquipment_Submit").click(function() {
    var IP = $("#IP").val();
    var AddDeviceLocation = $("#AddDeviceLocation").val();

    var input = $("<div class='item'> <p>IP: " + IP + "</p> <div class='switch'> <input class='switch-checkbox' id='switchID0' type='checkbox' name='switch-checkbox0' value=''> <label class='switch-label' for='switchID0'> <span class='switch-txt' turnOn='開' turnOff='關'></span> <span class='switch-Round-btn'></span> </label></div></div>");
    // append 表示新增在標籤內， appendTo 表示新增在元素外尾
    $(".input-dyna-equipment-add").append(input);

    $.ajax({
        //告訴程式表單要傳送到哪裡                                      
        url: "/",
        //需要傳送的資料
        //傳送給後端的資料
        data: {
            "IP": IP,
            "AddDeviceLocation": AddDeviceLocation
        },
        // async: true,
        //使用POST或GET方法     
        type: "get",
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
            // console.log(response.data);
        }
    });
    $("#xxx1").trigger("click"); // trigger() 方法觸發被選元素的指定事件類型。 || 規定被選元素要觸發的事件。
});