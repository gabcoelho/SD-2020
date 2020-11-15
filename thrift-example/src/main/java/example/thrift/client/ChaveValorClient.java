package example.thrift.client;

import example.thrift.chaveValor.ChaveValor;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ChaveValorClient {

    public static void main(String[] args) {
        try {
            TTransport transport;
            transport = new TSocket("localhost", 9222);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ChaveValor.Client client = new ChaveValor.Client(protocol);
            
            System.out.println("Valor = " + client.setKV(10, "Valor teste 1"));
            
            System.out.println("Valor = " + client.setKV(9, "Valor teste 2"));
            
            System.out.println("Valor = " + client.setKV(10, "Valor teste 3"));
            
            
            transport.close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }
}
