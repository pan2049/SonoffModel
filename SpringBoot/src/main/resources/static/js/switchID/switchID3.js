// 開
function switchID3_on() {
    $.post("jdiFlagOnFun_3");
};
// 關
function switchID3_off() {
    $.post("jdiFlagOffFun_3");
};



$("#switchID3").click(function() {
    if ($("#switchID3").prop("checked")) {
        $("input[name='switch-checkbox3']").prop("checked", true).val("true");
        // alert($("#switchID3").val());
        switchID3_on();
    } else {
        $("input[name='switch-checkbox3']").prop("checked", false).val("false");
        // alert($("#switchID3").val());
        switchID3_off();
    }
});