package com.example.test1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private TextView textV2;
    private TextView textV3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.text1);
        textV2 = findViewById(R.id.textV2);
        textV3 = findViewById(R.id.textV3);

        text1.setText("111");

        udpServer serverOn = new udpServer();
        try {
            serverOn.udpServerOn();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /*public void udpServer () throws IOException {
        try {
            text1.setText("222");
            int service_port = 9876;                     //порт для UDP соединения

            //Toast toast1 = Toast.makeText(MainActivity.this, "Данные получены", Toast.LENGTH_LONG);
            //toast1.show();
            DatagramSocket serverSocket = new DatagramSocket(service_port);     //переменная DatagramSocket, чтобы получать ответы от клиента
            byte[] recivingDataBuffer = new byte[1024];                         //переменная для временного хранения получаемых данных (если будут задержки в приёме данных)
            byte[] sendingDataBuffer = new byte[1024];                         //переменная для временного хранения передаваемых данных (если будут задержки в передаче данных)

            DatagramPacket inputPacket = new DatagramPacket(recivingDataBuffer, recivingDataBuffer.length); //переменная, для хранения полученных данные с использование буфера
            System.out.println("Закачиваю данные ...");
            textV2.setText("Закачиваю данные ...");

            serverSocket.receive(inputPacket);                                  //запись в inputPacket полученных данных

            String recivedData = new String(inputPacket.getData());              //переменная для вывода на экран полученных данных
            System.out.println("Полученные данные: " + recivedData);
            textV3.setText("Полученные данные: " + recivedData);
            //toast1.show();
                                                                                //подготовака данных на отправку:
                                                                                //преоброзование полученных данных в верхний регистр
                                                                                //преобразование данных в байты
            sendingDataBuffer = recivedData.toUpperCase().getBytes();            //сохранение данных в буфер

            InetAddress senderAddres = inputPacket.getAddress();                //переменная, в которую записывается IP адресс клиента
            int senderPort = inputPacket.getPort();                             //переменная, в которую записывается порт клиента

            DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, senderAddres, senderPort); //переменная, для хранения пакета для отправки
            serverSocket.send(outputPacket);                                    //отправка пакета клиенту

            serverSocket.close();                                               //закрытие соединения сокетов
            text1.setText("333");

        }
        catch (SocketException e) {
            //System.out.println("задница не отвечает");
            //System.exit(1);
            e.printStackTrace();
        }
    }*/

}