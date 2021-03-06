package example.thrift.chaveValor;

import java.util.HashMap;
import example.thrift.chaveValor.ChaveValor;
import example.thrift.chaveValor.KeyNotFound;
import org.apache.thrift.TException;

public class ChaveValorHandler implements ChaveValor.Iface  {
    private HashMap<Integer,String> kv = new HashMap<>();

    @Override
    public String getKV(int key) throws TException {
        if(kv.containsKey(key))
            return kv.get(key);
        else
            throw new KeyNotFound();
    }
    @Override
    public boolean setKV(int key, String valor) throws TException {
        kv.put(key,valor);
        return true;
    }
    @Override
    public void delKV(int key) throws TException {
        kv.remove(key);
    }
}