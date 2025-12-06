
package Business.Network;

import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class NetworkDirectory {
    
    private ArrayList<Network> networkList;

    public NetworkDirectory() {
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    
    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
}
