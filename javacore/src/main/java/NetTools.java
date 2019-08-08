import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Author: kangq
 * @Date: 2019/8/6 15:40
 */
@Slf4j
public class NetTools {

    protected static void printInterfaces() throws Exception{
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface ni = interfaces.nextElement();
            Enumeration<InetAddress> ias = ni.getInetAddresses();
            while (ias.hasMoreElements()){
                InetAddress ia = ias.nextElement();
                log.info("ip:{}, is loop:{}, is site local: {}",ia.getHostAddress(), ia.isLoopbackAddress(), ia.isSiteLocalAddress());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        printInterfaces();
    }
}
