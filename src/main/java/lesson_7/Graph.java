package main.java.lesson_7;




import java.util.*;

public class Graph {
    private final Map<Vertex, List<Pair<Vertex,Integer>>> map;

    public Graph() {
        map=new HashMap<>();
    }
    public void addVertex(Vertex v){
        map.putIfAbsent(v, new ArrayList<Pair<Vertex,Integer>>());
    }
    public void removeVertex(Vertex v){
        map.values().forEach(list -> list.remove(new Pair<Vertex,Integer>(v)));
        map.remove(v);
    }
    public void addEdge(Vertex root,Vertex child,int weight){
        map.get(root).add(new Pair<Vertex,Integer>(child,weight));
        map.get(child).add(new Pair<Vertex,Integer>(root,weight));

    }
    public void removeEdge(Vertex root,Vertex child){
        List<Pair<Vertex, Integer>> ev1 = map.get(root);
        List<Pair<Vertex, Integer>> ev2 = map.get(child);
        if (ev1 != null) {
            ev1.remove(new Pair<Vertex,Integer>(root));
        }
        if (ev2 != null) {
            ev2.remove(new Pair<Vertex,Integer>(child));
        }
    }
    public Set<Pair<Vertex,Integer>> deepFirstSearch(Vertex root,Vertex end){
        Set<Pair<Vertex,Integer>> visited = new LinkedHashSet<>();
        Stack<Pair<Vertex,Integer>> stack = new Stack<>();
        stack.push(new Pair<Vertex,Integer>(root,0));
        while (!stack.empty()){
            Pair<Vertex,Integer> pair = stack.pop();
            if (!visited.contains(pair)) {
                visited.add(pair);
                map.get(pair.getValue()).forEach(stack::push);

            }
            if (pair.getValue()==end)break;
        }
        return visited;
    }
    public  int[] Dijkstra(Vertex root,Vertex end){
        int[] distance =new int[map.size()];
        for (int i = 1; i < distance.length; i++) {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[0]=0;
        Set<Pair<Vertex,Integer>> visited = new LinkedHashSet<>();
        PriorityQueue<Pair<Vertex,Integer> >queue=new PriorityQueue<>(Comparator.comparingInt(Pair::getValue2));
        queue.add(new Pair<>(root,0));
        while (!queue.isEmpty()){
            Pair<Vertex,Integer> pair= queue.remove();
            int u =pair.getValue().getId();
            visited.add(pair);
            map.get(pair.getValue()).forEach(p->{
                if (!visited.contains(p)){
                    int new_distance=distance[u]+p.getValue2();
                    if (new_distance<distance[p.getValue().getId()]){
                        distance[p.getValue().getId()]=new_distance;
                        queue.add(new Pair<Vertex,Integer>(p.getValue(),distance[p.getValue().getId()]));
                    }
                }
            });

        }
        return distance;
    }

}
