import org.junit.Test;

public class LinkedDemo {
    @Test
    public void entrance1() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calcWater(arr, 0));
    }

    private int calcWater(int[] arr, int startIndex) {
        int rst = 0;
        int flag = 0;
        for (int i = startIndex; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1] && flag == 0) {
                startIndex = i;
                flag = 1;
                System.out.println("startIndex:" + startIndex);
            } else if (arr[i] <= arr[i + 1] && flag == 1) {
                flag = 2;
            } else if (arr[i] >= arr[i + 1] && flag == 2) {
                if (arr[i - 1] < arr[i]) {
                    int count = i - startIndex - 1;
                    int height = Math.min(arr[startIndex], arr[i]);
                    rst += height * count;
                    for (int j = startIndex+1; j < i; j++) {
                        rst -= arr[j];
                    }
                }
                startIndex = i;
                if (arr[i] > arr[i + 1]) {
                    flag = 1;
                    System.out.println("startIndex:" + startIndex);
                }
            }
        }
        return rst;
    }

    @Test
    public void entrance() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        LinkedNode<Integer> head = construct(arr);
        System.out.println("head print:");
        ;
        print(head);

        LinkedNode<Integer> reverseHead = reverse(head);
        System.out.println("reverseHead print:");
        ;
        System.out.println(head.t);
        System.out.println("reverseHead print1:");
        ;
        print(reverseHead);
    }

    private void print(LinkedNode<Integer> node) {
        LinkedNode<Integer> tmp = node;
        while (tmp != null) {
            System.out.println(tmp.t);
            tmp = tmp.next;
        }
    }

    private LinkedNode<Integer> construct(Integer[] arr) {
        LinkedNode<Integer> head = new LinkedNode<>();
        LinkedNode<Integer> pointer = head;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head.t = arr[i];
            } else {
                pointer.next = new LinkedNode<>(arr[i]);
                pointer = pointer.next;
            }
        }
        return head;
    }

    private LinkedNode<Integer> reverse(LinkedNode<Integer> ll) {
        LinkedNode<Integer> pointer = ll.next;
        ll.next = null;
        while (pointer != null) {
            LinkedNode<Integer> tmp = pointer;
            pointer = pointer.next;
            tmp.next = ll;
            ll = tmp;
        }
        return ll;
    }
}


class LinkedNode<T> {
    public T t;
    public LinkedNode<T> next;

    public LinkedNode(T t) {
        this.t = t;
    }

    public LinkedNode() {
    }
}
