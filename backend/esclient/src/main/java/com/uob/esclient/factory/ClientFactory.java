package com.uob.esclient.factory;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientFactory {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 9300;

    public static TransportClient createClient() {
        try {
            return new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(DEFAULT_HOST), DEFAULT_PORT));
        } catch (UnknownHostException e) {
            throw new RuntimeException(" Check your local ES host/port. If you haven't downloaded the ES binaries, " +
                    "please see https://www.elastic.co/downloads/elasticsearh", e);
        }
    }

    public static TransportClient createClient(int port, String host) {
        try {
            return new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            throw new RuntimeException(" Check your local ES host/port. If you haven't downloaded the ES binaries, " +
                    "please see https://www.elastic.co/downloads/elasticsearh", e);
        }
    }

    public static void main(String[] args) {
        TransportClient c = ClientFactory.createClient();

    }

}