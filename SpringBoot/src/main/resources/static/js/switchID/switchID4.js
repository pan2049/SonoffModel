// 開
function switchID4_on() {
    $.post("jdiFlagOnFun_4");
};
// 關
function switchID4_off() {
    $.post("jdiFlagOffFun_4");
};



$("#switchID4").click(function() {
    if ($("#switchID4").prop("checked")) {
        $("input[name='switch-checkbox4']").prop("checked", true).val("true");
        // alert($("#switchID4").val());
        switchID4_on();
    } else {
        $("input[name='switch-checkbox4']").prop("checked", false).val("false");
        // alert($("#switchID4").val());
        switchID4_off();
    }
});