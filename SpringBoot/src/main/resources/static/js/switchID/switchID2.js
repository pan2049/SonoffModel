// 開
function switchID2_on() {
    $.post("jdiFlagOnFun_2");
};
// 關
function switchID2_off() {
    $.post("jdiFlagOffFun_2");
};



$("#switchID2").click(function() {
    if ($("#switchID2").prop("checked")) {
        $("input[name='switch-checkbox2']").prop("checked", true).val("true");
        // alert($("#switchID2").val());
        switchID2_on();
    } else {
        $("input[name='switch-checkbox2']").prop("checked", false).val("false");
        // alert($("#switchID2").val());
        switchID2_off();
    }
});