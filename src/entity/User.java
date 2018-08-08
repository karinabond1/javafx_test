package entity;

import DAO.UserControl;

public abstract class User implements Comparable<User> {
    private String name;
    private String otchestvo;
    private String famil;
    private String login;
    private String password;
    private String telefonOne;
    private String emeil;
    private UserState userState=UserState.Checking;
    private static UserControl userControl=new UserControl();

    public User(String login, String password, String emeil) throws CreateUserException {
    if(userControl.isValidateRegistrationData(login,password,emeil)){
        this.login = login;
        this.password = password;
        this.emeil = emeil;
    }else{
        throw new CreateUserException();
    }


    }

    @Override
    public int compareTo(User o) {
        return famil.compareToIgnoreCase(o.famil) * 11 +
                name.compareToIgnoreCase(o.name) * 111 +
                otchestvo.compareToIgnoreCase(o.otchestvo) * 1111;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getFamil() {
        return famil;
    }

    public void setFamil(String famil) {
        this.famil = famil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefonOne() {
        return telefonOne;
    }

    public void setTelefonOne(String telefonOne) {
        this.telefonOne = telefonOne;
    }

    public String getEmeil() {
        return emeil;
    }

    public void setEmeil(String emeil) {
        this.emeil = emeil;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public static UserControl getUserControl() {
        return userControl;
    }

    public static void setUserControl(UserControl userControl) {
        User.userControl = userControl;
    }
}
