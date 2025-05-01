const websocket = new WebSocket("/ws/chat")
const send = document.getElementById("send")
const message = document.getElementById("message")
const receivername = document.getElementsByClassName("receiver-name");
const rec = document.getElementById("receiver")
const chatBody = document.getElementById("chat-body");
const chat = document.getElementById("chat")

try {
    
    const memoSend = document.getElementById("memoSend");
    const memoContents = document.getElementById("memoContents");
    const memoReceiver = document.getElementById("memoReceiver");

    memoSend.addEventListener('click', ()=>{
        let m = new Message();
        m.body = memoContents.value;
        m.receiver = memoReceiver.value;
        m.status = "3"
        m.date = new Date();

        websocket.send(JSON.stringify(m))
    })
}catch(e){}

for(let r of receivername){
    r.addEventListener("click", ()=>{
        let receiver=r.getAttribute("data-receiver-name");
        console.log(r.getAttribute("data-receiver-name"))
        let sender=chat.getAttribute("data-sender-name");
        rec.value=receiver;
        chatBody.innerHTML="";

        fetch(`/chat/room?receiver=${receiver}&sender=${sender}`)
            .then(r=>r.json())
            .then(r=>{
                console.log(r)
                r.forEach(element => {
                    let d=makeData(element)
                    chatBody.append(d);
                });
            })
            .catch(e=>{
                console.log(e)
            })
        
    })
}


//webSocket 연결이 되었을 때
websocket.onopen=()=>{
    let m = new Message()
    m.body="님이 입장했습니다"
    //websocket.send(JSON.stringify(m))
}

//websocket으로 메세지를 수신 했을 때
websocket.onmessage=(m)=>{
    //
    let result =JSON.parse(m.data)
    let start = result.sender;
    let end = result.receiver;
    let status = result.status;

    if (status == "3"){
        makeMemo(result)

        return;
    }

    let my = chat.getAttribute("data-sender-name")//내정 user2
    let re = rec.value; //현재 채팅하고 있는 상대방 정보 admin

    console.log("start : ", start)
    console.log("my : ", my)
    console.log("re : ", re)


    if(start != my && start != re ){
        console.log("!!!!!!!!!!!!!!")
        return;
    }
    let r = makeData(result);
    chatBody.append(r)
}

//webSocket연결이 종료 되었을 때
websocket.onclose=()=>{
    websocket.send("님이 나갔습니다다")
}

//개발자가 메세시 송신 할 때
send.addEventListener("click", ()=>{
    let m = message.value

    let mes = new Message();
    mes.body=m;
    mes.receiver=rec.value;
    mes.date=new Date();
    mes.status="1";
    mes.roomNum=
    
    
    websocket.send(JSON.stringify(mes))
    message.value="";

})

//websocke error 발생시
// websocket.onerror=()=>{

// }

websocket.onerror=webSocketError;

function webSocketError(){

}


//------------------------------------
class Message {
    sender="";
    body="";
    receiver="";
    date="";
    status="0"
    roomNum="";
}


function makeData(data){

    const div = document.createElement("div");
    div.innerHTML=data.body

    return div;

}
function makeMemo(data){
    let a = document.createElement("a");
    a.classList.add("dropdown-item",  "d-flex",  "align-items-center")
    a.href="#"

    let div = document.createElement("div");
    div.classList.add("dropdown-list-image", "mr-3")

    let img = document.createElement("img");
    img.classList.add("rounded-circle")
    img.src="";

    let div2 = document.createElement("div");
    div2.classList.add("status-indicator",  "bg-success")

    div.appendChild(img)
    div.appendChild(div2)

    a.appendChild(div)

    div = document.createElement("div");
    div.classList.add("font-weight-bold")

    div2 = document.createElement("div")
    div2.classList.add("text-truncate")
    div2.innerText=data.body;

    div.appendChild(div2)

    div2= document.createElement("div")
    div2.classList.add("small", "text-gray-500");
    div2.innerText=data.sender+" " + data.date

    div.appendChild(div2);

    a.appendChild(div)

    document.getElementById("memoAdd").before(a);

}