package Physics;

/*

    Project     project-engine
    Package     Physics    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-27

    DESCRIPTION
    
*/

import Objects.GameEntity;
import Objects.GameScene;
import Objects.Vector2D;

/**
 * @author Carlos Pomares
 */

public class Collider {

    private static Enum tags;

    private double minX,minY,maxX,maxY;
    private double posX, posY;
    private boolean collision;
    private Enum tag;

    private Enum from;
    private Enum to;

    private boolean trigger = false;
    private boolean upperLimit, lowerLimit, leftLimit, rightLimit;

    public Collider(){}

    public Collider(double minX, double minY, double maxX, double maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public Collider(Vector2D vector2D){
        this.minX = vector2D.getMinX();
        this.minY = vector2D.getMinY();
        this.maxX = vector2D.getMaxX();
        this.maxY = vector2D.getMaxY();
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public boolean isCollision(){
        return this.collision;
    }

    public void setSize(double v, double v1, double v2, double v3){
        setMaxX(v);
        setMaxY(v1);
        setMinX(v2);
        setMinY(v3);
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    public void setPosX(double v){
        this.posX = v;
    }

    public void setPosY(double v){
        this.posY = v;
    }

    public void setPosition(double v, double v1){
        this.posX = v;
        this.posY = v1;
    }

    public void setTag(Enum t){
        this.tag = t;
    }

    public Enum getTag(){
        return this.tag;
    }

    public Enum getCollisionTo(){
        return this.to;
    }

    public Enum getCollisionFrom(){
        return this.from;
    }

    public void updatePosition(double v, double v1){
        this.posX = v;
        this.posY = v1;
    }

    public boolean isUpperLimit(){
        return upperLimit;
    }

    public boolean isLeftLimit() {
        return leftLimit;
    }

    public boolean isRightLimit() {
        return rightLimit;
    }

    public boolean isLowerLimit(){
        return lowerLimit;
    }

    public boolean intersects(Collider collider){
        return (
            this.posX <= (collider.posX + collider.maxX)
                &&
            (this.posX + this.maxX) >= collider.posX
                &&
            this.posY <= (collider.posY + collider.maxY)
                &&
            (this.posY + this.maxY) >= collider.posY
        );
    }

    public boolean intersectsUpper(Collider collider){
        return (
            this.posY >= (collider.posY)
        );
    }

    public boolean intersectsLower(Collider collider){
        return (
            this.posY <= (collider.posY + collider.maxY)
        );
    }

    public boolean intersectsLeft(Collider collider){
        return (
            this.posX >= (collider.posX + collider.maxX)
        );
    }

    public boolean intersectsRight(Collider collider){
        return (
            (this.posX + this.maxX) <= collider.posX
        );
    }

    public static boolean handleCollision(GameEntity v, GameEntity v1){
        if(v.getCollider().intersects(v1.getCollider())){
            v.getCollider().collision = true;

            v.getCollider().from = v1.getCollider().getTag();
            v1.getCollider().to = v.getCollider().getTag();

            if(v.getCollider().intersectsUpper(v1.getCollider())){
                v.getCollider().upperLimit = true;
            } else {
                v.getCollider().upperLimit = false;
            }

            if(v.getCollider().intersectsLower(v1.getCollider())) {
                v.getCollider().lowerLimit = true;
            } else {
                v.getCollider().lowerLimit = false;
            }

            if(v.getCollider().intersectsLeft(v1.getCollider())){
                v.getCollider().leftLimit = true;
            } else {
                v.getCollider().leftLimit = false;
            }

            if(v.getCollider().intersectsRight(v1.getCollider())){
                v.getCollider().rightLimit = true;
            } else {
                v.getCollider().rightLimit = false;
            }

            return true;
        } else {
            v.getCollider().collision = false;
            v.getCollider().upperLimit = false;
            v.getCollider().lowerLimit = false;
            v.getCollider().leftLimit = false;
            v.getCollider().rightLimit = false;
            v.getCollider().from = null;
            v.getCollider().to = null;
            return false;
        }
    }

    public static void checkCollisions(GameScene gameScene){
        for(GameEntity gameEntity : gameScene.getEntities()){
            for(GameEntity gameEntity1 : gameScene.getEntities()){
                if(!gameEntity.equals(gameEntity1) && gameEntity.isColliderActive() && gameEntity1.isColliderActive()){
                    if(handleCollision(gameEntity,gameEntity1))
                        break;
                }
            }
        }
    }

    public static void setTags(Enum e){
        tags = e;
    }

    public static Enum getTags(){
        return tags;
    }

    @Override
    public String toString() {
        return "Collider{" +
                "minX=" + minX +
                ", minY=" + minY +
                ", maxX=" + maxX +
                ", maxY=" + maxY +
                ", posX=" + posX +
                ", posY=" + posY +
                ", collision=" + collision +
                ", trigger=" + trigger +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                ", leftLimit=" + leftLimit +
                ", rightLimit=" + rightLimit +
                '}';
    }

}
