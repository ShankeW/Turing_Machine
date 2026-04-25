public class ImageFunction extends Functions{
    private int Head;

    public ImageFunction(int State, int Alphabet, int Head){
        super(State, Alphabet);
        this.Head = Head;
    }

    public int getHead() {
        return Head;
    }
}
