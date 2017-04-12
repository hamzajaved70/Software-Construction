package lab7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authenticate")
public class Authentication{
    @Id
    @Column(name = "userId")
    String userId;
    @Column(name = "scheme")
    String scheme;
    @Column(name = "timeTaken")
    double timeTaken;
    @Column(name = "state")
    String state;
    @Column(name = "tc1")
    double tc1;
    @Column(name = "s1")
    String s1;
    @Column(name = "tc2")
    double tc2;
    @Column(name = "s2")
    String s2;
    @Column(name = "tc3")
    double tc3;
    @Column(name = "s3")
    String s3;
    @Column(name = "tc4")
    double tc4;
    @Column(name = "s4")
    String s4;
    @Column(name = "tc5")
    double tc5;
    @Column(name = "s5")
    String s5;
    @Column(name = "tc6")
    double tc6;
    @Column(name = "s6")
    String s6;
    @Column(name = "tc7")
    double tc7;
    @Column(name = "s7")
    String s7;

    public Authentication(){}
    
    public Authentication(String userId, String scheme, double timeTaken, String state, double tc1, String s1, double tc2, String s2, double tc3, String s3, double tc4, String s4, double tc5, String s5, double tc6, String s6, double tc7, String s7) {
        this.userId = userId;
        this.scheme = scheme;
        this.timeTaken = timeTaken;
        this.state = state;
        this.tc1 = tc1;
        this.s1 = s1;
        this.tc2 = tc2;
        this.s2 = s2;
        this.tc3 = tc3;
        this.s3 = s3;
        this.tc4 = tc4;
        this.s4 = s4;
        this.tc5 = tc5;
        this.s5 = s5;
        this.tc6 = tc6;
        this.s6 = s6;
        this.tc7 = tc7;
        this.s7 = s7;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTc1() {
        return tc1;
    }

    public void setTc1(double tc1) {
        this.tc1 = tc1;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public double getTc2() {
        return tc2;
    }

    public void setTc2(double tc2) {
        this.tc2 = tc2;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public double getTc3() {
        return tc3;
    }

    public void setTc3(double tc3) {
        this.tc3 = tc3;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public double getTc4() {
        return tc4;
    }

    public void setTc4(double tc4) {
        this.tc4 = tc4;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public double getTc5() {
        return tc5;
    }

    public void setTc5(double tc5) {
        this.tc5 = tc5;
    }

    public String getS5() {
        return s5;
    }

    public void setS5(String s5) {
        this.s5 = s5;
    }

    public double getTc6() {
        return tc6;
    }

    public void setTc6(double tc6) {
        this.tc6 = tc6;
    }

    public String getS6() {
        return s6;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }

    public double getTc7() {
        return tc7;
    }

    public void setTc7(double tc7) {
        this.tc7 = tc7;
    }

    public String getS7() {
        return s7;
    }

    public void setS7(String s7) {
        this.s7 = s7;
    }
}
