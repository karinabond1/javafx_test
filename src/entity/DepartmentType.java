package entity;

public enum DepartmentType {
    Institut(5), Fakultet(10), Kafedra(15), StudentGryp(20), Viddil(30);
int type;
    DepartmentType(int i) {
    this.type=i;
    }
}
