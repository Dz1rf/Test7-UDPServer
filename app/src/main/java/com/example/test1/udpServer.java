package com.example.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udpServer {

    public void udpServerOn() throws IOException {
        System.out.println("Этап 1");
        new Thread(new Runnable() {                             //работа с сетью должна запускаться в отдельном потоке
            @Override
            public void run() {

                try {

                    int service_port = 8080;                     //порт для UDP соединения

                    DatagramSocket serverSocket = new DatagramSocket(service_port);     //переменная DatagramSocket, чтобы получать ответы от клиента
                    byte[] recivingDataBuffer = new byte[1024];                         //переменная для временного хранения получаемых данных (если будут задержки в приёме данных)
                    byte[] sendingDataBuffer = new byte[1024];                         //переменная для временного хранения передаваемых данных (если будут задержки в передаче данных)

                    DatagramPacket inputPacket = new DatagramPacket(recivingDataBuffer, recivingDataBuffer.length); //переменная, для хранения полученных данные с использование буфера
                    System.out.println("Закачиваю данные ...");

                    serverSocket.receive(inputPacket);                                  //запись в inputPacket полученных данных
                    System.out.println("Этап 2");

                    String recivedData = new String(inputPacket.getData());              //переменная для вывода на экран полученных данных
                    System.out.println("Полученные данные: " + recivedData);

                    //toast1.show();
                    //подготовака данных на отправку:
                    //преоброзование полученных данных в верхний регистр
                    //преобразование данных в байты
                    /*sendingDataBuffer = recivedData.toUpperCase().getBytes();            //сохранение данных в буфер

                    InetAddress senderAddres = inputPacket.getAddress();                //переменная, в которую записывается IP адресс клиента
                    int senderPort = inputPacket.getPort();                             //переменная, в которую записывается порт клиента

                    DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, senderAddres, senderPort); //переменная, для хранения пакета для отправки
                    serverSocket.send(outputPacket);*/                                    //отправка пакета клиенту

                    serverSocket.close();                                               //закрытие соединения сокетов


                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
