package doubly_linked_list;

public class DoublyLinkedList {

    // https://www.youtube.com/watch?v=rUP7SVIiRac&ab_channel=CSDojo

    private Node headSentinel;
    private Node tailSentinel;
    private int listSize = 0;

    public DoublyLinkedList() {
        headSentinel = new Node(null, null, null);
        tailSentinel = new Node(headSentinel, null, null);
        headSentinel.setNextNode(tailSentinel);
    }


    public void insertAtBeginningOfList(int data) {
        Node nodeSucceedingHeadSentinel = headSentinel.getNextNode();
        Node newNode = new Node(headSentinel, nodeSucceedingHeadSentinel, data);
        headSentinel.setNextNode(newNode);
        nodeSucceedingHeadSentinel.setPrevNode(newNode);
        listSize++;
    }


    public void insertAtEndOfList(int data) {
        Node nodePrecedingTailSentinel = tailSentinel.getPrevNode();
        Node newNode = new Node(nodePrecedingTailSentinel, tailSentinel, data);
        tailSentinel.setPrevNode(newNode);
        nodePrecedingTailSentinel.setNextNode(newNode);
        listSize++;

    }


    public void insertBetweenTwoNodes(int data, Node precedingNode, Node succeedingNode) {
        Node newNode = new Node(precedingNode, succeedingNode, data);
        precedingNode.setNextNode(newNode);
        succeedingNode.setPrevNode(newNode);
        listSize++;
    }

    public void findNodeWithParticularValue(int key) {
        if (isListEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node currentNode = headSentinel.getNextNode();
            int currentIndex = 0;
            do {
                if (currentNode.getData() == key) {
                    System.out.println(currentIndex);
                }
                currentNode = currentNode.getNextNode();
                currentIndex++;
            } while (currentNode != tailSentinel);

        }
    }


    public void deleteNode(Node nodeToBeDeleted) {
        Node precedingNode = nodeToBeDeleted.getPrevNode();
        Node succeedingNode = nodeToBeDeleted.getNextNode();
        precedingNode.setNextNode(succeedingNode);
        succeedingNode.setPrevNode(precedingNode);
        nodeToBeDeleted.setPrevNode(null);
        nodeToBeDeleted.setNextNode(null);
        listSize--;
    }


    public boolean isListEmpty() {
        return headSentinel.getNextNode() == tailSentinel;
    }


    public void deleteFirstNode() {
        if (isListEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node nodeToBeDeleted = headSentinel.getNextNode();
            Node nodeSucceedingNodeToBeDeleted = nodeToBeDeleted.getNextNode();
            headSentinel.setNextNode(nodeSucceedingNodeToBeDeleted);
            nodeToBeDeleted.setPrevNode(null);
            nodeToBeDeleted.setNextNode(null);
            nodeSucceedingNodeToBeDeleted.setPrevNode(headSentinel);
            listSize--;
        }
    }


    public void printList() {
        if (isListEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node currentNode = headSentinel.getNextNode();

            do {
                System.out.print(currentNode.getData() + "<-");
                currentNode = currentNode.getNextNode();
            } while (currentNode != tailSentinel);
        }

        System.out.println("\n " + listSize);
    }


    private static class Node {
        private Node prevNode;
        private Node nextNode;
        private Integer data;

        public Node() {
        }

        public Node(Node prevNode, Node nextNode, Integer data) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.data = data;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }
    }

}
