package viceCity.models.guns;

public class Rifle extends BaseGun{
    public Rifle(String name) {
        super(name, 50, 450);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel()<=0){
            setBulletsPerBarrel(50);
            setTotalBullets(getTotalBullets()-50);
        }
        setBulletsPerBarrel(getBulletsPerBarrel()-5);
        return 5;
    }
}
