/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/



class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node temp = head;
        Node ans = new Node(temp.val);
        temp = temp.next;
        List<Node> al = new ArrayList<>();
        al.add(ans);
        Node prev = ans;
        HashMap<Node,Integer> hm = new HashMap<>();
        int counter = 0;
        hm.put(head,counter);
        while(temp!=null){
            Node create = new Node(temp.val);
            prev.next = create;
            prev = prev.next;
            al.add(create);
            hm.put(temp,++counter);
            // System.out.print(hm);
            temp = temp.next;
        }
        System.out.println(hm);

        Node ansIte = ans;
        Node quesIte = head;
        while(quesIte!=null){
            Node ran = quesIte;
            if(ran.random != null){
                System.out.println(ran.random);
                Integer key = hm.get(ran.random);
                System.out.println(key);
                ansIte.random = key!=null?al.get(key):null;
            }
            quesIte = quesIte.next;
            ansIte = ansIte.next;
        }
        return ans;
    }
}