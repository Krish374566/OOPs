interface R {
    void powerOn();
    void powerOff();
    void changeChannel(int channel);
}

class TV implements R {
    public void powerOn() {
        System.out.println("TV is now on");
    }

    public void powerOff() {
        System.out.println("TV is off");
    }

    public void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }
}

public class RemoteTest {
    public static void main(String[] args) {
        R remote = new TV();

        remote.powerOn();
        remote.changeChannel(5);
        remote.powerOff();
    }
}
