package algorithm.jianzhioffer;

public class ComplexLinkNode<T> {

    private T data = null;
    private ComplexLinkNode<T> next = null;
    private ComplexLinkNode<T> any = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ComplexLinkNode<T> getNext() {
        return next;
    }

    public void setNext(ComplexLinkNode<T> next) {
        this.next = next;
    }

    public ComplexLinkNode<T> getAny() {
        return any;
    }

    public void setAny(ComplexLinkNode<T> any) {
        this.any = any;
    }

    public ComplexLinkNode(T data) {
        this.data = data;
    }
}
