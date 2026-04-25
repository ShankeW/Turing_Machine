import java.util.Objects;

public class Functions {
    private int State;
    private int Alphabet;

    public Functions(int State, int Alphabet){
        this.State = State;
        this.Alphabet = Alphabet;
    }

    public int getState() {
        return State;
    }

    public int getAlphabet() {
        return Alphabet;
    }

    public String toString(){
        return "(" + State + ", " + Alphabet + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(State, Alphabet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Functions toCompare = (Functions) o;
        return (State == toCompare.getState() && Alphabet == toCompare.getAlphabet());
    }
}
