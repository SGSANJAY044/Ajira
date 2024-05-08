import java.util.*;
import cluster.myClusterNode;
import cluster.link;
class Main extends link{
    static int total=0;
    static void surviveWater(myClusterNode federal){
       for(myClusterNode node: federal.leafs){ 
            int subtotal=0,LineTotal=0;
            while(true){
                subtotal+=node.capacity;
                if(node.need>node.tank){
                    node.tank=node.capacity;
                    LineTotal=subtotal;
                }
                node.tank-=node.need;
                if(node.leafs.size()<=0) break;
                node=node.leafs.get(0);
            }
            total+=LineTotal;
       }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int surviveDays=sc.nextInt();
        int clustersCount=sc.nextInt();
        myClusterNode federal =new myClusterNode();    
        sc.nextLine(); // For empty line
        
        HashMap<String,myClusterNode> clusters=new HashMap<String,myClusterNode>();
        clusters.put("F",federal);
        for(int i=0;i<clustersCount;i++){
            myClusterNode node =new myClusterNode();
            String nodeName=sc.next();
            node.setNodeName(nodeName);
            
            node.setNeed(sc.nextInt());
            node.setCapacity(sc.nextInt());
            clusters.put(nodeName,node);
            sc.nextLine();  // For empty line
        }

        int linkCount = sc.nextInt();
        sc.nextLine();  // For empty line;

        String[] linkLines=new String[linkCount];
        for(int i=0;i<linkCount;i++){
            linkLines[i]=sc.nextLine();
        }
        setLink(clusters,linkLines);
        for(int i=0;i<surviveDays;i++){
            surviveWater(federal);
        }
        System.out.println(total);
    }
}