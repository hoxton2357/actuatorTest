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
        var arch = data.components.CPUStatus.details.arch;
        var name = data.components.CPUStatus.details.name
        var condition = data.components.CPUStatus.details.condition

        var diskSpace = data.components.diskSpace.status;
        var total = data.components.diskSpace.details.total;
        var free = data.components.diskSpace.details.free;
        var threshold = data.components.diskSpace.details.threshold;

        var memory = data.components.memory.status;
        var totalPhysicalMemorySize = data.components.memory.details.totalPhysicalMemorySize;
        var usedPhysicalMemorySize = data.components.memory.details.usedPhysicalMemorySize;
        var freePhysicalMemorySize = data.components.memory.details.freePhysicalMemorySize;
        var condition2 = data.components.memory.details.condition;


        var ping = data.components.ping.status;

        // 將狀態資訊顯示在頁面上
        document.getElementById('cpu-status').innerHTML = 'CPU狀態：' + cpuStatus;
        document.getElementById('cpu-status-processCPU').innerHTML = 'CPU負荷比率：' + processCpuLoad;
        document.getElementById('cpu-arch').innerHTML = 'CPU架構：' + arch;
        document.getElementById('cpu-name').innerHTML = '作業系統名稱：' + name;
        document.getElementById('cpu-condition').innerHTML = '描述：' + condition;

        document.getElementById('disk-space').innerHTML = '磁碟空間狀態：' + diskSpace;
        document.getElementById('disk-total').innerHTML = '磁碟總空間：' + total;
        document.getElementById('disk-free').innerHTML = '磁碟剩餘狀態：' + free;
        document.getElementById('disk-threshold').innerHTML = '磁碟閾值：' + threshold;

        document.getElementById('memory').innerHTML = '記憶體狀態：' + memory;
        document.getElementById('memory-totalPhysicalMemorySize').innerHTML = '記憶體總空間：' + totalPhysicalMemorySize;
        document.getElementById('memory-usedPhysicalMemorySize').innerHTML = '記憶體已使用：' + freePhysicalMemorySize;
        document.getElementById('memory-freePhysicalMemorySize').innerHTML = '自由記憶體：' + usedPhysicalMemorySize;
        document.getElementById('memory-condition').innerHTML = '描述：' + condition2;

        document.getElementById('ping').innerHTML = 'Ping狀態：' + ping;
    });
    stompClient.send('/app/health', {}, '');
}, function (error) {
    console.log('連線失敗：' + error);
});



