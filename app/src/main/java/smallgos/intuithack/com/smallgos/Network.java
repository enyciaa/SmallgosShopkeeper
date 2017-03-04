package smallgos.intuithack.com.smallgos;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;
import org.alexd.jsonrpc.JSONRPCParams;
import org.json.JSONObject;

public enum  Network {
    INSTANCE;

    private static final String SERVER_URL = "http://176.31.124.179:8080/";

    private JSONRPCClient client;

    public void init() {
        client = JSONRPCClient.create(
                SERVER_URL,
                JSONRPCParams.Versions.VERSION_2);
        client.setConnectionTimeout(3000);
        client.setSoTimeout(3000);
        client.setDebug(true);
    }

    public void getInventory() {
        try {
            JSONObject json =  client.callJSONObject("BizServer.GetCatalog", "Tomatoes");
        } catch (JSONRPCException e) {
            e.printStackTrace();
        }
    }


}
