package com.esign.util;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo {

    public String getIpAddress() {
        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip.toString();
    }

    public String getHostName() {
        InetAddress ip = null;
        String hostname = "";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostname;
    }
    
    public static void main(String[]args) 
    {
        HostInfo service = new HostInfo();
        System.out.println("Ip do computador: "+ service.getIpAddress());
        System.out.println("Host Name: "+ service.getHostName());
    }
}
