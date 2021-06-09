// 開
function switchID5_on() {
    $.post("jdiFlagOnFun_5");
};
// 關
function switchID5_off() {
    $.post("jdiFlagOffFun_5");
};



$("#switchID5").click(function() {
    if ($("#switchID5").prop("checked")) {
        $("input[name='switch-checkbox5']").prop("checked", true).val("true");
        // alert($("#switchID5").val());
        on();
    } else {
        $("input[name='switch-checkbox5']").prop("checked", false).val("false");
        // alert($("#switchID5").val());
        off();
    }
});