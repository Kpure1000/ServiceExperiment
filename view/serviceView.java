package view;

import java.io.IOException;

import network.serviceNetwork;

/**
 * serviceView
 * 
 */
public class serviceView {

    serviceNetwork service;

    public static void main(String[] args) {
        try {
            new serviceView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public serviceView()throws IOException{
        System.out.println("*服务端界面启动*");
        service = new serviceNetwork();
    }
}