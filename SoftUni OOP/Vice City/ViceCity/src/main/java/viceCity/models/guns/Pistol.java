package viceCity.models.guns;

public class Pistol extends BaseGun {
    public Pistol(String name) {
        super(name, 10, 90);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel()<=0){
            setBulletsPerBarrel(10);
            setTotalBullets(getTotalBullets()-10);
        }
        setBulletsPerBarrel(getBulletsPerBarrel()-1);
        return 1;
    }
}
