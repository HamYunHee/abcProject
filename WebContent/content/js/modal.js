$(document).ready(function() {
    $(".login_btn").click(function() {
        $("#m_password").hide();
        $("#m_join").hide();
        $("#m_login").show();
    });

    $(".join_btn").click(function() {
        $("#m_password").hide();
        $("#m_login").hide();
        $("#m_join").show();
    });

    $(".pass_btn").click(function() {
        $("#m_join").hide();
        $("#m_login").hide();
        $("#m_password").show();
    });
    
    $(".closeBtn").click(function() {
        $(this).parent().hide();
    });
});