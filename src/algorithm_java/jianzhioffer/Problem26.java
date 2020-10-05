package algorithm.jianzhioffer;

public class Problem26 {

    public static ComplexLinkNode<Integer> copyComplexLinkList(ComplexLinkNode<Integer> root) {
        ComplexLinkNode<Integer> p = root;
        while (p != null) {
            ComplexLinkNode<Integer> next = p.getNext();
            ComplexLinkNode<Integer> newNode = new ComplexLinkNode<>(p.getData());
            p.setNext(newNode);
            newNode.setNext(next);
            p = next;
        }
        p = root;
        while (p != null) {
            ComplexLinkNode<Integer> any = p.getAny();
            ComplexLinkNode<Integer> next = p.getNext().getNext();
            p.getNext().setAny(any.getNext());
            p = next;
        }
        p = root;
        ComplexLinkNode<Integer> copyp = root.getNext();
        ComplexLinkNode<Integer> copyRoot = copyp;
        p.setNext(p.getNext().getNext());
        copyp.setNext(copyp.getNext().getNext());
        p = p.getNext();
        copyp = copyp.getNext();
        while (p != null) {
            p.setNext(p.getNext().getNext());
            if (copyp.getNext() == null)
                copyp.setNext(null);
            else
                copyp.setNext(copyp.getNext().getNext());
            p = p.getNext();
            copyp = copyp.getNext();
        }
        return copyRoot;
    }

    public static void main(String[] args) {
        ComplexLinkNode<Integer> a = new ComplexLinkNode<>(1);
        ComplexLinkNode<Integer> b = new ComplexLinkNode<>(2);
        ComplexLinkNode<Integer> c = new ComplexLinkNode<>(3);
        ComplexLinkNode<Integer> d = new ComplexLinkNode<>(4);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        a.setAny(c);
        b.setAny(d);
        c.setAny(a);
        d.setAny(b);
        ComplexLinkNode<Integer> copy = copyComplexLinkList(a);
        System.out.println("end");
    }
}
