package Chapter16;

import java.util.ArrayList;

public class Exercise17
{
    /*
        Write a method called removeRange that accepts a starting and ending index
         as parameters and removes the elements at those indexes (inclusive) from the list.
         For example, if a variable list stores the values [8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92],
         the call of listRange.removeRange(3, 8); should remove values between index 3 and index 8
          (the values 4 and 7), leaving the list of [8, 13, 17, 23, 0, 92].  The Method
          should throw an IllegalArgumentException if either of the positions is negative. Otherwise you may assume
            that the positions represent a legal range of the list (0 􏰂 start 􏰂 end 􏰃 size).
     */

    public static ListNode front;

    public static void main(String[] args)
    {

        addNodeToList(0,8);
        addNodeToList(1,1);
        addNodeToList(2,17);
        addNodeToList(3,4);
        addNodeToList(4,3);
        addNodeToList(5,12);
        addNodeToList(6,55);
        addNodeToList(7,6);
        addNodeToList(8,7);
        addNodeToList(9,4);
        addNodeToList(10,0);
        addNodeToList(11,7);

        printList();
        removeRange(3,8);
        printList();

    }

    private static void removeRange(int start, int end)
    {
        ArrayList<Integer> holder = new ArrayList<>();

        for(ListNode current = front; current != null; current = current.next)
        {
            holder.add(current.data);
        }




        if(start < 0 || end < start || end > holder.size())
        {
            throw new IllegalArgumentException();
        }




        for (int i = start; i <= end; i++)
        {
            holder.remove(i);
            i--;
            end--;
        }

        for(ListNode current = front; front != null; current = current.next)
        {
            if ( current.next.next == null)
            {
                current.next = null;
            }
            if(current.next == null)
            {
                front = null;
            }
        }

        for (int i = 0; i < holder.size(); i++)
        {
            addNodeToList(i, holder.get(i));
        }
    }


    public static void addNodeToList(int index, int value)
    {
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1 ; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    public static void printList()
    {
        System.out.println("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]");
    }
}
