function doSomeWork() {
    alert("Just a simple message box!");
}

function getCurrentTime(){
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    return [ h, m ].join(':')
}

function printTime() {
    alert(getCurrentTime());
}