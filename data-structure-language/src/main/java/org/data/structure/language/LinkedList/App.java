package org.data.structure.language.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     LinkedList<Integer> ill = new LinkedList<Integer>(33);
     ill.append(11);
     ill.printList();
     ill.prepend(1);
     ill.printList();
     ill.reverse();
     ill.printList();
    }
}
