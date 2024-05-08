package cluster;

import java.util.*;

interface clusterNode{
   public String name="";
   public int capacity=0,need=0,tank=0;
   public ArrayList<myClusterNode> leafs=null;
   public void setNodeName(String name);
   public void setCapacity(int capacity);
   public void setNeed(int need);
}
public class  myClusterNode implements clusterNode{
   public String name;
   public int capacity,need,tank=0;
   public ArrayList<myClusterNode> leafs=new ArrayList<myClusterNode>();
   public void setNodeName(String name){
      this.name=name;
   }
   public void setCapacity(int capacity){
      this.capacity=capacity;
   }
   public void setNeed(int need){
      this.need=need;
   }
}