var socket = new WebSocket('ws://localhost:8888/stomp-endpoint'); // 建立WebSocket連線

var stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {

    console.log('已連線');
    stompClient.subscribe('/topic/health', function (message) {
        var data = JSON.parse(message.body); // 解析從後端傳回的JSON資料
        console.log("data" + data);
        // 取得各組件的狀態
        var cpuStatus = data.components.CPUStatus.status;
        var processCpuLoad = data.components.CPUStatus.details.processCpuLoad;

        var diskSpace = data.components.diskSpace.status;
        var memory = data.components.memory.status;
        var ping = data.components.ping.status;

        // 將狀態資訊顯示在頁面上
        document.getElementById('cpu-status').innerHTML = 'CPU狀態：' + cpuStatus;
        document.getElementById('cpu-status-processCPU').innerHTML = 'CPU負荷比率' + processCpuLoad;
        document.getElementById('disk-space').innerHTML = '磁碟空間狀態：' + diskSpace;
        document.getElementById('memory').innerHTML = '記憶體狀態：' + memory;
        document.getElementById('ping').innerHTML = 'Ping狀態：' + ping;
    });
    stompClient.send('/app/health', {}, '');
}, function (error) {
    console.log('連線失敗：' + error);
});



