package entity;

public enum UserState {
    Checking(0),Worked(1),Blocked(2);
    int state;
    UserState(int i) {
    this.state=i;
    }
}
