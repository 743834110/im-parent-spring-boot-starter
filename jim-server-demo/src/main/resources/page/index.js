var index = {};

/**
 * 登录
 * @param userName
 * @param password
 * @param socket
 */
index.login = function (userName, password, socket) {
    var message = JSON.stringify({
        "cmd": 5,
        "loginname": userName,
        "password": password
    });
    socket.send(message);
};
/**
 * 语音通话
 */
index.liveAudio = function (userName, socket) {
    var toId = "";
    var myAudio = document.getElementById("myAudio");
    if(onSelected){
        toId = onSelected.getElementsByTagName("img")[0].alt;
    }
    if(!toId){
        alert("请选择要私聊的人!");
        return;
    }
    if(toId === userName){
        alert("无法给自己发送消息!");
        return ;
    }

    //
    webRTC.pc = new RTCPeerConnection(webRTC.configuration);

    // 发送SDP
    webRTC.pc.onnegotiationneeded = function (ev) {
        var promise = webRTC.pc.createOffer(function (desc) {
            webRTC.pc.setLocalDescription(desc, function () {
                console.log(webRTC.pc.localDescription)
            })
        });
    };
    // 发送公网IP
    webRTC.pc.onicecandidate = function (ev) {
        console.log(ev);
        msg = JSON.stringify({
            "from": userName,
            "to": toId,
            "cmd": 21,
            "createTime": new Date().getTime(),
            "chatType": 2,
            "candidate": ev.candidate
        });
        socket.send(msg);
    };

    navigator.getUserMedia({
        "audio": true
    }, function (stream) {
        myAudio.src = URL.createObjectURL(stream)
        webRTC.pc.addStream(stream)
    })

};

webRTC = {
    "configuration": {
        'iceServers': [
            {"url": "stun:stun.freeswitch.org"},
            {"url": "stun:stun.xten.com"},
            {"url": "stun:stun.ekiga.net"}
        ]
    },
    "pc": null
};



