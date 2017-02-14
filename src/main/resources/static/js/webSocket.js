var stompClient = null;
var temp = "";
    function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#contentCommunicator").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/test', function (message) {
             showMessage(JSON.parse(message.body));
        });
        // stompClient.subscribe('/user/queue/test', function (greeting) {
        //     console.log("Srodek 2");
        //     alert(greeting.body);
        // });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/hello", {}, JSON.stringify({
        'recipient': document.getElementById("friendId").value + "",
        'message': document.getElementById("contentInput").value + ""
    }));
    document.getElementById("contentInput").value = '';

}

function showMessage(message) {
    console.log("id================== 4 ====== message="+message);
     var tagName = "#contentCommunicator-"+document.getElementById("friendId").value;

     // if( message.recipient != document.getElementById("friendId").value){
         $(tagName).append("<li>" + message.message + "</li>");


}

$(function () {
    $("#second-form").submit(function(e){
        e.preventDefault();
    });
    // $( "#connect" ).click(function() { connect(); });
    // $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});