//package com.example.acuatortest.actuator.Indicator;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.channels.FileChannel;
//
///**
// * @author Hoxton on 2023/2/13
// * @since 1.2.0
// */
//@Component
//public class DiskIOSpeedHealthIndicator implements HealthIndicator {
//
//    private static final String IO_SPEED_KEY = "ioSpeed";
//    private static final String FILE_PATH = "C:\\Users\\Hoxton\\Desktop\\test\\test.txt";
//    private static final int BUFFER_SIZE = 8192; // 8KB buffer size
//
//    @Override
//    public Health health() {
//        long startTime = System.nanoTime();
//
//        try (FileInputStream fis = new FileInputStream(FILE_PATH);
//             FileOutputStream fos = new FileOutputStream(FILE_PATH + ".copy");
//             FileChannel inChannel = fis.getChannel();
//             FileChannel outChannel = fos.getChannel()) {
//
//            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
//
//            while (inChannel.read(buffer) != -1) {
//                buffer.flip();
//                outChannel.write(buffer);
//                buffer.clear();
//            }
//
//            long endTime = System.nanoTime();
//            long elapsedTime = endTime - startTime;
//            double speed = (double) inChannel.size() / elapsedTime;
//
//            return Health.up().withDetail(IO_SPEED_KEY, speed).build();
//
//        } catch (IOException e) {
//            return Health.down(e).build();
//        }
//    }
//}
