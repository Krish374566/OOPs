class Club {
    static String clubName = "Chess Club";
    String memberName;

    Club(String memberName) {
        this.memberName = memberName;
    }

    static void displayClubName() {
        System.out.println("Club Name: " + clubName);
    }

    void displayMemberInfo() {
        System.out.println("Member Name: " + memberName + ", Club: " + clubName);
    }
}
