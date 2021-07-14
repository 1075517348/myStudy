package my.InterfaceInfo;


class Derived extends Base {
    int value;

    Derived(int val) {
        value = val;
        System.out.println("Derived" + value);
    }

    public void print() {
        System.out.println("Derivedprint");

    }
}
