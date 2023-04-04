public class SumpleteValue {
    enum State {
        TOTAL,
        MAYBE,
        NO,
        YES,
        CORNER
    }

    int val;
    State state;

    public SumpleteValue(int val, State state) {
        this.val = val;
        this.state = state;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        switch (state) {

            case CORNER:
                return " ";
            case TOTAL:
                return "[" + val + "]";

            case MAYBE:
                return "Uhh" + val;

            case NO:
                return "X" + val + "X";

            case YES:
                return "(" + val + ")";

        }
        return null;
    }
}
