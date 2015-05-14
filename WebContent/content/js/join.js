$(document).ready(function() {
    var regExNum=/[0-9]/; // 숫자
    var regExEng=/[a-zA-Z]/; // 영문
    var regExHan=/[가-힣]/; // 한글
    var regExOnlyNum=/^[0-9]*$/; // 숫자만
    var regExOnlyEng=/^[a-zA-Z]*$/; // 영문만
    var regExEngOrNum=/^[a-zA-Z0-9]*$/; // 영문, 숫자만
    var regUpw = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{8,24}$/; // 패스워드
    var regExDomain=/^((?:(?:(?:\w[\.\-\+]?)*)\w)+)((?:(?:(?:\w[\.\-\+]?){0,62})\w)+)\.(\w{2,6})$/; // 도메인
    var regExEmail=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; // 이메일   
    var s_default = {"background-color":"#fff"}; //기본
    var s_fail = {"background-color":"#fff2f2"}; //실패
    var s_success = {"background-color":"#dee9ff"}; //성공
    var s_focus = {"background-color":"#fbfff2"} //포커스 시

    var join_form = $("#join_form"),
        join_mail = $("#join_mail"),
        join_pass = $("#join_pass"),
        join_lepass = $("#join_lepass"),
        join_name = $("#join_name"),
        join_phone = $("#join_phone"),
        join_ktalk = $("#join_ktalk");

    $("input").focus(function() {
        $(this).css(s_focus);

        if(this.id == "join_pass") {
            $(this).next().show();
        }

    });

    $("input").blur(function() {
        $(this).css(s_default);

        // 이메일
        if(this.id == "join_mail") {
            if($(this).val() == "") {
                $(this).css(s_default);
            } else if(regExEmail.test( $(this).val()) != true ) {
                $(this).css(s_fail);
                $(this).next().show();
                $(this).next().text("이메일 형식이 맞지 않습니다.");
            } else{
                 $(this).next().hide();
            }

        // 패스워드
        } else if(this.id == "join_pass") {
            var passSize = $(this).val().length;
            $(this).next().hide();

            if($(this).val() == "") {
                $(this).css(s_default);
            } else if(passSize < 8) {
                $(this).css(s_fail);
                $(this).next().show();
                $(this).next().text("패스워드는 8자 이상입니다.");
            } else {
                $(this).next().hide();
            }

        // 패스워드 재확인
        } else if(this.id == "join_lepass") {
            if($(this).val() == "") {
                $(this).css(s_default);
            } else if($(this).val() != join_pass.val()) {
                $(this).css(s_fail);
                $(this).next().show();
                $(this).next().text("패스워드가 일치하지 않습니다.");
            } else {
                $(this).next().hide();
            }
        }
    });
});
