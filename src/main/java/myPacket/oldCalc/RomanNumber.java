package myPacket.oldCalc;

public enum RomanNumber {
    I("1"), II("2"), III("3"),
    IV("4"), V("5"), VI("6"),
    VII("7"), VIII("8"), IX("9"),
    X("10");

    private String arabicNumber;

    RomanNumber(String arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public String getArabicNumber() {
        return arabicNumber;
    }
}