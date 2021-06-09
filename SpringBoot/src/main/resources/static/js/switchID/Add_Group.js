$(function() {
    $("#add").click(function() {
        $("#select1 option:selected").appendTo($("#select2"));
    })
});

$(function() {
    $("#add_all").click(function() {
        $("#select1 option").appendTo($("#select2"));
    })
});

$(function() {
    $("#remove").click(function() {
        $("#select2 option:selected").appendTo($("#select1"));
    })
});

$(function() {
    $("#remove_all").click(function() {
        $("#select2 option").appendTo($("#select1"));
    })
});



// $(function() {
//     $('.input-group-add').initInputGroup({
//         'widget': 'input', //輸入框組中間的空間型別
//         /*
//         'add' : '新增',
//         'del' : '刪除',
//         */
//         'field': 'data',
//         'data': ['250', '300', 'hi', 'dj']
//     });
// });

function addInput() {
    var Get_Group_Name = $("#Group_Name").val();
    var Get_Selected_Group = $("#select2").val(); // get取得的選中群組
    // console.log(Get_Selected_Group);
    var input = $("<div class='input-group form-inline'>  <div class='switch'><input class='switch-checkbox' id='switch_Group' type='checkbox' name='switch-checkbo-Group' value=''><label class='switch-label' for='switch_Group'><span class='switch-txt' turnOn='開' turnOff='關'></span><span class='switch-Round-btn'></span></label></div>  <input type='text' class='form-control' id='Location_Name' style='width:10%;margin-bottom:2px;' name='desc[]' placeholder='請輸入名字' value=" + "'" + Get_Group_Name + "'" + "> &nbsp;&nbsp;&nbsp;&nbsp; <textarea class='form-control' id='Group_Content' name='price[]' rows='3' maxlength='255' placeholder='內容'>" + Get_Selected_Group + "</textarea>&nbsp;&nbsp;&nbsp;&nbsp;<button class='removeclass btn btn-default' type='button'><span class='glyphicon glyphicon-minus'></span></button></div>'");
    // append 表示新增在標籤內， appendTo 表示新增在元素外尾
    $(".input-dyna-add").append(input);
}

function getValue() {
    var valArr = new Array;
    $("input[name='desc[]']").each(function(index, item) {
        valArr[index] = $(this).val();
        var priv = valArr.join(',');
        alert(priv);
    });
    // console.log(desc);
}

function getValue_price() {
    var valArr = new Array;
    $("textarea[name='price[]']").each(function(index, item) {
        valArr[index] = $(this).val();
        var priv = valArr.join(',');
        alert(priv);
    });
    // console.log(desc);
}

$("body").on("click", ".removeclass", function(e) {
    // remove text box  
    $(this).parent('div').remove();
    return false;
})