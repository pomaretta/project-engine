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

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Carlos Pomares
 */

public class Collider {

    private double minX,minY,maxX,maxY;
    private double posX, posY;
    private boolean collision;

    private boolean trigger;
    private boolean upperLimit, lowerLimit, leftLimit, rightLimit;

    public Collider(){}

    public Collider(double minX, double minY, double maxX, double maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
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

        // UPPER LIMIT
        /*if(this.posX < (collider.posX + collider.maxX))
            upperLimit = true;*/

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
            this.posY <= (collider.posY)
        );
    }

    public static void collision(GameEntity v, GameEntity v1){
        if(v.getCollider().intersects(v1.getCollider())){
            v.getCollider().collision = true;
            /*if(v.getCollider().intersectsUpper(v1.getCollider()))
                v.getCollider().upperLimit = true;
            if(v.getCollider().intersectsLower(v1.getCollider()))
                v.getCollider().lowerLimit = true;*/
        } else {
            v.getCollider().collision = false;
            /*v.getCollider().upperLimit = false;
            v.getCollider().lowerLimit = false;*/
        }
    }

    public static void checkCollisions(GameScene gameScene){
        for(GameEntity gameEntity : gameScene.getEntities()){
            for (GameEntity gameEntity1 : gameScene.getEntities()){
                if(!gameEntity.equals(gameEntity1))
                    Collider.collision(gameEntity,gameEntity1);
            }

            /*System.out.println("--- COLLISION BLOCK ---");

            System.out.println(
                    String.format(
                            "ENTITY 1: %s -- X: %s -- Y: %s -- W: %s -- H: %s"
                            ,gameEntity
                            ,gameEntity.getCollider().getPosX()
                            ,gameEntity.getCollider().getPosY()
                            ,gameEntity.getCollider().getMaxX()
                            ,gameEntity.getCollider().getMaxY()
                    )
            );

            System.out.println(
                    String.format(
                            "ENTITY 2: %s -- X: %s -- Y: %s -- W: %s -- H: %s"
                            ,gameEntity1
                            ,gameEntity1.getCollider().getPosX()
                            ,gameEntity1.getCollider().getPosY()
                            ,gameEntity1.getCollider().getMaxX()
                            ,gameEntity1.getCollider().getMaxY()
                    )
            );

            System.out.println("--- END BLOCK ---");*/

        }
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
