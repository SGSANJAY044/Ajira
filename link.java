package cluster;

import java.util.*;
public class link{
    public static void setLink(HashMap<String,myClusterNode> cluster,String[] linkLines){
        for(String linkLine: linkLines){
            String[] links=linkLine.split("_");
            cluster.get(links[0]).leafs.add(cluster.get(links[1]));
        }
    }
}