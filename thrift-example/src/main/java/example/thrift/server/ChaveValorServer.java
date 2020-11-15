package example.thrift.server;

import example.thrift.chaveValor.ChaveValor;
import example.thrift.chaveValor.ChaveValorHandler;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;

public class ChaveValorServer {

    public static void main(String[] args) {
        try {
            ChaveValorHandler handler = new ChaveValorHandler();
            ChaveValor.Processor processor = new ChaveValor.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            System.out.println("Iniciando servidor...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}