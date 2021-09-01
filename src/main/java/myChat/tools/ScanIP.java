package myChat.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ScanIP {
    public static String SERVER_ADDRESS;
    public static String NETWORK_ADDRESS;
    public static ArrayList<String> getAllIP(int start,int end){

        ArrayList<String> ipList = new ArrayList<>();

        for (int i = start; i <= end ; i++) {
            String ip = getSubnet(getNetworkAddress()) + i ;
            try {
                if(InetAddress.getByName(ip).isReachable(600))
                {

                    ipList.add(ip);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return ipList;
    }
    private static String getSubnet(String ip){
        String []ips = ip.split("\\.");
        return ips[0]+"."+ips[1]+"."+ips[2]+".";
    }
    public static String getServerAddress(){
        if(SERVER_ADDRESS == null){
            try {
                SERVER_ADDRESS = InetAddress.getLocalHost().getHostAddress().trim();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return SERVER_ADDRESS;
    }
    public static String getNetworkAddress(){
        if (NETWORK_ADDRESS == null)
        {
            String []ips = getServerAddress().split("\\.");
            NETWORK_ADDRESS = ips[0]+"."+ips[1]+"."+ips[2]+".1";
        }
        return NETWORK_ADDRESS;
    }
}
