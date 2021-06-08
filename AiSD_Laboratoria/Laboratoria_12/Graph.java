package AiSD_Laboratoria.Laboratoria_12;

import java.util.*;

public class Graph {
    private Lista<Integer>[] adj;
    private int[] dist;
    private Set<Integer> settled;
    private Queue<Element<Integer>> pq;
    private static int time = 0;
    private String[] names;

    public Graph(String[] names, int[] begin, int[] end, int[] weight) {
        this.names = names;
        adj = new Lista[names.length];
        dist = new int[names.length];
        settled = new HashSet<>();
        pq = new PriorityQueue<>(names.length,new elemComparator());
        String line;

        for (int i = 0; i < begin.length; i++) {

            int v = begin[i];
            int w = end[i];
            int weig = weight[i];

            if (adj[v] == null) adj[v] = new Lista<>();
            adj[v].add(adj[v].size(), w, weig);
        }

        Arrays.fill(dist, Integer.MAX_VALUE); //poczatkowo dystans do kazdego wierzcholka jest infinity
    }


    public void dijkstra(int src) {
        pq.add(new Element<Integer>(src,0));

        dist[src] = 0;
        while (settled.size() != adj.length && !pq.isEmpty()) {
            int u = pq.poll().getValue();
            settled.add(u);

            neighbours(u);
        }

        System.out.println("Wszystkie miasta osiągalne z " + names[src] + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < Integer.MAX_VALUE){
                System.out.println(names[i] + ", długość najkrótszej ścieżki: " + dist[i]);
            }
        }
    }

    private void neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        if(adj[u] == null)
            return;
        Iterator<Element> it = adj[u].iterator();

        while (it.hasNext()) {
            Element<Integer> v = (Element<Integer>) it.next();

            if (!settled.contains(v.getValue())) {
                edgeDistance = v.getWeight();
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.getValue()])
                    dist[v.getValue()] = newDistance;
                pq.add(new Element<Integer>(v.getValue(), dist[v.getValue()]));
            }
        }

    }

    private class elemComparator implements Comparator<Element<Integer>>{
        @Override
        public int compare(Element o1, Element o2) {
            if(o1.getWeight() > o2.getWeight())
                return 1;
            if(o1.getWeight() < o2.getWeight())
                return -1;
            return 0;
        }
    }

    public void DFS(){
        time = 0;
        int numOfV = adj.length;
        int[] color = new int[numOfV]; // 0 - WHITE, 1 - GRAY, 2 - BLACK
        int[] p = new int[numOfV];
        int[] t = new int[numOfV];
        int[] f = new int[numOfV];

        for (int i = 0; i < numOfV; i++) {
            color[i] = 0;
            p[i] = 0;
        }

        for (int u = 0; u < numOfV; u++) {
            if (color[u] == 0) DFS_Visit(u, color, p, t, f);
        }
    }

    private void DFS_Visit(int u, int[] color, int[] p, int[] t, int[] f){
        System.out.print(u + " ");
        color[u] = 1;
        time++;
        t[u] = time;
        if (adj[u] != null){
            Iterator<Element> iterator = adj[u].iterator();

            while (iterator.hasNext()){
                Element element = iterator.next();
                if (color[(int) element.getValue()] == 0){
                    p[(int) element.getValue()] = u;
                    DFS_Visit((int) element.getValue(), color, p, t, f);
                    System.out.print( u + " ");
                }
            }
        }

        color[u] = 2;
        f[u] = ++time;

    }

    public void graphPrint(){
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + "[ ");
            if (adj[i] != null){
                Iterator<Element> iterator = adj[i].iterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().getValue() + " ");
                }

            }
            System.out.println("]");

        }
    }

    public int[] getDist() {
        return dist;
    }
}
