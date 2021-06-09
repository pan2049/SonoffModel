// 開
function on() {
    $.post("jdiFlagOnFun_6");
};
// 關
function off() {
    $.post("jdiFlagOffFun_6");
};



$("#switchID6").click(function() {
    if ($("#switchID6").prop("checked")) {
        $("input[name='switch-checkbox6']").prop("checked", true).val("true");
        // alert($("#switchID6").val());
        on();
    } else {
        $("input[name='switch-checkbox6']").prop("checked", false).val("false");
        // alert($("#switchID6").val());
        off();
    }
});