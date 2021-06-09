// 開
function switchID1_on() {
    $.post("jdiFlagOnFun");
};
// 關
function switchID1_off() {
    $.post("jdiFlagOffFun");
};



$("#switchID1").click(function() {
    if ($("#switchID1").prop("checked")) {
        $("input[name='switch-checkbox']").prop("checked", true).val("true");
        // alert($("#switchID1").val());
        switchID_on();
    } else {
        $("input[name='switch-checkbox']").prop("checked", false).val("false");
        // alert($("#switchID1").val());
        switchID_off();
    }
});